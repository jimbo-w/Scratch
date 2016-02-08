package algorithm;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Powerset {

    public static <T> Set<Set<T>> powerset(Set<T> s) {
        Set<Set<T>> ps = new LinkedHashSet<>();
        ps.add(new LinkedHashSet<>());
        ps.add(s);

        if(s.size() <= 1) {
            return ps;
        } else {
            T head = new LinkedList<>(s).getFirst();

            List<T> tailList = new LinkedList<>(s);
            tailList.remove(0);
            Set<T> tail  = new LinkedHashSet<>(tailList);

            // addAll() == Set Union
            ps.addAll(merge(head, powerset(tail)));

            return ps;
        }
    }

    private static <T> Set<Set<T>> merge(T head, Set<Set<T>> tail) {
        Set<Set<T>> mergeSet = new LinkedHashSet<>();

        for(Set<T> i : tail) {
            Set<T> merge = new LinkedHashSet<>(i);
            merge.add(head);

            mergeSet.add(i);
            mergeSet.add(merge);
        }

        return mergeSet;
    }

}
