Crea el suffix array. Deben inicializarse las variables s (String original), N_MAX (Máximo size que puede tener s), y n (Size del string actual).

static String s;
static int N_MAX = 30; 
static int n;
static char _s[];
static int sa[] = new int[N_MAX]; 
static int rk[] = new int[N_MAX];
static long rk2[] = new long[N_MAX];

static List<Integer> wrapper = new AbstractList<Integer>() {
  @Override
  public Integer get(int i) { return sa[i]; }

  @Override
  public int size() { return n; }

  @Override
  public Integer set(int i, Integer e) { 
      int v = sa[i];
      sa[i] = e;
      return v;
  }
};

static void suffixArray() {
  _s = s.toCharArray();
  for (int i = 0; i < n; i++) {
    sa[i] = i; rk[i] = _s[i]; rk2[i] = 0;
  }
  for (int l = 1; l < n; l <<= 1) {
    for (int i = 0; i < n; i++) {
      rk2[i] = ((long) rk[i] << 32) + (i + l < n ? rk[i + l] : -1);
    }
    Collections.sort(wrapper, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
          if(rk2[o1.intValue()] > rk2[o2.intValue()]) return 1;
          else if(rk2[o1.intValue()] == rk2[o2.intValue()]) return 0;
          else return -1;
        }
    });
    for (int i = 0; i < n; i++) {
      if (i > 0 && rk2[sa[i]] == rk2[sa[i - 1]]) 
        rk[sa[i]] = rk[sa[i - 1]]; 
      else rk[sa[i]] = i;
    }
  }
}