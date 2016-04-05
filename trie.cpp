class Node {
public:
    Node* children[26];
    bool isEnd;
    
    Node() {
        isEnd = false;
        for(int i=0 ;i< 26; i++)
        {
            children[i] = NULL;
        }
    }
};
class WordDictionary {
public:
   Node* trie;
   
   WordDictionary()
   {
       trie = new Node();
   }

    // Adds a word into the data structure.
    void addWord(string word) {
        // Write your code here
        Node* p  = trie;
        for(int i=0; i< word.size(); i++)
        {
            int idx = word[i] - 'a';
            
            if(!p->children[idx]) p->children[idx] = new Node();
            p = p->children[idx];
            
            
        }
        
        p->isEnd = true;
        
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    bool search(string word) {
        // Write your code here
        
       return search_(word, 0, trie);
    }
    
private:
    bool search_(string word, int pos, Node* p)
    {
        if(word.size() <= pos) 
        {
            return p->isEnd;
        }
        
        if(word[pos] == '.')
        {
             for (int j=0;j<26;j++){
                    if (p->children[j]){
                        if (search_(word, pos+1, p->children[j])){
                            return true;
                        }
                    }
                }
                return false;
        }
        
        int idx = word[pos] - 'a';
        if (p->children[idx]){
            return search_(word, pos+1, p->children[idx]);
        }
        
        return false;
    }
};

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary;
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
