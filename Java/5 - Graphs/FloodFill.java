Dado un grafo implicito como matriz, "colorea" y cuenta el tamaño de las componentes conexas.
Este método debe ser llamado con las coordenadas (i, j) donde se inicia el recorrido, busca cada caracter c1 de la componente, los remplaza por el caracter c2 y retorna el tamaño.

static final int tam = 1000; //Tamanio maximo de la matriz
static int dy[] = {1,1,0,-1,-1,-1, 0, 1}; //Posibles movimientos:
static int dx[] = {0,1,1, 1, 0,-1,-1,-1}; //  (8 direcciones)
static char grid[][] = new char[tam][tam]; //Matriz de caracteres
static int Y, X; //Tamanio de la matriz

static int floodfill(int y, int x, char c1, char c2) {
    if (y < 0 || y >= Y || x < 0 || x >= X) return 0;
    if (grid[y][x] != c1) return 0;
    grid[y][x] = c2;
    int ans = 1;
    for (int i = 0; i < 8; i++) {
        ans += floodfill(y + dy[i], x + dx[i], c1, c2);
    }
    return ans;
}
