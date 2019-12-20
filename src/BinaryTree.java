import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    Node root;
    public BinaryTree()
    {
        root=null;
    }
    public BinaryTree(Node root)
    {
        this.root = root;
    }
    public void insertAsLOT(int data)
    {
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            System.out.println("Tree Empty. Inserted as ROOT" + data);
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty())
        {
            Node temp = queue.removeFirst();
            if(temp.hasLeft())
            {
                queue.addLast(temp.getLeft());
            }
            else
            {
                temp.setLeft(newNode);
                System.out.println(String.format("Inserted %s as left of %s",data,temp.getData()));
                break;
            }
            if(temp.hasRight())
            {
                queue.addLast(temp.getRight());
            }
            else{
                temp.setRight(newNode);
                System.out.println(String.format("Inserted %s as right of %s",data,temp.getData()));
                break;
            }
        }
    }
    public void insertNodesInLOTOrder(int... data)
    {
        for(int i: data)
        {
            insertAsLOT(i);
            //System.out.print("After insertion "+ i + " Tree ");
            LOT();
        }
    }
    public void LOT()
    {
        if(root == null){
            System.out.println("Tree Empty");
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        StringBuilder s = new StringBuilder();
        while(!queue.isEmpty())
        {
            Node temp = queue.removeFirst();
            s.append(temp.getData()).append(" ");
            if(temp.hasLeft())
            {
                queue.addLast(temp.getLeft());
            }
            if(temp.hasRight())
            {
                queue.addLast(temp.getRight());
            }
        }
        System.out.println("Tree-> " + s);
    }
    public void LOTwithDesc()
    {
        if(root == null){
            System.out.println("Tree Empty");
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        StringBuilder s = new StringBuilder();
        StringBuilder desc =new StringBuilder();
        desc.append("ROOT is ").append(root.getData());
        while(!queue.isEmpty())
        {
            Node temp = queue.removeFirst();
            s.append(temp.getData()).append(" ");
            if(temp.hasLeft())
            {
                desc.append(String.format("\n%s is LEFT OF %s",temp.left.getData(),temp.getData()));
                queue.addLast(temp.getLeft());
            }
            if(temp.hasRight())
            {
                desc.append(String.format("\n%s is RIGHT OF %s",temp.right.getData(),temp.getData()));
                queue.addLast(temp.getRight());
            }
        }
        System.out.println("Tree-> " + s);
        System.out.println("DESC -> "+ desc);
    }
    public boolean hasLeafNodes(Node n) {
        if(n.hasLeft() && n.hasRight())
        {
            if(n.getLeft().isLeafNode() && n.getRight().isLeafNode())
            {

            }
        }
        if(n.hasLeft())
        {

        }
           /* return (n.getLeft().isLeafNode() && n.getRight().isLeafNode())?true:false;*/
        return false;
    }

    public void deleteNode_LOT(int key)
    {
        if(root == null)
        {
            System.out.println("Tree is Empty");
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        Node temp=null, node_to_delete = null;
        while(!queue.isEmpty())
        {
            temp= queue.poll();
            if(temp.getData() == key)
                node_to_delete = temp;
            if(temp.hasLeft())
                queue.addLast(temp.getLeft());
            if(temp.hasRight())
                queue.addLast(temp.getRight());
        }
        System.out.println("Temp" + temp.getData());
        if(node_to_delete == null)
            System.out.println("Delete failed. node not Found");
        else
        {
            queue.addFirst(root);
            Node temp1 = null;
            while(!queue.isEmpty())
            {
                temp1 = queue.poll();
                System.out.println("Temp1 " + temp1.getData());
                if(temp1.getLeft().getData() == temp.getData())
                {
                    System.out.println("Temp1 " + temp1.getData());
                    temp1.setLeft(null);
                    System.out.println("Removed Left Leaf ");
                    break;
                }
                if(temp1.getRight().getData() == temp.getData())
                {
                    System.out.println("Temp1 " + temp1.getData());
                    temp1.setRight(null);
                    System.out.println("Removed Right Leaf ");
                    break;
                }
                if(temp1.hasLeft())
                    queue.addLast(temp1.getLeft());
                if(temp1.hasRight())
                    queue.addLast(temp1.getRight());
            }
            node_to_delete.setData(temp.getData());
            System.out.println("Replaced the Node successfully");
            System.out.println("Deleted Successfully");
        }
    }

    //==============Approach 1============================//
    Node createTreeUsingLOT_helper(int [] arr, int i)
    {
        if(i>=arr.length)
        {
            return null;
        }
        if(arr[i] == -1)
        {
            return null;
        }
        Node current = new Node(arr[i]);
        int left = 2*i;
        current.setLeft(createTreeUsingLOT_helper(arr,left));
        int right = left+1;
        current.setRight(createTreeUsingLOT_helper(arr,right));
        return current;
    }
    void createTreeUsingLOT(boolean approach1,int... arr)
    {
        if(approach1)
            root = createTreeUsingLOT_helper(arr,1);
        else
        {
            Node root = new Node(arr[1]);
            createTree(arr,root,1);
        }
    }
    //========================Approach2=======================//
    //==================Incomplete===================
    private void createTree(int arr[], Node root, int i)
    {
        int left = 2*i, right = left+1;
        if(i>=arr.length || left>=arr.length || right >= arr.length)
        {
            return;
        }
        if(this.root == null)
        {
            this.root = root;
        }
        if(arr[left]!=-1)
        {
            Node leftNode = new Node(arr[left]);
            root.setLeft(leftNode);
            createTree(arr,leftNode,left);
        }
       if(arr[right] !=-1) {
           Node rightNode = new Node(arr[left]);
           root.setRight(rightNode);
           createTree(arr, rightNode, right);
       }
    }
}
