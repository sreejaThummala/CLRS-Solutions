package com.google.challenges; 
import java.util.*;

public class Answer {   
    public static int[][] answer(int num_buns, int num_required) { 

        // Your code goes here.
        int[] arr = new int[num_buns];
        for(int i = 0;  i < num_buns; i++) arr[i] = i;
        int len = num_buns - (num_required - 1);
        int num_hold = ncr(num_buns, num_required - 1) - ncr(num_buns - 1, num_required - 2);
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(num_buns-1,len,0,new ArrayList<Integer>(),combinations);
        int[][] res = new int[num_buns][num_hold];
        int[] next = new int[num_buns];
        for(int i = 0; i < combinations.size(); i++){
            for(int j : combinations.get(i)){
                res[j][next[j]++] = i;
            }
        }

     return res;
    } 
     public static int ncr(int n, int k) {
      if (k == 0) return 1;
      if (k < 0) return 0;
      int res = 1;
      for (int i = k + 1; i <= n; i++)
          res = res * i / (i - k);
      return res;
    }
    
    
    private static void generateCombinations(int n,int k, int start, 
    List<Integer> result,List<List<Integer>> combinations){
    	
        if (result.size() == k){
            combinations.add(new ArrayList<Integer>(result));
            return;
        }
        
        for (int i = start; i <=n ; i++){
        	result.add(i);
        	generateCombinations( n,k, i+1, result,combinations);
            result.remove(result.size()-1);
        }
    }  
}

You need to free the bunny prisoners before Commander Lambda's space station explodes! Unfortunately, the commander was very careful with her highest-value prisoners - they're all held in separate, maximum-security cells. The cells are opened by putting keys into each console, then pressing the open button on each console simultaneously. When the open button is pressed, each key opens its corresponding lock on the cell. So, the union of the keys in all of the consoles must be all of the keys. The scheme may require multiple copies of one key given to different minions.

The consoles are far enough apart that a separate minion is needed for each one. Fortunately, you have already freed some bunnies to aid you - and even better, you were able to steal the keys while you were working as Commander Lambda's assistant. The problem is, you don't know which keys to use at which consoles. The consoles are programmed to know which keys each minion had, to prevent someone from just stealing all of the keys and using them blindly. There are signs by the consoles saying how many minions had some keys for the set of consoles. You suspect that Commander Lambda has a systematic way to decide which keys to give to each minion such that they could use the consoles.

You need to figure out the scheme that Commander Lambda used to distribute the keys. You know how many minions had keys, and how many consoles are by each cell.  You know that Command Lambda wouldn't issue more keys than necessary (beyond what the key distribution scheme requires), and that you need as many bunnies with keys as there are consoles to open the cell.

Given the number of bunnies available and the number of locks required to open a cell, write a function answer(num_buns, num_required) which returns a specification of how to distribute the keys such that any num_required bunnies can open the locks, but no group of (num_required - 1) bunnies can.

Each lock is numbered starting from 0. The keys are numbered the same as the lock they open (so for a duplicate key, the number will repeat, since it opens the same lock). For a given bunny, the keys they get is represented as a sorted list of the numbers for the keys. To cover all of the bunnies, the final answer is represented by a sorted list of each individual bunny's list of keys.  Find the lexicographically least such key distribution - that is, the first bunny should have keys sequentially starting from 0.

num_buns will always be between 1 and 9, and num_required will always be between 0 and 9 (both inclusive).  For example, if you had 3 bunnies and required only 1 of them to open the cell, you would give each bunny the same key such that any of the 3 of them would be able to open it, like so:
[
  [0],
  [0],
  [0],
]
If you had 2 bunnies and required both of them to open the cell, they would receive different keys (otherwise they wouldn't both actually be required), and your answer would be as follows:
[
  [0],
  [1],
]
Finally, if you had 3 bunnies and required 2 of them to open the cell, then any 2 of the 3 bunnies should have all of the keys necessary to open the cell, but no single bunny would be able to do it.  Thus, the answer would be:
[
  [0, 1],
  [0, 2],
  [1, 2],
]

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:
    (int) num_buns = 2
    (int) num_required = 1
Output:
    (int) [[0], [0]]

Inputs:
    (int) num_buns = 5
    (int) num_required = 3
Output:
    (int) [[0, 1, 2, 3, 4, 5], [0, 1, 2, 6, 7, 8], [0, 3, 4, 6, 7, 9], [1, 3, 5, 6, 8, 9], [2, 4, 5, 7, 8, 9]]

Inputs:
    (int) num_buns = 4
    (int) num_required = 4
Output:
    (int) [[0], [1], [2], [3]]
