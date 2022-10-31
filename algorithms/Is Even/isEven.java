/**
 * Code to determine if integers (passed as command-line arguments) are even
 * 
 * This code is intentionally written "enterprise-grade" (air quotes), aka way
 * too many classes are used to accomplish what a 10-line program can do too.
 * DO NOT use it as an example of how to write future code!
 * 
 * On the other hand, this could be made infinitely more unwieldy if desired.
 */
public class isEven {

	public static void main(String[] args) {
		ArrayIterator<String> ai = new ArrayIterator<String>(args);
		ErrorHandler eh = new RethrowErrorHandler();
		InputService is = new IntegerInputService(eh);
		TransformationService<Integer, Integer> ts1 = new ModuloTwoTransformationService();
		TransformationService<Integer, Boolean> ts2 = new EqualityTransformationService<Integer>(0);
		TransformationService<Integer, Boolean> ts = TransformationService.compose(ts1, ts2);
		StringFormatter sf = new StringFormatter();
		OutputService os = new PrintOutputService();
		ai.iterate(s -> {
			is.doInput(s);
			int i = (Integer) is.getInput();
			boolean b = ts.transform(i);
			String o = sf.output(i, b);
			os.doOutput(o);
		});
	}

}

interface InputService {
	void doInput(String s);
	Object getInput();
}

class IntegerInputService implements InputService {
	private final ErrorHandler eh;
	private int i;
	public IntegerInputService(ErrorHandler eh) {
		this.eh = eh;
	}
	public void doInput(String s) {
		try {
			i = Integer.parseInt(s);
		} catch (Exception e) {
			eh.handleError(e);
		}
	}
	public Object getInput() {
		return i;
	}
}

interface TransformationService<T, U> {
	public U transform(T t);
	public static <T, U, V> TransformationService<T, V> compose(TransformationService<T, U> t1, TransformationService<U, V> t2) {
		return (T t) -> t2.transform(t1.transform(t));
	}
}

class ModuloTwoTransformationService implements TransformationService<Integer, Integer> {
	public Integer transform(Integer i) {
		return i % 2;
	}
}

class EqualityTransformationService<T> implements TransformationService<T, Boolean> {
	private final T x;
	public EqualityTransformationService(T x) {
		this.x = x;
	}
	public Boolean transform(T i) {
		return x.equals(i);
	}
}

class StringFormatter {
	public static final String OUTPUT = "%d is %s.", EVEN = "even", ODD = "odd";
	public String output(int i, boolean b) {
		return String.format(OUTPUT, i, b ? EVEN : ODD);
	}
}

interface OutputService {
	public void doOutput(String s);
}

class PrintOutputService implements OutputService {
	public void doOutput(String s) {
		System.out.println(s);
	}
}

class ArrayIterator<T> {
	private final T[] a;
	public ArrayIterator(T[] a) {
		this.a = a;
	}
	public void iterate(Handler<T> h) {
		for (T t : a) h.handle(t);
	}
	public static interface Handler<T> {
		public void handle(T t);
	}
}

interface ErrorHandler {
	void handleError(Exception e);
}

class RethrowErrorHandler implements ErrorHandler {
	private static <E extends Throwable> void sneakyThrow(Throwable e) throws E {
		throw (E) e;
	}
	public void handleError(Exception e) {
		sneakyThrow(e);
	}
}
