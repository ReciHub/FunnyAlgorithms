Busca el substring común mas largo entre dos strings. Retorna un int[2], con el size del substring y uno de los indices del suffix array. Debe ejecutarse previamente suffixArray() y calculateLCP()

// Los substrings deben estar concatenados de la forma "string1#string2$", antes de ejecutar suffixArray() y calculateLCS()
// m debe almacenar el size del string2.

static int[] longestCommonSubstring() {
  int i, ans[] = new int[2]; 
  ans[0] = -1; ans[1] = 0;
  for (i = 1; i < n; i++) {
    if (((sa[i] < n - m - 1) != (sa[i - 1] < n - m - 1)) && lcp[i] > ans[0]) { 
      ans[0] = lcp[i]; ans[1] = i;
    }
  }
  return ans;
}