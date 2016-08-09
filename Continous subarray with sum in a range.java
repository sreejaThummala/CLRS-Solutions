/**
Given an array int32 arr[] of size n, return the number of non-empty contigious subarrays whpse sum les in the range[a,b]
**/
/**
A simple o(nlogn) solution would be using cummulative sum and treeset navigable set subsets operatio.
-- number is one subarray
-- cummulative sum falls between range then there is a subset from start to its index
-- [cumsum-b,cumsum-a] treesetnavigableset takes care of it
**/
public static int subArrayWithSumInRange(int[] A, int a, int b){
	int count = 0;
	TreeSet<Pair> treeSet = new TreeSet<test.Pair>();
	int cumsum = 0;
	
	for(int i = 0; i< A.length; i++){
		cumsum+=A[i];
		
		if(A[i] >= a && A[i] <= b){
			count++;
		}
		else if(cumsum >= a && cumsum <= b){
			count++;
		}

		NavigableSet<Pair> subSet = treeSet.subSet(new Pair(cumsum-b, i+1), true, new Pair(cumsum-a, i+1), false);
		if(!subSet.isEmpty()){
			count += Math.abs(subSet.first().second - subSet.last().second)+1;
		}
		treeSet.add(new Pair(cumsum, i));
	}
	
	return count;
}
