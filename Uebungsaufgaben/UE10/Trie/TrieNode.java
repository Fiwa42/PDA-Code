package Trie;

public class TrieNode {

  private Character letter;
  private Integer value;
  private TrieNode[] children;

  public TrieNode() {
    this.children = new TrieNode[3];
    this.letter = '\0';
    this.value = -1;
  }

  public TrieNode(char letter, int value) {
    this.children = new TrieNode[3];
    this.letter = letter;
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public char getLetter() {
    return letter;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void setLetter(char letter) {
    this.letter = letter;
  }

  /**
   * Adds a new child node with the given key and value to this node.
   * 
   * @param letter The character of this node
   * @param value  The value associated with this node, or -1 if no value is
   *               associated
   * @return The new child if it could be added or if a node with the given key is
   *         already
   *         there, null if there are already three children
   */
  public TrieNode addChild(char letter, int value) {
    for (int i = 0; i < children.length; i++) {
      if (children[i] != null && children[i].letter == letter) {
        return children[i];
      }
    }
    for (int i = 0; i < children.length; i++) {
      if (children[i] == null) {
        children[i] = new TrieNode(letter, value);
        return children[i];
      }
    }   
    return null;
  }

  /**
   * Searches this node's direct children for a node with the given key.
   * 
   * @param letter The character to look for
   * @return Returns the TrieNode with the given key if it was found, or null
   *         otherwise
   */
  public TrieNode find(char letter) {
    for (int i = 0; i < children.length; i++) {
      if (children[i] != null && children[i].letter == letter) {
        return children[i];
      }
    }
    return null;
  }

}