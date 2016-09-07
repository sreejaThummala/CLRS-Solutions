#Question
Given a singly linked list of 0s and 1s find its decimal equivalent

```java
public int decimalValue(Node head)
{
  int res = 0;
  while(head!=null)
  {
    res = (res << 1) + head.data;
    head = head.next;
  }
  
  return res;
}
