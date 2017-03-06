package hackerrank.huffmandecoding;

public class Solution {

    /*
             {ϕ,5}
          0 /     \ 1
         {ϕ,2}   {A,3}
        0/   \1
    {B,1}  {C,1}

    s = 1001011
     */

    class Node {
        int frequency;
        char data;
        Node left, right;
    }

    String search(Node n, String s, String builder, Node root) {
        boolean isLeaf = n.left == null && n.right == null;

        if(s.length() == 0) {
            return isLeaf ? builder + n.data : builder;
        }
        else if(isLeaf) {
            return search(root, s, builder + n.data, root);
        }
        else {
           if('0' == s.charAt(0)) {
               return search(n.left, s.substring(1), builder, root);
           }
           else {
               return search(n.right, s.substring(1), builder, root);
           }
        }
    }

    void decode(String s, Node root) {
        System.out.println(search(root, s, "", root));
    }
}
