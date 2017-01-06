package generics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TypeErasure {

    static class Node<T extends List,Q extends Set> {

        void getSomething(T input) {
            System.out.println(input + " t");
        }

        void getSomeThing(Q input) {
            System.out.println(input + " q");
        }
    }

    public static void main(String[] args) {
        Node<List, Set> node = new Node<>();

        node.getSomeThing(new HashSet<>());
        //node.getSomeThing(new ArrayList<>());
    }


}
