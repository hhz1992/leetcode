package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Huanzhou on 2016/1/26.
 */
public class No102_BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root ==null)
            return result;

        Queue<TreeNode> que = new LinkedList<TreeNode>();

        que.add(root);
        int curNum = 1, nextNum = 1;
        TreeNode cur = que.peek();

        while (!que.isEmpty()) {
            nextNum = 0;
            List<Integer> list = new LinkedList<Integer>();;
            for (int i = 0; i < curNum; i++) {
                cur = que.peek();
                list.add(cur.val);
                if (cur.left != null) {
                    que.add(cur.left);
                    nextNum++;
                }
                if (cur.right != null) {
                    que.add(cur.right);
                    nextNum++;
                }
                que.poll();
            }
            result.add(list);
            curNum = nextNum;

        }
    return result;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;

        List<List<Integer>> result=  levelOrder(t1);

        System.out.println(result);

    }

}
