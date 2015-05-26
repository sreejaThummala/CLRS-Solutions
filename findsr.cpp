#include <bits/stdc++.h>
#define MAX 100005
using namespace std;

int z[MAX];
string s;
int n;
void calculateZ(){
	int L = 0, R = 0;
	for(int i=1;i<n;i++){
		if(i>R){
			 L = R = i;
    		while (R < n && s[R-L] == s[R]) R++;
    		z[i] = R-L; R--;
		} else {
			 int k = i-L;
    		if (z[k] < R-i+1) z[i] = z[k];
    		else {
      		L = i;
      		while (R < n && s[R-L] == s[R]) R++;
      			z[i] = R-L; R--;
			}
		}
	}
}

int findsr(){
	int t = 0;
	for(int i=0;i<n;i++){
	    if(z[i]+i==n)
		t = max(t,z[i]);
	}


	if(t==0){
		return 1;
	}
	
	if(!(n%(n-t))){
		return n/(n-t);
	}
	
	return 1;
}
int main(){

	cin >> s;

	while(s[0] != '*'){
		n = s.size();
		calculateZ();
		int x = findsr();
		printf("%d\n",x);
		cin >> s;
	}

	return 0;
}
