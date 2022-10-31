(Prefix tree) Estructura de datos para almacenar un diccionario de strings. Debe ejecutarse el método init_trie. El método dfs hace un recorrido en orden del trie.

import java.util.*;

class Main {

    static int MAX_L = 26; //cantidad de letras del lenguaje
    static char L = 'a'; //primera letra del lenguaje
    static ArrayList<node> trie;

    static class node {
        Integer next[];
        boolean fin;

        public node() {
            next = new Integer[MAX_L];
            this.fin = false;
        }
    }

    static void init_trie() {
        trie = new ArrayList<>();
        trie.add(new node());
    }

    static void add_str(String s) {
        int cur = 0, c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i) - L;
            if (trie.get(cur).next[c] == null) {
                trie.get(cur).next[c] = trie.size();
                trie.add(new node());
            }
            cur = trie.get(cur).next[c];
        }
        trie.get(cur).fin = true;
    }

    static boolean contain(String s) {
        int cur = 0, c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i) - L;
            if (trie.get(cur).next[c] == null) return false;
            cur = trie.get(cur).next[c];
        }
        return trie.get(cur).fin;
    }

    static void dfs(int cur) {
        for (int i = 0; i < MAX_L; ++i) {
            if (trie.get(cur).next[i] != null) {
                //System.out.println((char)(i+L));
                dfs(trie.get(cur).next[i]);
            }
        }
    }

    public static void main(String[] args) {
        init_trie();
        String s[] = {"hello", "world", "help"};
        for (String c : s) add_str(c);
    }
}
