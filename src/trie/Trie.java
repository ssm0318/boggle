package trie;

// source: http://www.geekviewpoint.com/java/trie/add_word

import java.util.ArrayList;
import java.util.List;
//import java.util.Stack;

public class Trie {
	private TrieNode root;
	
	// constructor
	public Trie() {
		root = new TrieNode('\0');
	}
	
	// insert the given word into the trie.
	// if the word already exists, return false; else return true
	public boolean addWord(String word) {
		TrieNode n = root, tmp;
		for(char c : word.toCharArray()) {
			tmp = n.next[c];
			if(tmp == null) {
				tmp = new TrieNode(c);
				n.setChild(c,  tmp);
			}
			n = tmp;
		}
		if(n.word) {
			return !n.word;
		}
		n.word = true;
		return n.word;
	}
	
	// returns true if the given word is in the trie
	public boolean contains(String word) {
		TrieNode n = root;
		for(char c : word.toCharArray()) {
			n = n.next[c];
			if(null == n) {
				return false;
			}
		}
		return n.word;
	}
	
	// returns true if the given word is a prefix. return false otherwise
	public boolean isPrefix(String word) {
		TrieNode n = root;
		for(char c : word.toCharArray()) {
			n = n.next[c];
			if(null == n) {
				return false;
			}
		}
		return !n.nextIsEmpty();
	}
	
	public List<String> getWordList() {
		List<String> result = new ArrayList<String>();
		for(TrieNode n : root.next) {
			if(null != n) {
				getWordList(result, n.value + "", n);
			}
		}
		return result;
	}
	
	private void getWordList(List<String> result, String word, TrieNode n) {
		if(n.word) {
			result.add(word);
		}
		for(TrieNode t : n.next) {
			if(null != t) {
				getWordList(result, word + t.value, t);
			}
		}
	}
}
