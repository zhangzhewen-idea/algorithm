package org.zhangzhewen.data_structures.trees;

/*
* Avl is algo that balance itself while adding new alues to tree
* by rotating branches of binary tree and make itself Binary seaarch tree
* there are four cases which has to tackle
* rotating - left right ,left left,right right,right left

Test Case:

AVLTree tree=new AVLTree();
		tree.insert(20);
		tree.insert(25);
		tree.insert(30);
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(27);
		tree.insert(19);
		tree.insert(16);

		tree.display();




*/



public class AVLTree {
    private class Node{
        int data;
        int height;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.height=1;
        }

    }
    private Node root;
    public void insert(int data) {
        this.root=insert(this.root,data);
    }
    private Node insert(Node node,int item) {
        if(node==null) {
            Node add=new Node(item);
            return add;
        }
        if(node.data>item) {
            node.left=insert(node.left,item);
        }
        if(node.data<item) {
            node.right=insert(node.right,item);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        int bf=bf(node);
        //LL case
        if(bf>1&&item<node.left.data)
            return rightRotate(node);
        //RR case
        if(bf<-1&&item>node.right.data)
            return leftRotate(node);
        //RL case
        if(bf<-1&&item<node.right.data) {
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }
        //LR case
        if(bf>1&&item>node.left.data) {
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }

        return node;
    }
    public void display() {
        this.display(this.root);
        System.out.println(this.root.height);
    }
    private void display (Node node) {
        String str="";
        if(node.left!=null)
            str+=node.left.data+"=>";
        else
            str+="END=>";
        str+=node.data+"";
        if(node.right!=null)
            str+="<="+node.right.data;
        else
            str+="<=END";
        System.out.println(str);
        if(node.left!=null)
            display(node.left);
        if(node.right!=null)
            display(node.right);
    }
    private int height(Node node) {
        if(node==null) {
            return 0;
        }
        return node.height;

    }
    private int bf(Node node) {
        if(node==null)
            return 0;
        return height(node.left)-height(node.right);
    }

    private Node rightRotate(Node c) {
        Node b=c.left;
        Node T3=b.right;

        b.right=c;
        c.left=T3;
        c.height=Math.max(height(c.left),height(c.right))+1;
        b.height=Math.max(height(b.left),height(b.right))+1;
        return b;

    }
    private Node leftRotate(Node c) {
        Node b=c.right;
        Node T3=b.left;

        b.left=c;
        c.right=T3;
        c.height=Math.max(height(c.left),height(c.right))+1;
        b.height=Math.max(height(b.left),height(b.right))+1;
        return b;

    }

}

class AVLTree2 {

    private Node root;

    private class Node {
        private int key;
        private int balance;
        private int height;
        private Node left, right, parent;

        Node(int k, Node p) {
            key = k;
            parent = p;
        }
    }

    public boolean insert(int key) {
        if (root == null)
            root = new Node(key, null);
        else {
            Node n = root;
            Node parent;
            while (true) {
                if (n.key == key)
                    return false;

                parent = n;

                boolean goLeft = n.key > key;
                n = goLeft ? n.left : n.right;

                if (n == null) {
                    if (goLeft) {
                        parent.left = new Node(key, parent);
                    } else {
                        parent.right = new Node(key, parent);
                    }
                    rebalance(parent);
                    break;
                }
            }
        }
        return true;
    }

    private void delete(Node node) {
        if (node.left == null && node.right == null) {
            if (node.parent == null) root = null;
            else {
                Node parent = node.parent;
                if (parent.left == node) {
                    parent.left = null;
                } else parent.right = null;
                rebalance(parent);
            }
            return;
        }
        if (node.left != null) {
            Node child = node.left;
            while (child.right != null) child = child.right;
            node.key = child.key;
            delete(child);
        } else {
            Node child = node.right;
            while (child.left != null) child = child.left;
            node.key = child.key;
            delete(child);
        }
    }

    public void delete(int delKey) {
        if (root == null)
            return;
        Node node = root;
        Node child = root;

        while (child != null) {
            node = child;
            child = delKey >= node.key ? node.right : node.left;
            if (delKey == node.key) {
                delete(node);
                return;
            }
        }
    }

    private void rebalance(Node n) {
        setBalance(n);

        if (n.balance == -2) {
            if (height(n.left.left) >= height(n.left.right))
                n = rotateRight(n);
            else
                n = rotateLeftThenRight(n);

        } else if (n.balance == 2) {
            if (height(n.right.right) >= height(n.right.left))
                n = rotateLeft(n);
            else
                n = rotateRightThenLeft(n);
        }

        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }

    private Node rotateLeft(Node a) {

        Node b = a.right;
        b.parent = a.parent;

        a.right = b.left;

        if (a.right != null)
            a.right.parent = a;

        b.left = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    private Node rotateRight(Node a) {

        Node b = a.left;
        b.parent = a.parent;

        a.left = b.right;

        if (a.left != null)
            a.left.parent = a;

        b.right = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    private Node rotateLeftThenRight(Node n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }

    private Node rotateRightThenLeft(Node n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }

    private int height(Node n) {
        if (n == null)
            return -1;
        return n.height;
    }

    private void setBalance(Node... nodes) {
        for (Node n : nodes) {
            reheight(n);
            n.balance = height(n.right) - height(n.left);
        }
    }

    public void printBalance() {
        printBalance(root);
    }

    private void printBalance(Node n) {
        if (n != null) {
            printBalance(n.left);
            System.out.printf("%s ", n.balance);
            printBalance(n.right);
        }
    }

    private void reheight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public boolean search(int key) {
        Node result = searchHelper(this.root,key);
        if(result != null)
            return true ;

        return false ;
    }

    private Node searchHelper(Node root, int key)
    {
        //root is null or key is present at root
        if (root==null || root.key==key)
            return root;

        // key is greater than root's key
        if (root.key > key)
            return searchHelper(root.left, key); // call the function on the node's left child

        // key is less than root's key then
        //call the function on the node's right child as it is greater
        return searchHelper(root.right, key);
    }

    public static void main(String[] args) {
        AVLTree2 tree = new AVLTree2();

        System.out.println("Inserting values 1 to 10");
        for (int i = 1; i < 10; i++)
            tree.insert(i);

        System.out.print("Printing balance: ");
        tree.printBalance();
    }
}