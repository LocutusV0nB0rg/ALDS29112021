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

    public int getHeight() {
        return getHeightHelper(root);
    }

    private int getHeightHelper(TreeNode startingNode) {
        if (startingNode == null) return 0;

        int heightLeft = getHeightHelper(startingNode.getLeftChild());
        int heightRight = getHeightHelper(startingNode.getRightChild());

        return Math.max(heightLeft, heightRight) + 1;
    }

    public int getNumberOfNodes() {
        return getNumOfNodesHelper(root);
    }

    private int getNumOfNodesHelper(TreeNode startingNode) {
        if (startingNode == null) return 0;

        return getNumOfNodesHelper(startingNode.getRightChild()) +
                getNumOfNodesHelper(startingNode.getLeftChild()) +
                1;
    }

    public int getNumberOfLeaves() {
        return getNumberOfLeavesHelper(root);
    }

    private int getNumberOfLeavesHelper(TreeNode startingNode) {
        if (startingNode == null) return 0;
        if (startingNode.getLeftChild() == null && startingNode.getRightChild() == null) return 1;

        return getNumberOfLeavesHelper(startingNode.getLeftChild()) +
                getNumberOfLeavesHelper(startingNode.getRightChild());
    }
}
