Libreria para recibir las entradas; reemplaza el Scanner original, mejorando su eficiencia. 
Contiene los metodos next, nextLine y hasNext. Para recibir datos numericos parsear el string leido.

static class Scanner {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer("");
	int spaces = 0;

	public String nextLine() throws IOException {
		if (spaces-- > 0) return "";
		else if (st.hasMoreTokens()) return new StringBuilder(st.nextToken("\n")).toString();
		return br.readLine();
	}

	public String next() throws IOException {
		spaces = 0;
		while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public boolean hasNext() throws IOException {
		while (!st.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null) return false;
			if (line.equals("")) spaces = Math.max(spaces, 0) + 1;
			st = new StringTokenizer(line);
		}
		return true;
	}
}
