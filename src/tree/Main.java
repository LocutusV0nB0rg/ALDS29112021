package tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        System.out.println("tree.getHeight() = " + tree.getHeight());
        System.out.println("tree.getNumberOfNodes() = " + tree.getNumberOfNodes());
        System.out.println("tree.getNumberOfLeaves() = " + tree.getNumberOfLeaves());
        System.out.println("tree.getPathLength() = " + tree.getPathLength());
    }
}
