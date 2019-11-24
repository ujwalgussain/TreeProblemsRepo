import java.util.LinkedList;

public class RedBlackTreeImpl {
    class Node{
        int data;
        Node left,right,parent;
        char color;
        Node(int data)
        {
            this.data=data;
            left=null;
            right=null;
            parent=null;
            color = 'R';
        }

    }
    class RedBlackTree{
        Node root = null; int count = 0;
        RedBlackTree()
        {

        }
        void insertNode(int data)
        {
            insert(new Node(data));
        }
        void insert(Node z)
        {
            if(root == null)
            {
                root =z;
            }
            else
                {
                Node temp1 = root,temp2=null;
                while(temp1!=null)
                {
                    temp2= temp1;
                    if(z.data<temp1.data)
                        temp1= temp1.left;
                    else
                        temp1=temp1.right;
                }
                if(temp2.data<z.data)
                    temp2.right=z;
                else
                    temp2.left = z;
                z.parent = temp2;

            }
            count++;
            fixup(z);
            System.out.println("Fixup Done");
        }

        void fixup(Node z)
        {
            //No need of checking parent and Grand parent bcoz z.parent.color=='R' only when level is 3
            /*1st node will be black...2nd node will be red hence condition will be false....*/
            if(z.parent!=null)
            {
                System.out.println("Z = "+ root.data);
                while(z.parent.color=='R' && z.color!='B' && root !=z)
                {
                    System.out.println("Fixing z = " + z.data);
                    if(z.parent == z.parent.parent.left)
                    {
                        System.out.println(String.format("Parent %d is a left child of GrandParent %d", z.parent,z.parent.parent));
                        Node y = z.parent.parent.right;
                        if(y!=null && y.color == 'R')
                        {
                            System.out.println("Uncle is red");
                            z.parent.color = 'B';
                            y.color = 'B';
                            z.parent.parent.color = 'R';
                            z=z.parent.parent;
                        }
                        else
                        {
                            if(z == z.parent.right)
                            {
                                System.out.println(String.format("%d i"));
                                z = z.parent;
                                left_rotate(z);
                            }
                            z.parent.color = 'B';
                            z.parent.parent.color = 'R';
                            right_rotate(z.parent.parent);
                        }
                    }
                    else
                    {
                        Node y = z.parent.parent.left;
                        if(y!=null && y.color == 'R')
                        {
                            z.parent.color = 'B';
                            y.color = 'B';
                            z.parent.parent.color = 'R';
                            z=z.parent.parent;
                        }
                        else
                        {
                            if(z == z.parent.left)
                            {
                                z = z.parent;
                                right_rotate(z);
                            }
                            z.parent.color = 'B';
                            z.parent.parent.color = 'R';
                            left_rotate(z.parent.parent);
                        }
                    }
                }
            }
            root.color='B';
        }
        void left_rotate(Node x)
        {
            Node y = x.right;
            x.right = y.left;
            if(y.left!=null)
                y.left.parent = x;
            y.parent = x.parent;
            if(x.parent==null)
                root = y;
            else  if(x.parent.left==x)
                x.parent.left =y;
            else x.parent.right = y;
            y.left = x;
            x.parent = y;
        }
        void right_rotate(Node x)
        {
            Node y = x.left;
            x.left = y.right;
            if(x.left != null)
                y.left.parent = x;
            y.parent = x.parent;
            if (x.parent == null)
                root = x;
            else {
                if(x.parent.left == x )
                    x.parent.left = y;
                else
                    x.parent.right = y;
            }
            y.right = x;
            x.parent = y;
        }
        void display_LOT()
        {
            if(root == null)
                System.out.println("Tree Empty");
            LinkedList<Node> l = new LinkedList<>();
            l.add(root);
            System.out.println("Tree Data with Nodes "+ count);
            while(!l.isEmpty())
            {
                Node temp = l.removeFirst();
                if(temp==null){
                    System.out.print("null ");
                    continue;
                }
                System.out.print(temp.data+"|"+temp.color+" ");
                l.addLast(temp.left);
                l.addLast(temp.right);
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        RedBlackTree tree = new RedBlackTreeImpl().new RedBlackTree();
        tree.insertNode(1);
        System.out.println("After insertion of 1");
        tree.display_LOT();
        tree.insertNode(2);
        System.out.println("After insertion of 2");
        tree.display_LOT();
        tree.insertNode(3);
        System.out.println("After insertion of 3");
        tree.display_LOT();
        tree.insertNode(4);
        System.out.println("After insertion of 4");
        tree.display_LOT();
    }
}
