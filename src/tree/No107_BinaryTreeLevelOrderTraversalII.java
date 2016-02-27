package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Huanzhou on 2016/1/27.
 */
public class No107_BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root==null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){

            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();

            for(int i=0;i<levelNum;i++){

                if(queue.peek().left!=null) queue.add(queue.peek().left);
                if(queue.peek().right!=null) queue.add(queue.peek().right);

                subList.add(queue.poll().val);
            }
            result.add(0,subList);
        }
        return result;
    }

}
