
public class checkPathThatFormsSumImpl {
    static boolean check(Node root,int sum, String s)
    {
        if(root == null)
        {
            if(sum==0)
            {
                System.out.println("ANS "+ s);
                return true;
            }
            return false;
        }
        int new_sum = sum-root.getData();

        s = s+" "+root.getData();
        return check(root.getLeft(),new_sum,s)||check(root.getRight(),new_sum,s);
    }
    static boolean check1(Node root,int sum, String s)
    {
        if(root == null)
        {
           /* if(sum==0)
            {
                System.out.println("ANS "+ s);
                return true;
            }*/
            return false;
        }
        int new_sum = sum-root.getData();
        s = s+" "+root.getData();
        if(new_sum==0)
        {
            System.out.println("ANS "+ s);
            return true;
        }
        return check(root.getLeft(),new_sum,s)||check(root.getRight(),new_sum,s);
    }
    static public void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.insertNodesInLOTOrder(1,2,3,4,5,6);
        check(tree.root,7,"");
    }
}
