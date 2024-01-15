public class Trie {

    private TrieNode root;

    public Trie(char letter, int value) {
      root = new TrieNode();
      root.setLetter(letter);
      root.setValue(value);
    }

    public Trie(TrieNode node) {
      this.root = node;
    }

    public Trie() {
      root = new TrieNode();
    }

    public TrieNode getNode() {
      return root;
    }

    /**
     * Adds a new value with the given key to the trie, creating new TrieNodes as required.
     * @param key The character sequence associated with the new value
     * @param value The new value
     * @return True if the value could be added to the trie, false otherwise
     */
    public boolean addValue(char[] key, int value) {
      Trie current = this;
      for (int i = 0; i < key.length; i++) {
        if (i == key.length - 1) {
          if (current.getNode().addChild(key[i], value) == null) {
            return false;
          }
          Trie newTrie = new Trie(current.getNode().find(key[i]));
          current = newTrie;
        } else {
          if (current.getNode().addChild(key[i], -1) == null) {
            return false;
          }
          Trie newTrie = new Trie(current.getNode().find(key[i]));
          current = newTrie;
        }
      }
      return true;
	  }

    /**
     * Returns the value associated with a given key, or -1 if the key could not be found.
     * @param key The given key
     * @return The associated value, or -1 if the key is not represented in this trie
     */
    public int findValue(char[] key) {
      Trie current = this;
      for (int i = 0; i < key.length; i++) {
        if (current.getNode().find(key[i]) == null) {
          return -1;
        } else {
          Trie newTrie = new Trie(current.getNode().find(key[i]));
          current = newTrie;
        }
      }
      return current.getNode().getValue();
    }
}
