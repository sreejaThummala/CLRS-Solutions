#include <iostream>
#include <queue>
#include <vector>
using namespace std;

const int MAX =  1100000;

long long t[2*MAX] = {0};
long long d[MAX] = {0};

int n; //size of the array
int h; //height of the tree
void calc(int p, int k) {
  if (d[p] == 0) t[p] = t[p<<1] + t[p<<1|1];
   t[p] += d[p] * k;
}

void apply(int p, int value, int k) {
  t[p] += value * k;
  if (p < n) d[p] += value;
}
void build(int l, int r) {
  int k = 2;
  for (l += n, r += n-1; l > 1; k <<= 1) {
    l >>= 1, r >>= 1;
    for (int i = r; i >= l; --i) calc(i, k);
  }
}

void push(int l, int r) {
  int s = h, k = 1 << (h-1);
  for (l += n, r += n-1; s > 0; --s, k >>= 1)
    for (int i = l >> s; i <= r >> s; ++i) if (d[i] != 0) {
      apply(i<<1, d[i], k);
      apply(i<<1|1, d[i], k);
      d[i] = 0;
    }
}
void modify(int l, int r, int value) {
  if (value == 0) return;
  push(l, l + 1);
  push(r - 1, r);
  bool cl = false, cr = false;
  int k = 1;
  for (l += n, r += n; l < r; l >>= 1, r >>= 1, k <<= 1) {
    if (cl) calc(l - 1, k);
    if (cr) calc(r, k);
    if (l&1) apply(l++, value, k), cl = true;
    if (r&1) apply(--r, value, k), cr = true;
  }
  for (--l; r > 0; l >>= 1, r >>= 1, k <<= 1) {
    if (cl) calc(l, k);
    if (cr && (!cl || l != r)) calc(r, k);
  }
}

long long query(int l, int r) {
  push(l, l + 1);
  push(r - 1, r);
  long long res = 0;
  for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
    if (l&1) res += t[l++];
    if (r&1) res += t[--r];
  }
  return res;
}
int main(){
    int t,cc = 1;
    scanf("%d",&t);
    while(cc <= t){
        printf("Scenario #%d:\n",cc);
        cc++;
        int m;
        scanf("%d %d",&n,&m);
        h = sizeof(int) * 8 - __builtin_clz(n);
        int l, r;
        char cs[20];
        for(int i=0;i<m;i++){
            scanf("%s %d %d",cs,&l,&r);
            //printf("%s %d %d\n",cs,l,r);
            if(cs[0] == 'm'){
                modify(l-1,r-1,1);
                modify(r-1,r,1);
                printf("OK\n");
            }else if(cs[0] == 'a'){
                printf("%lld\n",query(l-1,r-1)+query(r-1,r));
            }

        }
    }
	return 0;
}
