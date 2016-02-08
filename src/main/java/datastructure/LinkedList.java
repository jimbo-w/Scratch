package datastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedList<T> {
    private static final Logger logger = LoggerFactory.getLogger(LinkedList.class);

    Node<T> root = null;

    private class Node<T> {
        T value;
        Node<T> next = null;

        public Node(T value) {
            this.value = value;
        }
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = root;
        root = node;
    }

    public void addLast(T value) {
        Node<T> node = root;

        if (root == null) {
            root = new Node<>(value);
        } else {

            while (node.next != null) {  // O(n)
                node = node.next;
            }

            node.next = new Node<>(value);
        }
    }

    public T removeFirst() {

        if (root == null) {
            return null;
        } else {
            T value = root.value;
            root = root.next;

            return value;
        }

    }

    public T removeLast() {
        if (root == null) {

            return null;
        } else if (root.next == null) {
            T value = root.value;
            root = null;

            return value;
        } else {
            Node<T> next = root;
            Node<T> nextNext = root.next;

            while (nextNext.next != null) {  // O(n)
                next = next.next;
                nextNext = nextNext.next;
            }

            T value = nextNext.value;
            next.next = null;

            return value;
        }

    }

    public T remove(T item) {

        if (item == null)
            throw new NullPointerException(("argument can not be null"));

        if (root == null) {
            return null;
        }
        else if (root.next == null) {
            // 1 element in the list

            if (item.equals(root.value)) {
                T value = root.value;
                root = null;

                return value;
            }

        } else {
            // >=2 element in the list
            Node<T> node = root;

            while (node.next != null) {  // O(n)

                if (item.equals(node.next.value)) {
                    T value = node.next.value;
                    node.next = node.next.next;

                    return value;
                }

                node = node.next.next;
            }

        }

        return null;
    }

    public static void main(String[] args) {

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder().append("{");
        Node node = root;

        while (node != null) {
            builder.append(node.value).append(",");
            node = node.next;
        }

        return builder.append("}").toString();
    }
}
