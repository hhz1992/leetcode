package tree;

/**
 * Created by Huanzhou on 2016/1/27.
 */
public class No104_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root ==null)
            return 0;

        return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
    }

}
