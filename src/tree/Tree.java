package tree;

public class Tree {
    private TreeNode root;

    // Kommentar von Robert: Chantal bekommt viel Kindergeld!
    public Tree() {
        TreeNode chantal = new TreeNode(0);
        chantal.setLeftChild(new TreeNode(1));
        chantal.setRightChild(new TreeNode(2));

        chantal.getLeftChild().setLeftChild(new TreeNode(3));
        chantal.getLeftChild().setRightChild(new TreeNode(4));

        chantal.getRightChild().setRightChild(new TreeNode(5));

        chantal.getLeftChild().getLeftChild().setLeftChild(new TreeNode(6));
        chantal.getLeftChild().getLeftChild().setRightChild(new TreeNode(7));

        chantal.getLeftChild().getRightChild().setRightChild(new TreeNode(8));

        chantal.getRightChild().getRightChild().setLeftChild(new TreeNode(9));
        this.root = chantal;
    }

    public void printLrw() {
        printLrwHelper(root);
    }

    private void printLrwHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        printLrwHelper(root.getLeftChild());
        printLrwHelper(root.getRightChild());

        System.out.println(root.getKey());
    }

    public void printLwr() {
        printLwrHelper(root);
    }

    private void printLwrHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        printLwrHelper(root.getLeftChild());

        System.out.println(root.getKey());

        printLwrHelper(root.getRightChild());
    }


    public void printWlr() {
        printWlrHelper(root);
    }

    private void printWlrHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.getKey());

        printWlrHelper(root.getLeftChild());
        printWlrHelper(root.getRightChild());
    }

    public Tree(TreeNode root) {
        this.root = root;
    }

    public int getHeight() {
        return getHeightHelper(root);
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

    public int getPathLength() {
        return getPathLengthHelper(root, 0);
    }

    private int getPathLengthHelper(TreeNode startingNode, int level) {
        if (startingNode == null) return 0;

        return getPathLengthHelper(startingNode.getLeftChild(), level + 1) +
                getPathLengthHelper(startingNode.getRightChild(), level + 1) +
                level;
    }

    public boolean isAVLTree() {
        return isBalanced(this.root) && isBinarySearchTree(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int getHeightHelper(TreeNode startingNode) {
        if (startingNode == null) return 0;

        final int heightLeft = getHeightHelper(startingNode.getLeftChild());
        final int heightRight = getHeightHelper(startingNode.getRightChild());

        return Math.max(heightLeft, heightRight) + 1;
    }

    private boolean isBalanced(TreeNode startingNode) {
        if (startingNode == null)
            return true;

        final int leftHeight = getHeightHelper(startingNode.getLeftChild());
        final int rightHeight = getHeightHelper(startingNode.getRightChild());

        return Math.abs(leftHeight - rightHeight) <= 1 &&
                isBalanced(startingNode.getLeftChild()) &&
                isBalanced(startingNode.getRightChild());
    }

    private boolean isBinarySearchTree(TreeNode startingNode, int min, int max) {
        if (startingNode == null)
            return true;

        if (startingNode.getKey() < min || startingNode.getKey() > max)
            return false;

        return isBinarySearchTree(startingNode.getLeftChild(), min, startingNode.getKey() - 1) &&
                isBinarySearchTree(startingNode.getRightChild(), startingNode.getKey() + 1, max);
    }

    public void addNodeToBinarySearchTree(TreeNode nodeToAdd) {
        if (!isAVLTree()) throw new RuntimeException("No AVL Tree");

        if (this.root == null) {
            this.root = nodeToAdd;
            return;
        }

        sortIntoSubTree(this.root, nodeToAdd);
    }

    public void sortIntoSubTree(TreeNode currentRoot, TreeNode nodeToAdd) {
        if (currentRoot.getKey() > nodeToAdd.getKey()) {
            if (currentRoot.getLeftChild() == null) {
                currentRoot.setLeftChild(nodeToAdd);
            } else {
                sortIntoSubTree(currentRoot.getLeftChild(), nodeToAdd);
            }
        } else {
            if (currentRoot.getRightChild() == null) {
                currentRoot.setRightChild(nodeToAdd);
            } else {
                sortIntoSubTree(currentRoot.getRightChild(), nodeToAdd);
            }
        }
    }
}
