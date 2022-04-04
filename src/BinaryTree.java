import java.util.*;

public class BinaryTree {

    private BinaryTreeNode root;

    public void setRoot(BinaryTreeNode<Integer> root) {
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        if (isEmpty()){
            return 0;
        }
        return size(root);
    }

    private int size(BinaryTreeNode node){
        if (node == null){
            return 0;
        }
        return size(node.getLeftChild()) + 1 +  size(node.getRightChild());
    }

    public boolean contains(BinaryTreeNode node) {
        if (node == null || isEmpty()){
            return false;
        }
        return contains(node, root);
    }

    private boolean contains(BinaryTreeNode node, BinaryTreeNode nodeToCheck){
        if (nodeToCheck.getElement() == node.getElement()){
            return true;
        }

        if (nodeToCheck.getRightChild() == null && nodeToCheck.getLeftChild() == null){
            return false;
        } else if (nodeToCheck.getRightChild() == null){
            return contains(node, nodeToCheck.getLeftChild());
        } else if (nodeToCheck.getLeftChild() == null){
            return contains(node, nodeToCheck.getRightChild());
        }
        return contains(node, nodeToCheck.getLeftChild()) || contains(node, nodeToCheck.getRightChild());
    }

    public ArrayList<Object> inOrder() {
        if (isEmpty()){
            return new ArrayList<>();
        }

        ArrayList<Object> inOrderArray = new ArrayList<>();

        inOrderAdded(inOrderArray, root);

    return inOrderArray;
    }

    private void inOrderAdded(ArrayList<Object> currentArray, BinaryTreeNode nodeToAdd){
        if (nodeToAdd == null){
            return;
        }
        inOrderAdded(currentArray, nodeToAdd.getLeftChild());
        currentArray.add(nodeToAdd.getElement());
        inOrderAdded(currentArray, nodeToAdd.getRightChild());
    }

    public ArrayList<Object> preOrder() {

        ArrayList<Object> currentArray = new ArrayList<>();

        preOrderAdded(currentArray, root);
        return currentArray;
    }

    private void preOrderAdded(ArrayList<Object> currentArray, BinaryTreeNode nodeToAdd){
        if (nodeToAdd == null){
            return;
        }
        currentArray.add(nodeToAdd.getElement());
        preOrderAdded(currentArray, nodeToAdd.getLeftChild());
        preOrderAdded(currentArray, nodeToAdd.getRightChild());
    }

    public ArrayList<Object> postOrder() {
        ArrayList<Object> currentArray = new ArrayList<>();

        postOrderAdded(currentArray, root);

        return currentArray;
    }

    private void postOrderAdded(ArrayList<Object> currentArray, BinaryTreeNode nodeToAdd){
        if (nodeToAdd == null){
            return;
        }
        postOrderAdded(currentArray, nodeToAdd.getLeftChild());
        postOrderAdded(currentArray, nodeToAdd.getRightChild());
        currentArray.add(nodeToAdd.getElement());


    }

    public ArrayList<Object> levelOrder() {
        ArrayList<Object> currentArray = new ArrayList<>();

        Queue<BinaryTreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()){

                BinaryTreeNode currentNode = nodeQueue.poll();

                if (currentNode != null){
                    currentArray.add(currentNode);
                    nodeQueue.add(currentNode.getLeftChild());
                    nodeQueue.add(currentNode.getRightChild());
                }
        }
        return currentArray;
    }


    public int height() {
        if (isEmpty()){
            return -1;
        }

        return heightFromNode(root);
    }

    private int heightFromNode(BinaryTreeNode node){
        if (node == null){
            return 0;
        }
        int rightHeight = heightFromNode(node.getRightChild());
        int leftHeight = heightFromNode(node.getLeftChild());

        if (rightHeight > leftHeight){
            return rightHeight + 1;
        }
        return leftHeight + 1;
    }

}
