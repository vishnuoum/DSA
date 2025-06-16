import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class TrieNode {
    Character ch;
    boolean isEndOfWord;
    Map<Character, TrieNode> map;

    TrieNode(Character ch) {
        this.ch = ch;
        this.map = new HashMap<>();
    }

    public void add(char[] word) {
        TrieNode node = this;
        int n = word.length;
        for (int i = 0; i < n; i++) {
            node.map.putIfAbsent(word[i], new TrieNode(word[i]));
            node = node.map.get(word[i]);
            if (i == n - 1) {
                if (node.isEndOfWord) {
                    System.out.println("\nWord is already present\n");
                } else {
                    node.isEndOfWord = true;
                    System.out.println("\nWord Added\n");
                }
            }
        }
    }

    public void search(char[] word) {
        TrieNode node = this;
        int n = word.length;
        for (int i = 0; i < n; i++) {
            node = node.map.get(word[i]);
            if (null == node || (i == n - 1 && !node.isEndOfWord)) {
                System.out.println("\nWord not found\n");
                return;
            }
        }
        System.out.println("\nWord found\n");
    }

    public boolean delete(char[] word, int index) {
        TrieNode node = this;
        if (index == word.length) {
            if (node.isEndOfWord) {
                System.out.println("\nWord to be deleted found in Trie\n");
                if (node.map.isEmpty()) {
                    return true;
                }
                node.isEndOfWord = false;
                return false;
            }
            System.out.println("\nWord not found\n");
            return false;
        } else if (index < word.length && node.map.containsKey(word[index])) {
            boolean flag = node.map.get(word[index]).delete(word, index + 1);
            if (flag) {
                if (index > 0 && !node.isEndOfWord && node.map.size() == 1) {
                    return true;
                }
                node.map.remove(word[index]);
            }
            return false;
        } else {
            return false;
        }
    }
}

public class Trie {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        TrieNode root = new TrieNode('\0');
        root.isEndOfWord = true;
        boolean flag = true;
        String word;
        while (flag) {
            System.out.print("""
                    Enter 1 to add to Trie
                    Enter 2 to search in Trie
                    Enter 3 to delete from Trie
                    Enter any other no. to exit
                    Enter your choice:""");
            int choice = Integer.parseInt(in.readLine());
            switch (choice) {
                case 1:
                    System.out.print("\nEnter word: ");
                    word = in.readLine();
                    root.add(word.toCharArray());
                    break;
                case 2:
                    System.out.print("\nEnter word to be searched: ");
                    word = in.readLine();
                    root.search(word.toCharArray());
                    break;
                case 3:
                    System.out.print("\nEnter word to be deleted: ");
                    word = in.readLine();
                    root.delete(word.toCharArray(), 0);
                    break;
                default:
                    System.out.println("Exiting");
                    flag = false;
            }
        }
    }
}