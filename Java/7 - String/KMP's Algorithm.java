Encuentra si el string pattern se encuentra en el string cadena. Debe estar definido el método prefix_function.

import java.util.ArrayList;

static boolean kmp(String cadena, String pattern) {
	int n=cadena.length();
	int m=pattern.length();
	ArrayList<Integer> tab=prefix_function(pattern);

	for(int i = 0, seen = 0; i < n; i++) {
		while(seen > 0 && cadena.charAt(i) != pattern.charAt(seen)) {
			seen = tab.get(seen-1);
		}
		if(cadena.charAt(i) == pattern.charAt(seen)) seen++;
		if(seen == m) return true;
	}
	return false;
}
