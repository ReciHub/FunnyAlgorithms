Dado un string s retorna un ArrayList lps donde lps[i] es el largo del prefijo propio más largo que tambien es sufijo de s[0] hasta s[i].
*Para retornar el vector de suffix_link quitar el comentario (//).

static ArrayList<Integer> prefix_function(String s) {
    int n = s.length(), len = 0, i = 1;
    ArrayList<Integer> lps = new ArrayList<>();
    Collections.fill(lps, n);
    lps.set(len, 0);
    while (i < n) {
        if (s.charAt(len) != s.charAt(i)) {
            if (len > 0) len = lps.get(len-1);
            else lps.set(i++, len);
        } else lps.set(i++, ++len);
    }
    //lps.add(0, -1); //Para SuffixLink
    return lps;
}
