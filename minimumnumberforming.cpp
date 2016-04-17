#include <bits/stdc++.h>
using namespace std;

string num(string s){
    string n  = "";
    int len = s.size();
    for(int i = 1; i<=len+1;i++){
        n += to_string(i);
    }
    
    for(int i = 0; i<len;)
    {
        int start = i;
        int j = start;
        for(; j<len && s[j] == 'D';j++);
        if(start!=j) reverse(n.begin()+start,n.begin()+j+1);
        if(start!=j) i = j;
        else i++;
    }
    
    return n;
}
int main() {
	int n;
	cin >> n;
	while(n--){
	    string s;
	    cin >> s;
	    cout << num(s);
	}
	return 0;
}
