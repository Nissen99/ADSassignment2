import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {


    BinarySearchTree binarySearchTree;

    @BeforeEach
    void setUp(){
        binarySearchTree = new BinarySearchTree();

    }

    @Test
    void insertZero(){
        assertThrows(NullPointerException.class, () -> binarySearchTree.insert(null));
    }

    @Test
    void insertOne(){
        assertTrue(binarySearchTree.insert(1));
    }

    @Test
    void insertDuplicate(){
        assertTrue(binarySearchTree.insert(1));
        assertFalse(binarySearchTree.insert(1));

    }

    @Test
    void insertManyElements(){
        binarySearchTree.insert(1);
        assertTrue(binarySearchTree.insert(2));
        assertTrue(binarySearchTree.insert(3));
        assertTrue(binarySearchTree.insert(-2));
        assertTrue(binarySearchTree.insert(-3));

    }


    @Test
    void insertManyElementsWithDuplicate(){
        binarySearchTree.insert(1);
        assertTrue(binarySearchTree.insert(2));
        assertTrue(binarySearchTree.insert(3));
        assertFalse(binarySearchTree.insert(1));
    }

    @Test
    void removeElementRemovesElementFromTree(){
        populateTree();
        binarySearchTree.insert(20);
        int sizeBefore = binarySearchTree.size();
        assertTrue(binarySearchTree.removeElement(20));
        assertEquals(sizeBefore-1, binarySearchTree.size());

    }

    @Test
    void findMinReturnsMinimum(){
        populateTree();

        binarySearchTree.insert(Integer.MIN_VALUE);

        assertEquals(Integer.MIN_VALUE, binarySearchTree.findMin());
    }

    @Test
    void findMaxReturnsMinimum(){
        populateTree();

        binarySearchTree.insert(Integer.MAX_VALUE);

        assertEquals(Integer.MAX_VALUE, binarySearchTree.findMax());
    }

    @Test
    void containsFindsCorrectElement(){
        populateTree();

        binarySearchTree.insert(22);
        assertTrue(binarySearchTree.contains(new BinarySearchTreeNode(22)));
    }

    @Test
    void containsDoesNotFindElementNotInTree(){
        populateTree();

        binarySearchTree.insert(22);
        assertFalse(binarySearchTree.contains(new BinarySearchTreeNode(2222)));
    }

    @Test
    void rebalancePutsTreeInBalance(){
    assertTrue(binarySearchTree.rebalance());
    }

    private void populateTree() {
        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(-2);
        binarySearchTree.insert(-3);
    }

}