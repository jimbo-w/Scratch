package sorting;

import java.util.ArrayList;
import java.util.List;

public class Mergesort {

    public static List<Number> sort(List<Number> l) {

        if (l.size() <= 1) {
            return l;
        } else {
            int mid = l.size() / 2;
            List<Number> left = sort(l.subList(0, mid));
            List<Number> right = sort(l.subList(mid, l.size() - 1));

            return merge(left, right);
        }
    }

    private static List<Number> merge(List<Number> left, List<Number> right) {
        List<Number> merged = new ArrayList<>(left.size() + right.size());

        while (left.size() > 0 && right.size() > 0) {

            if (left.get(0).floatValue() <= right.get(0).floatValue()) {
                merged.add(left.get(0));
                left = left.subList(1, left.size());
            } else {
                merged.add(right.get(0));
                right = right.subList(1, right.size());
            }

        }

        while (left.size() > 0) {
            merged.addAll(left);
        }

        while (right.size() > 0) {
            merged.addAll(right);
        }

        return merged;
    }
}
