package tree;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeftChild(new TreeNode(0));
        root.setRightChild(new TreeNode(2));
        root.getRightChild().setRightChild(new TreeNode(3));

        Tree tree = new Tree(root);

        System.out.println("tree.isAVLTree() = " + tree.isAVLTree());
    }
}
