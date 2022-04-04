import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree binaryTree;
    private BinaryTreeNode<Integer> root;

    @BeforeEach
    void setUp(){
        binaryTree = new BinaryTree();
        root = new BinaryTreeNode<>(20);
    }

    @Test
    void setRootSetsRoot(){
        binaryTree.setRoot(root);

        assertNotNull(binaryTree.getRoot());
    }

    @Test
    void setRootSetsCorrectRoot(){
        binaryTree.setRoot(root);

        assertEquals(root, binaryTree.getRoot());
    }

    @Test
    void isEmptyTrueIfNoRoot(){
        assertTrue(binaryTree.isEmpty());
    }

    @Test
    void isEmptyFalseIfRoot(){
        binaryTree.setRoot(root);
        assertFalse(binaryTree.isEmpty());
    }

    @Test
    void sizeReturnsZeroIfTreeEmpty(){
        assertEquals(0, binaryTree.size());
    }

    @Test
    void sizeReturnsOneIfRootHasNoChildren(){
        binaryTree.setRoot(root);
        assertEquals(1, binaryTree.size());
    }

    @Test
    void sizeCanHandleFirstGenerationBothChildren(){
        //arrange
        BinaryTreeNode<Integer> child1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> child2 = new BinaryTreeNode<>(2);
        binaryTree.setRoot(root);

        //act
        root.addLeftChild(child1);
        root.addRightChild(child2);

        //assert
        assertEquals(3, binaryTree.size());
    }

    @Test
    void sizeCanHandleFirstGenerationOneChild(){
        BinaryTreeNode<Integer> child1 = new BinaryTreeNode<>(1);
        binaryTree.setRoot(root);

        root.addLeftChild(child1);

        assertEquals(2, binaryTree.size());
    }

    //Size of populated tree = 7
    @Test
    void sizeCanHandleMultipleGenerations(){
        populateTreeWithMultipleGenerations();

        assertEquals(7, binaryTree.size());
    }

    @Test
    void containsReturnsTrueIfElementInTree(){
        binaryTree.setRoot(root);
        assertTrue(binaryTree.contains(root));
    }

    @Test
    void containsReturnsFalseIfElementNotInTree(){
        assertFalse(binaryTree.contains(root));
    }

    @Test
    void containsCanFindElementWithMultipleGenerations(){
        populateTreeWithMultipleGenerations();

        assertTrue(binaryTree.contains(root.getLeftChild().getLeftChild()));
    }

    @Test
    void containsCanDetermentWhenElementNotInTreeWithMultipleGenerations(){
        populateTreeWithMultipleGenerations();

        assertFalse(binaryTree.contains(new BinaryTreeNode<>(200)));
    }

    @Test
    void containsReturnsFalseIfGivenNull(){
        assertFalse(binaryTree.contains(null));
    }

    @Test
    void inOrderReturnsListOfElements(){
        assertNotNull(binaryTree.inOrder());
    }

    @Test
    void inOrderTraversalTakesElementInRightOrderAndContainsAllElements(){

        populateTreeWithMultipleGenerations();

        ArrayList<Integer> inOrderList = new ArrayList<>(Arrays.asList(3, 1, 4, 20, 6, 5, 2));

        assertArrayEquals(inOrderList.toArray(), binaryTree.inOrder().toArray());

    }

    @Test
    void preOrderReturnsListOfElements(){
        assertNotNull(binaryTree.preOrder());
    }

    @Test
    void preOrderHasCorrectStartingElement(){
        binaryTree.setRoot(root);

        assertEquals(root.getElement(), binaryTree.preOrder().get(0));
    }

    @Test
    void preOrderTraversalTakesElementInRightOrderAndContainsAllElements(){
        populateTreeWithMultipleGenerations();

        ArrayList<Integer> preOrderList = new ArrayList<>(Arrays.asList(20, 1, 3, 4, 2, 5, 6));

        assertArrayEquals(preOrderList.toArray(), binaryTree.preOrder().toArray());
    }

    @Test
    void postOrderReturnsListOfElements(){
        assertNotNull(binaryTree.postOrder());
    }

    @Test
    void postOrderHasCorrectStartingElement(){
        binaryTree.setRoot(root);

        assertEquals(root.getElement(), binaryTree.postOrder().get(0));
    }

    @Test
    void postOrderTraversalTakesElementInRightOrderAndContainsAllElements(){
        populateTreeWithMultipleGenerations();

        ArrayList<Integer> postOrderList = new ArrayList<>(Arrays.asList(3, 4, 1, 6, 5, 2, 20));

        assertArrayEquals(postOrderList.toArray(), binaryTree.postOrder().toArray());
    }

    @Test
    void levelOrderReturnsListOfElements(){
        assertNotNull(binaryTree.levelOrder());
    }

    @Test
    void levelOrderHasCorrectStartingElement(){
        binaryTree.setRoot(root);

        assertEquals(root.getElement(), binaryTree.levelOrder().get(0));
    }



    @Test
    void levelOrderTraversalTakesElementInRightOrderAndContainsAllElements(){
        populateTreeWithMultipleGenerations();

        ArrayList<Integer> levelOrderList = new ArrayList<>(Arrays.asList(20, 1, 2, 3, 4, 5, 6));

        assertArrayEquals(levelOrderList.toArray(), binaryTree.levelOrder().toArray());
    }

    @Test
    void heightReturnsMinusOneIfTreeEmpty(){
        assertEquals(-1, binaryTree.height());
    }

    @Test
    void heightReturnsOneIfRootHasNoChildren(){
        binaryTree.setRoot(root);
        assertEquals(1, binaryTree.height());
    }

    @Test
    void heightCanHandleFirstGenerationBothChildren(){
        //arrange
        BinaryTreeNode<Integer> child1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> child2 = new BinaryTreeNode<>(2);
        binaryTree.setRoot(root);

        //act
        root.addLeftChild(child1);
        root.addRightChild(child2);

        //assert
        assertEquals(2, binaryTree.height());
    }


    //Height of populated tree = 7
    @Test
    void heightCanHandleMultipleGenerations(){
        populateTreeWithMultipleGenerations();

        assertEquals(4, binaryTree.height());
    }

    private void populateTreeWithMultipleGenerations() {
        BinaryTreeNode<Integer> child1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> child2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> child3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> child4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> child5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> child6 = new BinaryTreeNode<>(6);
        binaryTree.setRoot(root);

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
    }

}