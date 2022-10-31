Busca el string p en el string s (definido en init), y retorna un int[2] con el primer y ultimo indice del suffix array que coinciden con la busqueda. Si no se encuentra, retorna [-1, -1]. Debe inicializarse m con el tamaño de p, y debe ejecutarse previamente suffixArray() de Suffix Array Init.java.

static String p;
static int m;

static int[] stringMatching() {
  int[] ans = {-1, -1};
  if(m - 1 > n) return ans;
  char [] _p = p.toCharArray();
  int l = 0, h = n - 1, c = l;
  while (l < h) {
    c = (l + h) / 2;
    if(strncmp(_s, sa[c], _p) >= 0) h = c;
    else l = c + 1;
  }
  if (strncmp(_s, sa[l], _p) != 0) return ans;
  ans[0] = l;
  l = 0; h = n - 1; c = l;
  while (l < h) {
    c = (l + h) / 2;
    if (strncmp(_s, sa[c], _p) > 0) h = c;
    else l = c + 1;
  }
  if (strncmp(_s, sa[h], _p) != 0) h--;
  ans[1] = h;
  return ans;
} 