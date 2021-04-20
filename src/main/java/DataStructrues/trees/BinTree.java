package DataStructrues.trees;

/**
* 二叉树的简单实现与遍历
 **/
public class BinTree {
    private HeroNode root;

    public BinTree(HeroNode root) {
        this.root = root;
    }

    private void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("null tree !");
        }
    }
    private void inOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("null tree !");
        }
    }
    private void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("null tree !");
        }
    }
}

class HeroNode{
    HeroNode left;
    HeroNode right;
    Object val;

    public HeroNode(Object val) {
        this.val = val;
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this.val);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.val);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this.val);

    }
}
