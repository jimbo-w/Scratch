package datastructure;

import java.util.*;
import java.util.LinkedList;

import static datastructure.BinaryTree.TraversalType.*;

public class BinaryTree<T extends Comparable<T>> {

    private class Node {
        T value;
        Node left, right = null;

        public Node(T value) {
            this.value = value;
        }
    }

    enum TraversalType {
        DFS, BFS
    }

    Node root = null;

    public void add(T value) {
        if (root == null) {
            root = new Node(value);
        } else {
            add(value, root);
        }
    }

    private void add(T value, Node node) {
        if (value.compareTo(node.value) < 0) {  // less than
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                add(value, node.left);
            }
        } else if (value.compareTo(node.value) > 0) {  // greater than
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                add(value, node.right);
            }
        }
        // else, do nothing
    }

    public boolean exists(T value) {
        return root != null && depthFirstSearch(value, root);
    }

    private boolean depthFirstSearch(T value, Node node) {

        if (value.compareTo(node.value) < 0) {
            return node.left != null && depthFirstSearch(value, node.left);
        } else if (value.compareTo(node.value) > 0) {
            return node.right != null && depthFirstSearch(value, node.right);
        } else {
            return true;
        }
    }

    public Set<T> traverse() {
        return traverse(DFS);
    }

    public Set<T> traverse(TraversalType type) {

        switch (type) {
            case DFS: return depthFirstTraversal(root);
            case BFS: return breadthFirstTraversal();
            default: throw new IllegalArgumentException(String.format("Unrecognised traversal type: %s", type.name()));
        }

    }

    private Set<T> depthFirstTraversal(Node node) {
        Set<T> set = new LinkedHashSet<>();

        if(root == null)
            return set;
        else {
            if(node.left != null) set.addAll(depthFirstTraversal(node.left));
            set.add(node.value);
            if(node.right != null) set.addAll(depthFirstTraversal(node.right));
        }

        return set;
    }

    public Set<T> breadthFirstTraversal() {
        Set<T> set = new LinkedHashSet<>();

        if (root == null) {
            return set;
        } else {
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                Node n = q.remove();
                set.add(n.value);

                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
        }

        return set;
    }

    @Override
    public String toString() {
        return depthFirstTraversal(root).toString();
    }

    public boolean isBalanced() {
        Node n = root;
        
        if(n == null) return true;
        else {
            int heightLeft = getHeight(n.left);
        }

        return false;
    }

    private int getHeight(Node left) {
        return 0;
    }
}
