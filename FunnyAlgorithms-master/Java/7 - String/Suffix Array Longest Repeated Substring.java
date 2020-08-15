Retorna un int[] con el size y el indice del suffix array en el cual se encuentra el substring repetido mas largo. Debe ejecutarse primero suffixArray() y calculateLCP().

static int[] longestRepeatedSubstring() {
  int ans[] = new int[2]; ans[0] = -1; ans[1] = -1;
  for(int i = 0; i < n; i++) {
    if(ans[0] < lcp[i]) {
      ans[0] = lcp[i]; ans[1] = i;
    }
  }
  return ans;
}