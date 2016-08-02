/**
Given n return 1^2^3^4...^n
*/
public int getXOR(long n) 
{
switch(n%4)
case 0: return n;
case 2: return n+1;
case 3: return 0;
case 1: return 1;
}
