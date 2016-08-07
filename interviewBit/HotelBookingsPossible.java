public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        
        int i  = 0;
        
        int a_i  = 0;
        int d_i = 0;
        while(true) {
            if(a_i >= arrive.size() || d_i >= depart.size()) 
            break;
            if(arrive.get(a_i) < depart.get(d_i)){
                a_i++;
                i++;
                
                if(i> K){
                    return false;
                }
                continue;

            }
            
            if(arrive.get(a_i) > depart.get(d_i)){
                d_i++;
                i--;
                continue;
            }
            
            a_i++;
            d_i++;
            
        }
        
        return true;
    }
}
