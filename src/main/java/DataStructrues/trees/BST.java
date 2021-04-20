package DataStructrues.trees;

/**
 * @description 二叉排序树
 **/
public class BST {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] nums ={2,1,7,4,6,3,5};
        for (int num : nums) {
            bst.add(num);
        }
        bst.remove(5);
        bst.infixOrder(bst.root);
    }

    private void add(int num) {
        this.root = insert(this.root,num);
    }

    private TreeNode root;

    public BST() {
        root = null;
    }

    /**
    * 增加节点
    * @params 节点值
    */
    private TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
        }else if(val < node.val){
            node.left = insert(node.left,val);
        }else if(val > node.val){
            node.right = insert(node.right, val);
        }
        return node;
    }

    /**
    * 删除节点
    * @params 节点值
    */
    public void remove(int val) {
        this.root = delete(this.root,val);
    }
    public TreeNode delete(TreeNode node,int data) {
        if (node == null) {
            System.out.println("未在二叉树中的数据.");
        } else if (node.val > data) {
            node.left = delete(node.left, data);
        } else if (node.val < data) {
            node.right = delete(node.right, data);
        } else {
            //如果删除的是叶子节点
            if (node.right == null && node.left == null) {
                node = null;
            } else if (node.left == null) { //删除的节点只有右子节点
                TreeNode temp = node.right;
                node.right = null;
                node = temp;
            } else if (node.right == null) {//删除的节点只有左子节点
                TreeNode temp = node.left;
                node.left = null;
                node = temp;
            } else {
                //删除的节点既有左子节点又有右子节点
                //1、先寻找右子树中节点值最小的节点，如果没有左子树那就是第一个右子节点。
                // 2、把这个值赋给要删除的节点
                // 3、删除刚刚第一步在右子树找到的节点
                TreeNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                node.val = temp.val;
                node.right = delete(node.right, temp.val);
            }
        }
        return node;
    }

    /**
    * 中序遍历
    */
    public void infixOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            infixOrder(node.left);
        }
        System.out.print(node.val + " ");
        if (node.right != null) {
            infixOrder(node.right);
        }
    }

    /**
     * 用于查找树中是否存在该节点
     *
     * @params 查找值
     */
    public boolean find(int data) {
        if (search(this.root, data)) {
            System.out.println(data + " is present in given BST.");
            return true;
        }
        System.out.println(data + " not find.");
        return false;
    }
    private boolean search(TreeNode node,int data) {
        if (node == null) {
            return false;
        } else if (node.val == data) {
            return true;
        } else if (node.val > data) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public void infixOrder() {
        if (this.left != null) {
            this.infixOrder();
        }
        System.out.println(this.val);
        if (this.right != null) {
            this.infixOrder();
        }
    }
}