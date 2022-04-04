import java.util.NoSuchElementException;

public class BinaryTreeNode<E> {

    private E element;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;

    public BinaryTreeNode(E element) {
        setElement(element);
    }

    public void setElement(E element) {
        if (element == null){
            throw new NullPointerException();
        }
    this.element = element;
    }

    public E getElement() {

        return element;
    }

    public void addLeftChild(BinaryTreeNode<E> leftChild) {
        if (leftChild == null){
            throw new NullPointerException();
        }
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void addRightChild(BinaryTreeNode<E> rightChild) {
        if (rightChild == null){
            throw new NullPointerException();
        }
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }
}
