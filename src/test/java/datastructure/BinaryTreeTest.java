package datastructure;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinaryTreeTest {
    private static final Logger logger = LoggerFactory.getLogger(BinaryTreeTest.class);

    @Test
    public void binaryTree() {
        BinaryTree<Integer> btree = new BinaryTree<>();
        Arrays.asList(3, 1, 2, 4, 5).forEach(btree::add);

        assertThat(btree.exists(2), is(true));
        assertThat(btree.exists(5), is(true));
        assertThat(btree.exists(10), is(false));

        Set<Integer> s = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        assertThat(btree.traverse(), is(s));

        logger.info("In order traversal of tree {}", btree);

        assertThat(btree.height(), is(3));
        assertThat(btree.isBalanced(), is(true));
    }

    @Test
    public void unbalancedTree() {
        BinaryTree<Integer> btree = new BinaryTree<>(Arrays.asList(1, 2, 3));
        assertThat("The tree should be unbalanced", btree.isBalanced(), is(false));
    }

    @Test
    public void breadthFirstTraversal() {
        BinaryTree<Integer> btree = new BinaryTree<>();
        Arrays.asList(3, 1, 0, 2, 4, 6, 5).forEach(btree::add);

        Set<Integer> s = btree.traverse(BinaryTree.TraversalType.BFS);
        logger.info("Breadth First Traversal of Binary Tree: {}", s);

        assertThat(s.toString(), is("[3, 1, 4, 0, 2, 6, 5]"));
    }
}
