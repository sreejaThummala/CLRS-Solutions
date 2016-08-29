#Question
Given a range [n,m], find the number of elements that have odd number of factors in the given range

#Analysis
Observe the pattern
perfect squares are the only ones containing odd factors

```java
int countFactors(int n, int m){
  return (int)Math.sqrt(n-1)-(int)Math.sqrt(m);

}
