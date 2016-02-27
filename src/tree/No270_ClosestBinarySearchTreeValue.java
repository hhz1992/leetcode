package tree;

/**
 * Created by Huanzhou on 2016/1/28.
 */
public class No270_ClosestBinarySearchTreeValue  {

    public int closestValue(TreeNode root, double target) {

        TreeNode node =  root.val > target? root.left:root.right;
        if(node == null)
            return root.val;

        int min = closestValue(node, target);
        return Math.abs(root.val - target) <   Math.abs(min - target) ? root.val:min;
    }


}
