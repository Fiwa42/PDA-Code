package IntBinTree;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntBinTreeTest{

    @Test
    public void testIntBinTree1(){
        //create test trees
        Integer [] values = {1,2,3,4,5,6,7};
        Integer [] expected = {4,2,5,1,6,3,7};

        IntBinTree tree1 = IntBinTree.createTree(values); //Perfect Tree

        assertArrayEquals(expected,tree1.inorder());
        assertEquals(3, tree1.getHeight());

        assertEquals(true, tree1.isComplete());
        assertEquals(true, tree1.isFull());
        assertEquals(true, tree1.isPerfect());
    }

    @Test
    public void testIntBinTree2(){
        //create tree
        IntBinTree tree8 = new IntBinTree(8);
        IntBinTree tree9 = new IntBinTree(9);
        IntBinTree tree4 = new IntBinTree(4);
        IntBinTree tree7 = new IntBinTree(7);

        IntBinTree tree5 = new IntBinTree(tree8,5,null);
        IntBinTree tree6 = new IntBinTree(null,6,tree9);

        IntBinTree tree3 = new IntBinTree(tree6, 3, tree7);
        IntBinTree tree2 = new IntBinTree(tree4, 2, tree5);

        IntBinTree treeFinal = new IntBinTree(tree2, 1, tree3);

        //test
        Integer [] expected = {4,2,8,5,1,6,9,3,7};

        assertArrayEquals(expected, treeFinal.inorder());
        assertEquals(4,treeFinal.getHeight());
        assertEquals(5,treeFinal.countInnerNodes());
        assertEquals(4,treeFinal.countLeaves());

        assertEquals(false,treeFinal.isFull());
        assertEquals(false,treeFinal.isComplete());
        assertEquals(false,treeFinal.isPerfect());
    }

    @Test
    public void testIntBinTree3(){
        //create tree
        IntBinTree tree8 = new IntBinTree(8);
        IntBinTree tree9 = new IntBinTree(9);
        IntBinTree tree4 = new IntBinTree(4);
        IntBinTree tree6 = new IntBinTree(6);
        IntBinTree tree10 = new IntBinTree(10);
        IntBinTree tree11 = new IntBinTree(11);

        IntBinTree tree5 = new IntBinTree(tree8,5,tree9);
        IntBinTree tree7 = new IntBinTree(tree10,7,tree11);

        IntBinTree tree3 = new IntBinTree(tree6, 3, tree7);
        IntBinTree tree2 = new IntBinTree(tree4, 2, tree5);

        IntBinTree treeFinal = new IntBinTree(tree2, 1, tree3);

        //test
        Integer [] expected = {4,2,8,5,9,1,6,3,10,7,11};

        assertArrayEquals(expected, treeFinal.inorder());
        assertEquals(4,treeFinal.getHeight());
        assertEquals(5,treeFinal.countInnerNodes());
        assertEquals(6,treeFinal.countLeaves());

        assertEquals(true,treeFinal.isFull());
        assertEquals(false,treeFinal.isComplete());
        assertEquals(false,treeFinal.isPerfect());
    }

    @Test
    public void testIntBinTree4(){
        //create tree
        IntBinTree tree9 = new IntBinTree(9);
        IntBinTree tree10 = new IntBinTree(10);
        IntBinTree tree4 = new IntBinTree(4);
        IntBinTree tree7 = new IntBinTree(7);
        IntBinTree tree8 = new IntBinTree(tree9,8,tree10);

        IntBinTree tree5 = new IntBinTree(tree7,5,null);
        IntBinTree tree6 = new IntBinTree(tree8,6,null);

        IntBinTree tree3 = new IntBinTree(null, 3, tree6);
        IntBinTree tree2 = new IntBinTree(tree4, 2, tree5);

        IntBinTree treeFinal = new IntBinTree(tree2, 1, tree3);

        //test
        Integer [] expected = {4,2,7,5,1,3,9,8,10,6};

        assertArrayEquals(expected, treeFinal.inorder());
        assertEquals(5,treeFinal.getHeight());
        assertEquals(6,treeFinal.countInnerNodes());
        assertEquals(4,treeFinal.countLeaves());

        assertEquals(false,treeFinal.isFull());
        assertEquals(false,treeFinal.isComplete());
        assertEquals(false,treeFinal.isPerfect());
    }

    @Test
    public void testIntBinTree5(){
        //create tree
        IntBinTree tree4 = new IntBinTree(4);
        IntBinTree tree5 = new IntBinTree(5);
        IntBinTree tree6 = new IntBinTree(6);

        IntBinTree tree2 = new IntBinTree(tree4, 2, tree5);
        IntBinTree tree3 = new IntBinTree(tree6, 3, null);

        IntBinTree treeFinal = new IntBinTree(tree2, 1, tree3);

        //test
        Integer [] expected = {4,2,5,1,6,3};

        assertArrayEquals(expected, treeFinal.inorder());
        assertEquals(3,treeFinal.getHeight());
        assertEquals(3,treeFinal.countInnerNodes());
        assertEquals(3,treeFinal.countLeaves());

        assertEquals(false,treeFinal.isFull());
        assertEquals(true,treeFinal.isComplete());
        assertEquals(false,treeFinal.isPerfect());
    }
}