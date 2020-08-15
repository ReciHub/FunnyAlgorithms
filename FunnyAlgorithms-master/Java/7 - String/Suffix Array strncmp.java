Método utilitario. Necesario para las dos versiones de Matching.

static int strncmp(char[] a, int i, char[] b) {
  for (int k = 0; i + k < a.length && k < m - 1; k++) {
      if (a[i + k] != b[k]) return a[i + k] - b[k];
  }
  return 0;
}