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
		        
		        graph[u][v] = true;
		        graph[v][u] = true;
		    }
		    
		    System.out.println(getConnectingNodes(graph,n));
		}
	}
	
	private static int getConnectingNodes(boolean[][] graph, int n)
	{
	    Boolean[] visited  = new Boolean[n+1];
	    
	    Arrays.fill(visited, false);
	    int sum = 0;
	    for(int i = 1; i <= 2; i++){
	                if(!visited[i]){
	                    Integer[] componentEdges = new Integer[n+1];
	                    Arrays.fill(componentEdges,0);
	                    dfs(visited, graph,i, componentEdges,n);
	                    
	                    int[] evenOdd = new int[2];
	                    for(int j = 1; j<=n; j++){
	                        evenOdd[componentEdges[j]%2]++;
	                    }
	                    
	                    sum += evenOdd[1];
	                    
	                    if(evenOdd[1] ==0){
	                        sum += 2;
	                    }
	            }
	        }
	        
	        return sum/2;
	    
	    
	}
	
	private static void dfs(Boolean[] visited, boolean[][] graph, int u, Integer[] componentEdges,
	int n){
	    
	    if(visited[u]) return;
	    
	    for(int i = u+1; i <=n ; i++){
	        if(graph[i][u]){
	            dfs(visited, graph,i, componentEdges, n);
	            componentEdges[i]++;
	        }
	    }
	    
	    visited[u] = true;
	}
}
