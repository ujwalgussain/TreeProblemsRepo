public class Node {
    int data;
    Node left,right;


    public Node(int data){
        setData(data);
        left=null;
        right=null;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean hasLeft()
    {
        return (left!=null)? true: false;
    }
    public boolean hasRight()
    {
        return (right!=null)? true: false;
    }
    public boolean isLeafNode()
    {
        return getLeft()==null&& getRight()==null?true:false;
    }
    public boolean hasChildNodes(){
        return getLeft()==null || getRight()==null;
    }
}
