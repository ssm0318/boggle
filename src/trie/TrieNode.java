package trie;

// source: http://www.geekviewpoint.com/java/trie/trie_node

public class TrieNode {
	public char value;
	boolean word = false;
	TrieNode[] next = new TrieNode[256];
	private int nextLength = 0;
 
	public TrieNode(char c) {
		value = c;
	}
 
	void setChild(char c, TrieNode node){
		next[c]=node;
		nextLength++;
	}
	
	void clearNext() {
		next = new TrieNode[256];
		nextLength = 0;
	}
 
	boolean nextIsEmpty(){
		return nextLength == 0;
	}
 
	int nextSize(){
		return nextLength;
	}
}
