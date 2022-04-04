public class BinarySearchTree extends BinaryTree {


    public boolean insert(Comparable element) {
        if (getRoot() == null) {
            setRoot(new BinarySearchTreeNode(element));
            return true;
        }
        BinarySearchTreeNode root = (BinarySearchTreeNode) getRoot();


        return insertRecursive(root, element);
    }

    private boolean insertRecursive(BinarySearchTreeNode node, Comparable element) {

        if (element.compareTo(node.getElement()) < 0) {
            if (node.getLeftChild() == null) {
                node.addLeftChild(new BinarySearchTreeNode(element));
                return true;
            }
            return insertRecursive((BinarySearchTreeNode) node.getLeftChild(), element);
        } else if (element.compareTo(node.getElement()) > 0) {

            if (node.getRightChild() == null) {
                node.addRightChild(new BinarySearchTreeNode(element));
                return true;
            }
            return insertRecursive((BinarySearchTreeNode) node.getRightChild(), element);
        }
        return false;
    }


    public boolean removeElement(Comparable element) {
        if (isEmpty()) {
            return false;
        }

       BinarySearchTreeNode temp =  removeRecursive((BinarySearchTreeNode) getRoot(), element);

        if (temp == null){
            return false;
        }

        return true;

    }

    private BinarySearchTreeNode removeRecursive(BinarySearchTreeNode node, Comparable element) {

        if (node == null) {
            return null;
        }

        if (element.compareTo(node.getElement()) < 0) {
            node.addLeftChild(removeRecursive((BinarySearchTreeNode) node.getLeftChild(), element));
        } else if (element.compareTo(node.getElement()) > 0) {
            node.addRightChild(removeRecursive((BinarySearchTreeNode) node.getRightChild(), element));
        }
        else {

            if (node.getLeftChild() != null && node.getRightChild() != null) {
                BinarySearchTreeNode temp = node;

                BinarySearchTreeNode smallestFromRight = minimumElement((BinarySearchTreeNode) temp.getRightChild());

                node.setElement(smallestFromRight.getElement());
                node.addRightChild(removeRecursive((BinarySearchTreeNode) node.getRightChild(), (Comparable) smallestFromRight.getElement()));
            } else if (node.getLeftChild() != null) {
                node = (BinarySearchTreeNode) node.getLeftChild();
            } else if (node.getRightChild() != null) {
                node = (BinarySearchTreeNode) node.getRightChild();
            } else {
                node = null;

            }
        }
        return node;
    }


    private BinarySearchTreeNode minimumElement(BinarySearchTreeNode node) {
        if (node.getLeftChild() == null){
            return node;
        }
        return minimumElement((BinarySearchTreeNode) node.getLeftChild());
    }


    public Comparable findMin() {
        return (Comparable) minimumElement((BinarySearchTreeNode) getRoot()).getElement();
    }

    public Comparable findMax() {
        return (Comparable) maximumElement((BinarySearchTreeNode) getRoot()).getElement();
    }

    private BinarySearchTreeNode maximumElement(BinarySearchTreeNode node){
        if (node.getRightChild() == null){
            return node;
        }
        return maximumElement((BinarySearchTreeNode) node.getRightChild());
    }

    public boolean rebalance() {
        return true;
    }
}
