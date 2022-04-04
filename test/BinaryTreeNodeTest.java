
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test bliver lavet med Integer, det skyldes at det implementere interfacet comparable.
 * Og er den data type vi tiltænker vores tree skal bruges til.
 */

class BinaryTreeNodeTest {

    BinaryTreeNode<Integer> treeNode;

    @BeforeEach
    void setUp(){
      treeNode = new BinaryTreeNode<>(20);
    }

    @Test
    void constructorSetsElement(){
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(2);

        assertNotNull(treeNode.getElement());
    }


    @Test
void setElementTakesElementAsInput(){
        treeNode.setElement(20);
        assertEquals(20, treeNode.getElement());
}

    @Test
    void setElementWithNullThrowsNullPointerException(){
        assertThrows(NullPointerException.class, () -> treeNode.setElement(null));
    }

    @Test
    void setElementOverridesPreviouslySatElement(){
        treeNode.setElement(20);
        treeNode.setElement(22);
        assertEquals(22, treeNode.getElement());

    }


    @Test
    void addLeftChildAddsLeftChildToNode(){
        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(2);

        treeNode.addLeftChild(leftChild);
        assertNotEquals(null, treeNode.getLeftChild());
    }

    @Test
    void addLeftChildAddsCorrectChildToNode(){
        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(2);

        treeNode.addLeftChild(leftChild);
        assertEquals(leftChild, treeNode.getLeftChild());
    }

    @Test
    void addLeftChildWithNullThrowsNullPointerException(){
        assertThrows(NullPointerException.class, () -> treeNode.addLeftChild(null));
    }

    @Test
    void addRightChildAddsRightChildToNode(){
        BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(2);

        treeNode.addRightChild(rightChild);
        assertNotEquals(null, treeNode.getRightChild());
    }

    @Test
    void addRightChildAddsCorrectRightChildToNode(){
        BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(2);

        treeNode.addRightChild(rightChild);
        assertEquals(rightChild, treeNode.getRightChild());
    }

    @Test
    void addRightChildWithNullThrowsNullPointerException(){
        assertThrows(NullPointerException.class, () -> treeNode.addRightChild(null));
    }

    @Test
    void getLeftChildReturnsNullIfNoElementSat(){
        assertEquals(null, treeNode.getLeftChild());

    }

    @Test
    void getRightChildReturnsNullIfNoElementSat(){
        assertEquals(null, treeNode.getRightChild());

    }
}