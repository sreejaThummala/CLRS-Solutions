import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0) {
		    t--;
		    int n = in.nextInt();
		    int m = in.nextInt();
		    boolean[][] graph = new boolean[n][n];
		    
		    for(int i =0; i < m ; i++)
		    {
		        int u = in.nextInt();
		        int v = in.nextInt();
		        
		        graph[u-1][v-1] = true;
		 
		    }
		    
		    System.out.println(getConnectingNodes(graph,n));
		}
	}
	
	private static int getConnectingNodes(boolean[][] graph, int n)
	{
	    
	    Map<Integer, Set<Integer>> components = new HashMap<Integer, Set<Integer>>();
	    
	    for(int u = 0; u < n ; u++) {
	        for(int v = 0; v < n ;v++){
	            if(graph[u][v]){
	                Set<Integer> uComponent = components.get(u);
	                Set<Integer> vComponent = components.get(v);
	                
	                if(uComponent == null){
	                    uComponent = new HashSet<Integer>();
	                }
	                
	                if(vComponent == null){
	                    vComponent = new HashSet<Integer>();
	                }
	                
	                if( u <v){
	                    uComponent.add(v);
	                    uComponent.addAll(vComponent);
	                    components.put(u,uComponent);
	                    components.remove(v);
	                }else{
	                    vComponent.add(v);
	                    vComponent.addAll(uComponent);
	                    components.put(v,vComponent);
	                    components.remove(u);
	                }

	            }
	        }
	    }
	    
	    int sum =0;
	    Iterator<Map.Entry<Integer,Set<Integer>>> it = components.entrySet().iterator();
	    while(it.hasNext()){
	        
	        int componentSize = it.next().getValue().size();
	        
	        if(componentSize%2==0){
	            sum += 2;
	        }
	        
	        if(componentSize%2 ==1){
	            sum += componentSize;
	        }
	    }
	    
	    return (sum)/2;
	    
	}
}
