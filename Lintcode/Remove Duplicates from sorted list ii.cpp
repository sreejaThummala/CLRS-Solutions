/**
 * Definition of ListNode
 * class ListNode {
 * public:
 *     int val;
 *     ListNode *next;
 *     ListNode(int val) {
 *         this->val = val;
 *         this->next = NULL;
 *     }
 * }
 */
class Solution{
public:
    /**
     * @param head: The first node of linked list.
     * @return: head node
     */
    ListNode * deleteDuplicates(ListNode *head) {
        // write your code here
        if(!head) return head;
        if(!head->next) return head;
        ListNode* res = head;
        int prev = head->val;
        ListNode *cur = head;
        bool isHeadDup = (head->next->val == head->val);
        bool isDup = isHeadDup;
        ListNode* rCur = res;
        while(cur->next){
            cur =  cur->next;
            if((cur->next && (cur->next->val == cur->val)) ) { isDup = true;continue;}
            if(isDup) {isDup = false; continue;}
            rCur->next = cur;
            rCur = rCur->next;
        }
        
        rCur->next = NULL;
        if(isHeadDup) res = res->next;
        return res;
    }
};
