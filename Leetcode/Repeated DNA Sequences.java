public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> words = new HashSet<Integer>();
        Set<Integer> dWords = new HashSet<>();
        List<String> res = new ArrayList<>();
        int[] map = new int[26];
        map['A'-'A'] = 0;
        map['C'-'A'] = 1;
        map['G'-'A'] = 2;
        map['T'-'A'] = 3;
        for(int i = 0; i <= s.length()-10; i++){
            int v = 0;
            for(int j = 0; j <10; j++){
                v = v<<2;
                v |= map[s.charAt(i+j)-'A'];
            }
            if(!words.add(v) && dWords.add(v)){
                res.add(s.substring(i,i+10));
            }
        }
        
        return res;
    }
}
