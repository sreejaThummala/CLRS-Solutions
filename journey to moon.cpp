#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <vector> 
#include <list>
#include <queue>
#include <set>
#include <map>
#include <string>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <functional>
#include <numeric>
#include <cstdlib>
#include <cmath>
#include <cstdio>
#include <fstream>
#include <ctime>
#include <cassert>

#define MAX 1000001
using namespace std; 

class subset {
public:
    int count;
    int parent;
    bool root;
    subset(){}
    subset(int scount, int sparent, bool sroot):count(0),parent(-1),root(true){
        count = scount;
        parent = sparent;
        root = sroot;
    }
};

subset sets[MAX];

int find(int a) {
    if(sets[a].parent != a) {
        return find(sets[a].parent);
    }
    
    return a;
}
void merge(int a, int b){
    
    if(a==b) return;
    
    int aParent = find(a);
    int bParent = find(b);
    
    
    if(aParent != bParent)
    if(sets[aParent].count <= sets[bParent].count) {
        sets[aParent].count += sets[bParent].count ;
        sets[bParent].parent = aParent;
        sets[bParent].root = false;
    } else {
        sets[bParent].count += sets[aParent].count;
        sets[aParent].parent = bParent;
        sets[aParent].root = false;
    }
    
    return;
} 
 
int main()
{ 
    long long N, I;
    cin >> N >> I;
      for(int i=0;i <N;i++) {
        sets[i] =  subset(1,i, true);
    }
    for (int i = 0; i < I; ++i) {
        int a, b;
        cin >> a >> b;
        merge(a,b);
    }
    
    long long results = 0;
 
    long long total_ways = ((N*(N-1))/2);
    
    for(int i=0;i<N;i++) {
        if(sets[i].root) results += ((sets[i].count)*(sets[i].count -1)/2);
    }
    /** Write code to compute the result using N,I,pairs **/
    
    cout << total_ways - results << endl;
    return 0;
}
