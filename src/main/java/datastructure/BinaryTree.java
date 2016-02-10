package datastructure;

import java.util.*;
import java.util.LinkedList;

public class BinaryTree<T extends Comparable<T>> {

    private class Node {
        T value;
        Node left, right = null;

        public Node(T value) {
            this.value = value;
        }
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
        return traverse(root);
    }

    private Set<T> traverse(Node node) {
        Set<T> set = new LinkedHashSet<>();

        if(root == null)
            return set;
        else {
            if(node.left != null) set.addAll(traverse(node.left));
            set.add(node.value);
            if(node.right != null) set.addAll(traverse(node.right));
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
        return traverse(root).toString();
    }
}
