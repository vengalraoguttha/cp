package leetcode_july_challenge;

import java.util.*;

public class P2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<List<Integer>> ans = new LinkedList<>();
        ans.addFirst(Arrays.asList(root.val));
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            List<TreeNode> current = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode treeNode = queue.poll();
                if(treeNode.left != null){
                    level.add(treeNode.left.val);
                    current.add(treeNode.left);
                }

                if(treeNode.right != null){
                    level.add(treeNode.right.val);
                    current.add(treeNode.right);
                }
            }
            if(!level.isEmpty())
            ans.addFirst(level);
            queue.addAll(current);
        }
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
