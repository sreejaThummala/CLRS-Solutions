public class Solution {
	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    int n = a.size();
	    
	    int startMax = -1;
	    int endMax = -1;
	    int currentStartMax = -1;
	    int currentEndMax  = -1;
	    long  currentMax = 0;
	    long  resSum = 0;
	    
	    for(int i = 0; i< n ; i++)
	    {
	        if(a.get(i) >=0)
	        {
	            currentMax += a.get(i);
	            currentEndMax = i;
	            if(currentStartMax <0 ) currentStartMax = i;
	            if(resSum < currentMax)
	            {
	                resSum = currentMax;
	                startMax = currentStartMax;
	                endMax = currentEndMax;
	            }
	            if(resSum == currentMax)
	            {
	                if(endMax - startMax < currentEndMax - currentStartMax)
	                {
	                    startMax = currentStartMax;
	                    endMax = currentEndMax;
	                }
	            }
	        } 
	        else
	        {
	            currentStartMax = -1;
	            currentEndMax = -1;
	            currentMax = 0;
	        }
	    }
	    
	    ArrayList<Integer> res = new ArrayList<Integer>();
	   
	    for(int i = startMax; i<= endMax && i >=0; i++)
	    {
	        res.add(a.get(i));
	    }
	    
	    return res;
	}
}
