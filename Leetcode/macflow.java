package com.google.challenges; 
import java.util.*;

public class Answer {   
    public static int answer(int[] entrances, int[] exits, int[][] path) { 

        // Your code goes here
        int num = path.length + 2;
    	int[] parent = new int[num];
    	boolean[] visited = new boolean[num];

        int[][] graph = new int[num][num];

    	for (int i = 0; i < entrances.length; i++)
            graph[0][entrances[i]+1] = Integer.MAX_VALUE;
        
        for (int i = 0; i < exits.length; i++)
            graph[exits[i]+1][num-1] = Integer.MAX_VALUE;

        for (int i = 1; i < num-1; i++)
    	    for (int j = 1; j < num-1; j++)
    		    graph[i][j] = path[i-1][j-1];
    		    
        int[][] rGraph = new int[num][num];
    	for (int i = 0; i < num; i++)
    		for (int j = 0; j < num; j++)
    			rGraph[i][j] = graph[i][j];

        int start = 0;
    	int end = num-1;
    	int maxFlow = 0;

    	while(bfs(start,end,rGraph,parent,visited))
    	{
    		int newPath = Integer.MAX_VALUE;
    		int u = end;
    		while (u != start)
    		{
    			newPath = Math.min(newPath, rGraph[parent[u]][u]);
    			u = parent[u];
    		}

    		u = end;
    		while (u != start)
    		{
    			rGraph[parent[u]][u] -= newPath;
    			rGraph[u][parent[u]] += newPath;
    			u = parent[u];
    		}

    		maxFlow += newPath;
    	}

    	return maxFlow;

    } 
    
        private static boolean bfs(int start, int end, int[][] rGraph,int[] parent,boolean[] visited)
    {
        int num = rGraph.length;
    	for (int i = 0; i < num; i++)
    	{
    		parent[i] = -1;
    		visited[i] = false;
    	}

    	Queue<Integer> queue = new LinkedList<Integer>();
    	visited[start] = true;
    	queue.add(start);

    	while (queue.size() > 0)
    	{
    		int current = queue.remove();

    		for (int i = 0; i < num; i++)
    		{
    			if (rGraph[current][i] > 0 && !visited[i])
    			{
    				visited[i] = true;
    				parent[i] = current;
    				queue.add(i);
    			}	
    		}
    	}

    	if (visited[end])
    		return true;

    	return false;
    }

}
