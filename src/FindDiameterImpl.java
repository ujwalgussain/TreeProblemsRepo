import java.util.LinkedList;

public class FindDiameterImpl {
    //Diameter is a longest path between 2 leaf nodes
    //static int diameter;
    public static int findDiameter(Node root, int diameter)
    {
        if(root == null)
            return 0;
        int left = findDiameter(root.getLeft(),diameter);
        int right = findDiameter(root.getRight(),diameter);
        if(left+right > diameter)
            diameter = left+right;
        return Math.max(left,right)+1;
    }
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
       tree.createTreeUsingLOT(true,0,1,2,3,4,-1,-1,-1);
        tree.LOTwithDesc();
        System.out.println(findDiameter(tree.root,0));

    }
}
