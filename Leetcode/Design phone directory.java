/**
Design a phone directory which supports the following operations
1. get: provide a number which is not assigned to anyone
2. check: check if a number is available or not
3. release: recycle or release a number
**/

/**
Use bitset to keep track of numbers which are not assigned.
get o(log(Maxnumber))
check o(1)
release o(1)
**/
public class PhoneDirectory{
  Bitset bitset;
  int maximum;
  int nextNumber;
  
  public PhoneDirectory(int maxNumbers){
    bitset = new BitSet(maxNumbers);
    this.maximum = maxNumbers;
  }
  
  public int get(){
    if(nextNumber == maxNumbers){
      return -1; // none left
    }
    
    int num = nextNumber;
    bitset.set(nextNumber);
    nextNumber = bitset.nextClearBit(nextNumber);
    return num;
  }
  
  public boolean check(int number){
    return !bitset.get(number);
  }
  
  public void release(int number){
    if(!bitset.get(number)){ // it is not assigned
      return;
    }
    
    bitset.clear(number);
    if(number < nextNumber){
      nextNumber = number;
    }
  }
  
}
