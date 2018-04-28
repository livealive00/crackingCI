public class P12 {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        
        TreeNode n_1_1 = new TreeNode(5);
        TreeNode n_1_2 = new TreeNode(11);
        
        TreeNode n_2_1 = new TreeNode(-5);
        TreeNode n_2_2 = new TreeNode(100);
        TreeNode n_2_3 = new TreeNode(0);
        TreeNode n_2_4 = new TreeNode(300);
        
        TreeNode n_3_1 = new TreeNode(-11);
        
        root.left = n_1_1;
        root.right = n_1_2;
        
        n_1_1.left = n_2_1;
        n_1_1.right = n_2_2;
        n_1_2.left = n_2_3;
        n_1_2.right = n_2_4;
        n_2_3.left = n_3_1;
        
        
        System.out.println(getNumPathsForSum(root, 10));
    }
    
    public static int getNumPathsForSum(TreeNode root, int targetSum) {
        return getNumPathsForSum(root, targetSum, 0);
    }
    
    public static int getNumPathsForSum(TreeNode n, int targetSum, int startSum) {
        if (n == null) {
            return 0;
        }
        
        int res = 0;
        if (startSum + n.data == targetSum) {
            res++;
        }
        
        res += getNumPathsForSum(n.left, targetSum, startSum + n.data);
        res += getNumPathsForSum(n.right, targetSum, startSum + n.data);
        
        return res;
    }
    
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int data) {
        this.data = data;
    }
}
