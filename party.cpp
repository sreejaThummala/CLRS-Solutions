#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstdlib>
#include <cstring>
#define maxw 500
#define maxn 100
using namespace std;
//Direct knapsack 0-1 problem
//1D implementation
int dp[maxw+1];
int w[maxn+1];
int v[maxn+1];
int main() {
	
	while(true){
	int W;
	int N;
	scanf("%d",&W);
	scanf("%d",&N);
	if(W==0&&N==0){break;}
	int i=1;
	while(N--){
		scanf("%d %d",&w[i],&v[i]);
	}
	memset(dp,0,sizeof(dp));
	for(int i =1; i <= N; i++) {
		for(int j= W;j>=0;j--){
			dp[j] = (w[i]>j)? dp[j] : max(dp[j],dp[j-w[j]]+v[i]);
		}
	}
	int best = dp[W];
	int j = W;
	while(dp[j]==best){
		j--;
	}
	j = j+1;
	printf("%d %d\n",j,best);
	}
        
	return 0;
}
