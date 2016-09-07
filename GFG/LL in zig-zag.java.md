#Question
Given a LL, rearrange it such that converted list should be of form a<b>c

```java
public void zigzaglist(Node head)
{
  boolean flag = true;
  
  Node current = head;
  while(current.next != null)
  {
    if(flag)
    {
      if(current.data > current.next.data)
      {
        swap(current,current.next);
      }
    }
    else
    {
       if(current.data < current.next.data)
      {
        swap(current,current.next);
      }
    }
    
    current = current.next;
    flag = !flag;
  }
}
