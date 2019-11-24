public class BinaryTreeImpl {
    public static void checkInsertLOT()
    {
        BinaryTree tree = new BinaryTree();
        tree.insertAsLOT(1);
        tree.insertAsLOT(2);

        tree.insertAsLOT(3);
        tree.insertAsLOT(4);
        tree.insertAsLOT(5);

        tree.insertAsLOT(6);
        tree.insertAsLOT(7);
        tree.LOT();
        tree.deleteNode_LOT(3);
        tree.LOT();
    }
    public static void main(String args[])
    {
        checkInsertLOT();

    }
}
