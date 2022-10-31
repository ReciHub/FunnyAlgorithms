Busca el string p en el string s (definido en init), y retorna true si se encuentra, o false en caso contrario. Debe inicializarse m con el tamaño de p, y debe ejecutarse previamente suffixArray() de Suffix Array Init.java.

static String p;
static int m;

static boolean stringMatching() {
  if(m - 1 > n) return false;
  char [] _p = p.toCharArray();
  int l = 0, h = n - 1, c = l;
  while (l <= h) {
    c = (l + h) / 2;
    int r = strncmp(_s, sa[c], _p);
    if(r > 0) h = c - 1;
    else if(r < 0) l = c + 1;
    else return true;
  }
  return false;
}