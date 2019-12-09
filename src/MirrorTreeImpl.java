/*
import java.util.HashMap;
import java.util.LinkedList;

public class MirrorTreeImpl {
    static Node mirrorTreeInItself(Node root)
    {
       if(root ==null)
           return null;
        System.out.println("ROOT = " +root.getData());
      // Node left = mirrorTree(root.getLeft());
       Node right = mirrorTree(root.getRight());
       System.out.printf("Before Mirroring root = %s left = %s right = %s\n",
               root==null?null:root.getData(),left==null?null:left.getData(),right==null?null:right.getData());
       root.setLeft(right);
       root.setRight(left);
       System.out.printf("After Mirroring root = %s left = %s right = %s\n",root==null?null:root.getData(),
               root.getLeft()==null?null:root.getLeft().getData(),root.getRight()==null?null:root.getRight().getData());
       return root;
    }
   */
/* static Node createMirrorCopy(Node root)
    {
        if(root == null){
            System.out.println("Tree Empty");
            return null;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.addFirst(root);
        while(!list.isEmpty())
        {
            Node temp = list.removeFirst();
            Node left =
        }

    }*//*

    static public void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.insertNodesInLOTOrder(1,2,3,4,5,6);
        new BinaryTree(mirrorTreeInItself(tree.root)).LOTwithDesc();
        System.out.println("\"");
    }
}
*/
