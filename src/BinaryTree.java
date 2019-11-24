import java.util.LinkedList;

public class BinaryTree {
    Node root;
    public BinaryTree()
    {
        root=null;
    }
    public void insertAsLOT(int data)
    {
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            System.out.println("Tree Empty. Inserted " + data);
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
}
