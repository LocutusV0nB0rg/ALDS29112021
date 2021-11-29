package tree;

public class Tree {
    private final TreeNode root;

    public Tree() {
        TreeNode root = new TreeNode(0);
        root.setLeftChild(new TreeNode(1));
        root.setRightChild(new TreeNode(2));

        root.getLeftChild().setLeftChild(new TreeNode(3));
        root.getLeftChild().setRightChild(new TreeNode(4));

        root.getRightChild().setRightChild(new TreeNode(5));

        root.getLeftChild().getLeftChild().setLeftChild(new TreeNode(6));
        root.getLeftChild().getLeftChild().setRightChild(new TreeNode(7));

        root.getLeftChild().getRightChild().setRightChild(new TreeNode(8));

        root.getRightChild().getRightChild().setLeftChild(new TreeNode(9));
        this.root = root;
    }

    public Tree(TreeNode root) {
        this.root = root;
    }
}
