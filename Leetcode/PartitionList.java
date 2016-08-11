/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0); //dummy
        ListNode greater = new ListNode(0);//dummy
        ListNode lastLess = less;
        ListNode lastGreater = greater;
        ListNode ptr = head;
        while(ptr!=null){
            if(ptr.val < x){
                lastLess.next = ptr;
                lastLess = ptr;
            }
            
            if(ptr.val >=x){
                lastGreater.next = ptr;
                lastGreater = ptr;
            }
            
            ptr = ptr.next;
        } 
        
        lastGreater.next = null;
        if(lastLess !=less){
            lastLess.next = greater.next;
            
        }else{
            return greater.next;
        }
        
        return less.next;
        
    }
}
