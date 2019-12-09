Dados dos Strings, encuentra el largo de la subsecuencia en común mas larga entre ellas.


static int M_MAX = 20; // Máximo size del String 1
static int N_MAX = 20; // Máximo size del String 2 
static int m, n; // Size de Strings 1 y 2
static char X[]; // toCharArray del String 1
static char Y[]; // toCharArray del String 2
static int memo[][] = new int[M_MAX + 1][N_MAX + 1];

static int lcs (int m, int n) {
  for (int i = 0; i <= m; i++) {
    for (int j = 0; j <= n; j++) {
      if (i == 0 || j == 0) memo[i][j] = 0;
      else if (X[i - 1] == Y[j - 1]) memo[i][j] = memo[i - 1][j - 1] + 1;
      else memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
    }
  }
  return memo[m][n];
}