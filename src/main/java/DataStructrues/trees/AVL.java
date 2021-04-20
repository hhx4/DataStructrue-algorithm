package DataStructrues.trees;

/**
 * @description 平衡二叉树
 **/
public class AVL {
    private static class Node {
        public int val;
        Node left;
        Node right;
        int height;

        public Node(int val, Node left, Node right, int height) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

    private Node root;
    private int size;

    public AVL() {
        root = null;
        size = 0;
    }

    //获取某一结点的高度
    private int getHeight(Node node){
        if(node==null){
            return 0;
        }
        return node.height;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 获取节点的平衡因子
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node){
        if(node==null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }

    //判断树是否为平衡二叉树
    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if(node==null){
            return true;
        }
        int balanceFactory = Math.abs(getBalanceFactor(node));
        if(balanceFactory>1){
            return false;
        }
        return isBalanced(node.left)&&isBalanced(node.right);
    }

}
