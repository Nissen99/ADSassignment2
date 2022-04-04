public class Main {
    public static void main(String[] args) {


        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(-2);
        binarySearchTree.insert(-3);
        binarySearchTree.insert(20);

        BinaryTreePrint printer = new BinaryTreePrint();
        printer.printTree(binarySearchTree.getRoot());
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println( binarySearchTree.removeElement(20));

        printer.printTree(binarySearchTree.getRoot());

    }

}


