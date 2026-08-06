class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        return searchTrue(word, 0, node);
    }

    public boolean searchTrue(String word, Integer index, TrieNode node) {
        if (index == word.length()) {
            return node.endOfWord;
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (node.children[c - 'a'] == null) {
                return false;
            } else {
                return searchTrue(word, index + 1, node.children[c - 'a']);
            }
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (searchTrue(word, index + 1, node.children[i])) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    class TrieNode {
        TrieNode[] children;
        boolean endOfWord;

        TrieNode() {
            children = new TrieNode[26];
            endOfWord = false;
        }
    }
}
