import java.util.LinkedList;

public class FindMaxLevelSumImpl {
    //Find the level which has maximum sum
    public static int findMaxLevelSum(Node root)
    {
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        list.addLast(null);
        int currentLevelSum=0;
        int max = currentLevelSum;
       // int i = -1;
        while(!list.isEmpty())
        {
            Node temp = list.removeFirst();
            System.out.println("call "+((temp!=null)?temp.getData():null));
            if(temp==null)
            {
                System.out.println("Current Level Sum" + currentLevelSum);
                max = Math.max(max,currentLevelSum);
                currentLevelSum = 0;
                if(!list.isEmpty())
                    list.addLast(null);
            }
            else {
                currentLevelSum += temp.getData();
                if (temp.hasLeft()) {
                    System.out.println("Add" + temp.left.data);
                    list.addLast(temp.getLeft());
                }
                if (temp.hasRight()) {
                    System.out.println("Add" + temp.right.data);
                    list.addLast(temp.getRight());
                }
            }
        }
        return max;
    }
    public static void main(String... args)
    {
        BinaryTree tree = new BinaryTree();
        tree.createTreeUsingLOT(true,0,1,2,3,4,-1,-1,-1);
        tree.LOTwithDesc();
        System.out.println(findMaxLevelSum(tree.root));
    }
}
