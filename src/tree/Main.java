package tree;

public class Main {
    public static void main(String[] args) {
        //TreeNode root = new TreeNode(1);
        /*root.setLeftChild(new TreeNode(0));
        root.setRightChild(new TreeNode(2));
        root.getRightChild().setRightChild(new TreeNode(3));*/
        //root.getRightChild().getRightChild().setRightChild(new TreeNode(5));

        Tree tree = new Tree(null);

        tree.printLwr();

        System.out.println();
        tree.addNodeToBinarySearchTree(new TreeNode(4));

        tree.printLwr();

    }
}
