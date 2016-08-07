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
		    boolean[][] graph = new boolean[n+1][n+1];
		    
		    int[] edges = new int[n+1];
		    for(int i =0; i < m ; i++)
		    {
		        int u = in.nextInt();
		        int v = in.nextInt();
		        
		        edges[u]++;
		        edges[v]++;
		        graph[u][v] = true;
		        graph[v][u] = true;
		    }
		    
		    System.out.println(getConnectingNodes(graph,edges,n));
		}
	}
	
	private static int getConnectingNodes(boolean[][] graph, int[] edges,int n)
	{
	    Boolean[] visited  = new Boolean[n+1];
	    
	    Arrays.fill(visited, false);
	    
	    int sum = 0;
	    for(int i = 1; i <= n; i++){
	                if(!visited[i]){
	                    Boolean[] component = new Boolean[n+1];
	                    Arrays.fill(component,false);
	                    dfs(visited, graph,i, edges,n, component);
	                    
	                    int[] evenOdd = new int[2];
	                    for(int j = 1; j<=n; j++){
	                        if(component[j])
	                        evenOdd[edges[j]%2]++;
	                    }
	                    
	                    sum += evenOdd[1];
	                    
	                    if(evenOdd[1] ==0){
	                        sum += 2;
	                    }
	            }
	        }
	        
	        return sum/2;
	    
	    
	}
	
	private static void dfs(Boolean[] visited, boolean[][] graph, int u, int[] edges,
	int n, Boolean[] component){
	 
	    if(visited[u] || component[u]) return;
	    
	    visited[u] = true;
	    component[u] = true;
	    for(int i = 1; i <=n ; i++){
	        if(graph[u][i]){
	            if(!component[i])
	            dfs(visited, graph,i, edges, n, component);
	            component[i] = true;
	            visited[i] = true;
	        }
	    }
	}
}
