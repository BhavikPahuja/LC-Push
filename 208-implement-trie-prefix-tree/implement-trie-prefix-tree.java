class Node {

    boolean isWord;
    Node[] nei;
    
    public Node() {

        isWord = false;
        nei = new Node[26];
    }
}

class Trie {

    Node root;
    
    public Trie() {

        root = new Node();
    }
    
    public void insert(String word) {

        Node node = root;

        for (char ch : word.toCharArray()) {

            int idx = ch - 'a';
            
            if (node.nei[idx] == null) {
            
                node.nei[idx] = new Node();
            }
            
            node = node.nei[idx];
        }

        node.isWord = true;
    }
    
    public boolean search(String word) {

        Node node = root;

        for (char ch : word.toCharArray()) {

            int idx = ch - 'a';

            if (node.nei[idx] == null) {

                return false;
            }

            node = node.nei[idx];
        }

        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {

        Node node = root;

        for (char ch : prefix.toCharArray()) {

            int idx = ch - 'a';

            if (node.nei[idx] == null) {

                return false;
            }

            node = node.nei[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */