package leetcode_august_challenge;

import java.util.HashMap;
import java.util.HashSet;

public class AddandSearchWord {
    class WordDictionary {
        /** Initialize your data structure here. */
        Node trie;
        public WordDictionary() {
            trie = new Node();
            trie.current = '$';
            trie.next = new HashMap<>();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node current = trie;
            for(int i = 0; i < word.length(); i++){
                if(current.next == null) current.next = new HashMap<>();
                if(current.next.containsKey(word.charAt(i))){
                    current = current.next.get(word.charAt(i));
                    current.isWord = current.isWord || (i == word.length() - 1);
                } else {
                    Node node = new Node();
                    node.current = word.charAt(i);
                    node.next = new HashMap<>();
                    node.isWord = node.isWord || (i == word.length() - 1);
                    current.next.put(word.charAt(i), node);
                    current = node;
                }
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(word, trie, 0);
        }

        private boolean search(String word, Node current, int position){
            if(position == word.length() - 1) {
                if(word.charAt(position) == '.'){
                    if(current.next.size() > 0){
                        for(Character key : current.next.keySet()){
                            if(current.next.get(key).isWord){
                                return true;
                            }
                        }
                        return false;
                    } else {
                        return false;
                    }
                } else {
                    if(current.next.containsKey(word.charAt(position))){
                        Node node = current.next.get(word.charAt(position));
                        if(node.isWord) return true;
                        return false;
                    } else {
                        return false;
                    }
                }
            }
            if(word.charAt(position) == '.'){
                boolean res = false;
                for(Character key : current.next.keySet()){
                    res = res || search(word, current.next.get(key), position + 1);
                }
                return res;
            } else {
                if(current.next.containsKey(word.charAt(position))){
                    return search(word, current.next.get(word.charAt(position)), position + 1);
                } else {
                    return false;
                }
            }
        }

        class Node{
            Character current;
            boolean isWord;
            HashMap<Character, Node> next;
        }
    }
}
