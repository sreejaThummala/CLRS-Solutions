import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int n = in.nextInt();
		    boolean[][] graph = new boolean[n+1][n+1];
		    for(int i  = 1; i<n; i++){
		        int u = in.nextInt();
		        int v = in.nextInt();
		        graph[u][v] = true;
		        graph[v][u] = true;
		        
		    }
		    
		    System.out.println(getNodesAtEvenDistance(graph, n));
		    
		}
	}
	
	private static int getNodesAtEvenDistance(boolean[][] graph, int n){
	    Integer[] distance = new Integer[n+1];
	    Arrays.fill(distance,0);
	   
	    Boolean[] visited = new Boolean[n+1];
	    Arrays.fill(visited, false); 
	    dfs(1, graph, visited, n, distance);
	    
	    int[] evenOdd = new int[2];
	    for(int i  = 1; i<=n; i++){
	        evenOdd[distance[i]%2]++;
	    }
	    
	    return nc2(evenOdd[0])+ nc2(evenOdd[1]);
	    
	}
	
	private static int nc2(int n){
	    return n*(n-1)/2;
	}
	
	private static void  dfs(int v, boolean[][] graph, Boolean[] visited,
	 int n, Integer[] distance){
	     visited[v] = true;
	     
	     for(int i = 1; i<=n; i++){
	         if(graph[v][i]){
	             if(!visited[i]){
	                 distance[i] = distance[v]+1;
	                 dfs(i, graph, visited, n, distance);
	             }
	         }
	     }
	 }
}
