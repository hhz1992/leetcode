package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huanzhou on 2016/1/28.
 */
public class No257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<String>();

        if (root == null)
            return result;

        dfs(root, "", result);
        return result;

    }

    public void dfs(TreeNode node, String path, List<String> result) {

        if (node.left == null && node.right == null)
            result.add(path + node.val);

        if (node.right != null)
            dfs(node.right, path + node.val + "->", result);

        if (node.left != null)
            dfs(node.left, path + node.val + "->", result);

    }


}
