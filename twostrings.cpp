#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int getCharMask(string s) {
    int mask = 0;
    for(int i = 0; i< s.size(); i++) {
        mask |= (1<< (s[i] - 'a'));
    }
    
    return mask;
}

bool containsCommonWord(string f, string s) {
    int fCharMask = getCharMask(f);
    int sCharMask = getCharMask(s);
    
    return __builtin_popcount(fCharMask^sCharMask) < __builtin_popcount(fCharMask|sCharMask);
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
    int n;
    cin >> n;
    while(n--) {
        string f;
        string s;
        cin >> f;
        cin >> s;
        cout << (containsCommonWord(f,s) ? "YES" :"NO") <<"\n";
    }
    return 0;
}
