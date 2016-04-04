/**
 * Definition of TreeNode:
 * class TreeNode {
 * public:
 *     int val;
 *     TreeNode *left, *right;
 *     TreeNode(int val) {
 *         this->val = val;
 *         this->left = this->right = NULL;
 *     }
 * }
 */
class Solution {
public:
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    bool isValidBST(TreeNode *root) {
        // write your code here
        return isValidBST_(root, INT_MAX, INT_MIN);
    }
    
    
private:
    
    bool isValidBST_(TreeNode * node, long max, long min)
    {  if(!node) return true;

        if(node->val <= min || node->val >= max) return false;
        
        return isValidBST_(node->right, max, node->val) && isValidBST_(node->left, node->val, min);
    }
};
