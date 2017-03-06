package hackerrank.nondivisiblesubset;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();
        int k = scan.nextInt();

        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < size; i++) {
            s.add(scan.nextInt());
        }
        scan.close();

        System.out.println(nonDivisibleSubsetsUsingRemainders(k, s));
    }

    static int nonDivisibleSubsetsUsingRemainders(int k, Set<Integer> set) {
        int[] remainders = new int[k];
        set.forEach(i -> remainders[i % k] += 1);

        int res = 0;

        for(int i=0; i*2 <= remainders.length; i++) {
            if(i == 0) {
                if(remainders[i] > 0)
                    res++;
            }
            else if(i == k/2 && k % 2 == 0 && remainders[i] > 0) {
                res++;
            }
            else {
                res += Math.max(remainders[i], remainders[k - i]);
            }
        }

        return res;
    }

    public static int nonDivisibleSubsetsRecursive(int k, Set<Integer> originalSet) {
        return getSubsets(k, originalSet).stream()
                .map(Set::size)
                .max(Integer::compareTo)
                .orElse(0);
    }

    private static Set<Set<Integer>> getSubsets(int k, Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<>();
        List<Integer> list = new ArrayList<>(originalSet);

        if (originalSet.isEmpty()) {
            sets.add(new HashSet<>());
            return sets;
        }

        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<>(list.subList(1, list.size()));

        loop: for (Set<Integer> set : getSubsets(k, rest)) {
            Set<Integer> newSet = new HashSet<>();
            sets.add(set);

            boolean divisibleBy = false;
            if (set.size() > 0) {
                for (int i : set) {
                    if ((head + i) % k == 0) {
                        continue loop;
                    }
                }
            }
            else {
                divisibleBy = head % k == 0;
            }

            if (!divisibleBy) {
                newSet.add(head);
                newSet.addAll(set);
                sets.add(newSet);
            }

        }

        return sets;
    }
}
