package DataStructures.Tries.Implementation;
import java.util.*;

public class Main {

    static class Trie {

        Trie[] trieNode;
        boolean endOfWord;

        public Trie() {
            this.trieNode = new Trie[26];
        }

    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        String str = "hello";

        insertIntoTrie(str, trie);

        System.out.println(searchWord("hello", trie));

    }

    public static boolean searchWord(String str, Trie head) {

        Trie node = head;

        for (char ch : str.toCharArray()) {

            if (node.trieNode[ch - 'a'] != null) node = node.trieNode[ch - 'a'];
            else return false;

        }

        return node.endOfWord;

    }

    public static void insertIntoTrie(String str, Trie head) {

        Trie node = head;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (node.trieNode[ch - 'a'] != null) {
                node = node.trieNode[ch - 'a'];
            } else {
                node.trieNode[ch - 'a'] = new Trie();
                node = node.trieNode[ch - 'a'];
            }

            if (i == str.length() - 1) {
                node.endOfWord = true;
            }

        }

    }

}
