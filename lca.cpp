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
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *A, TreeNode *B) {
        // write your code here
        
        if(!root) return NULL;
        if(A==B) return A;

        deque<TreeNode*> pathA;
        deque<TreeNode*> pathB;
        findPath(A,pathA, root);
        findPath(B,pathB, root);
        int Aptr = 0;
        int Bptr = 0;
        
        while(pathA[Aptr] == pathB[Bptr]) 
        {
            Aptr++;
            Bptr++;
        }
        
        return pathA[Aptr-1];
    }
    
private:
    bool findPath(TreeNode* A, deque<TreeNode*> &path, TreeNode* root)
    {
      if(!root) return false;

       if(findPath(A, path, root->left)  || root == A||
       findPath(A, path, root->right))
       {path.push_front(root); 
        return true;}
       
       return false;
    }
};
