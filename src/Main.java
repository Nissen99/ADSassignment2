public class Main {
    public static void main(String[] args) {


        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);

        root.addLeftChild(node1);
        root.addRightChild(node2);

        node1.addLeftChild(node3);
        node3.addRightChild(node4);
        node1.addLeftChild(node4);

        BinaryTreePrint printer = new BinaryTreePrint();

        printer.printTree(root);
        printer.printTree(node3);
    }

}


