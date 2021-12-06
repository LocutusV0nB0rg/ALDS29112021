package tree;

public class TreeNode {
    private int key;

    private TreeNode leftChild = null;
    private TreeNode rightChild = null;

    public TreeNode(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
