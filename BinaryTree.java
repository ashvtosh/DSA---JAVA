class TreeNode1 {
    int data;
    TreeNode1 left, right;
    TreeNode1(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BinaryTree {
    static TreeNode1 root;
    BinaryTree(){
        root = null;
    }
    public static void postOrder(TreeNode1 Node) {
        if(Node == null)
            return;
        postOrder(Node.left);
        postOrder(Node.right);
        System.out.print(Node.data + " ");
    }
    public static void inOrder(TreeNode1 Node) {
        if(Node == null)
            return;
        inOrder(Node.left);
        System.out.print(Node.data + " ");
        inOrder(Node.right);
    }
    public static void preOrder(TreeNode1 Node) {
        if(Node == null)
            return;
        System.out.print(Node.data + " ");
        preOrder(Node.left);
        preOrder(Node.right);
    }
    public static void main(String[] args) {
        root = new TreeNode1(10);
        root.left = new TreeNode1(30);
        root.right = new TreeNode1(40);
        root.left.left = new TreeNode1(50);
        root.left.right = new TreeNode1(60);
        root.right.left = new TreeNode1(55);
        root.right.right = new TreeNode1(65);
        postOrder(root);
        System.out.println("");
        inOrder(root);
        System.out.println("");
        preOrder(root);
    }
}