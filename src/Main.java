public class Main {
    public static void main(String[] args) {


        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> child1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> child2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> child3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> child4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> child5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> child6 = new BinaryTreeNode<>(6);

        //Adding roots children
        root.addLeftChild(child1);
        root.addRightChild(child2);

        //adding children to roots left child
        child1.addLeftChild(child3);
        child1.addRightChild(child4);

        //adding child to root right side
        child2.addLeftChild(child5);
        //adding to child of child of root
        child5.addLeftChild(child6);
        BinaryTreePrint printer = new BinaryTreePrint();
        printer.printTree(root);
    }

}


