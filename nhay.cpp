#include <bits/stdc++.h>
using namespace std;

string c;
string p;
string s;
int n;
void calculateZ(int z[]){
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

void findNeedle(int z[]){
	int l = p.size();
	int n = s.size();
	for(int i=l;i<n;i++){
		if(z[i]>=l){
			printf("%d\n",i-l);
		}
	}
}

int main(){
	int len;
	while(scanf("%i", &len)!=EOF){
		cin>>p;
		cin>>c;
		s=p+c;
		n=s.size();
		int z[n];
		calculateZ(z);
		findNeedle(z);
		printf("\n");
	}
	return 0;
}
