import java.util.*;

public class Level1 {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public Node buildTree(int nodes[]) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public void preorder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public int height(Node root) {
            if (root == null) {
                return 0;
            }

            int left = height(root.left);
            int right = height(root.right);

            return Math.max(left, right) + 1;
        }

        // Q-1: Find diameter of a Binary Tree
        //o(n2) - becuase of recursive heigh fn call
        public int diameter(Node root){
            if(root == null){
                return 0;
            }

            int leftDia = diameter(root.left);
            int leftHt = height(root.left);
            int rightDia =diameter(root.right);
            int rightHt = height(root.right);

            int selfDia = leftHt + rightHt +1;
            return Math.max(selfDia, Math.max(leftDia, rightDia));
        }

        //O(n)

        static class Info{
            int diam;
            int ht;

            public Info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }
        public Info diameter2(Node root){
            if(root == null){
                return new Info(0,0);
            }
            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);

            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht+ rightInfo.ht +1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;

            return new Info(diam, ht);
        }


        //Q2 : Given roots of 2 BT , return true if there is a subtree of root with same structure and node values of subroot and false otherwise


        public boolean isIdentical(Node root, Node subroot){
            if(root == null && subroot == null){
                return true;
            }else if(root == null || subroot == null || root.data != subroot.data){
                return false;
            }

            if(!isIdentical(root.left, subroot.left)){
                return false;
            }

            if(!isIdentical(root.right, subroot.right)){
                return false;
            }

            return true;
        }


        public boolean isSubtree(Node root, Node subroot){
            if(root == null){
                return false;
            }

            if(root.data == subroot. data){
                if(isIdentical(root, subroot)){
                    return true;
                }
            }

            return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
        }


    //Q- Print Top view of the Binary Tree
    static class Info2{
        Node node;
        int hd;

        Info2( Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public void topView(Node root){
        //level order traversal
        Queue<Info2> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();


        int min = 0, max =0;
        q.add(new Info2(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info2 curr = q.remove();

            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{

            if(!map.containsKey(curr.hd)){
                map.put(curr.hd, curr.node);
            }

            if(curr.node.left != null){
                q.add(new Info2(curr.node.left, curr.hd-1));
                min = Math.min(min, curr.hd-1);
            }

            if(curr.node.right != null){
                q.add(new Info2(curr.node.right, curr.hd+1));
                max = Math.max(max, curr.hd+1);
            }
        }
    }

        for(int i = min; i<= max; i++){
            
            System.out.print(map.get(i).data+" ");
        }
    }
}

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1 ,7, -1 ,-1};

        BinaryTree t = new BinaryTree();
        Node root = t.buildTree(nodes);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        // t.preorder(root);
        // System.out.println(t.isSubtree(root,subRoot));
        t.topView(root);
    }
}