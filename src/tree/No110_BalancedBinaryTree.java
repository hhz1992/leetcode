package tree;

/**
 * Created by Huanzhou on 2016/1/27.
 */
public class No110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode node) {

        if (node == null)
            return 0;

        int leftHeight = getHeight(node.left);

        if (leftHeight == -1)
            return -1;

        int rightHeight = getHeight(node.right);

        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;

    }


}
