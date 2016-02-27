package tree;

/**
 * Created by Huanzhou on 2016/1/28.
 */
public class No226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if(root == null)
            return null;

        TreeNode right = root.right, left = root.left;

        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }

}
