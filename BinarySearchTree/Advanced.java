import java.util.*;

public class Advanced {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class BST {
        public Node insert(Node root, int data) {
            if (root == null) {
                Node newNode = new Node(data);
                root = newNode;
                return root;
            }

            if (data < root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
        }

        // Q: create BST from sorted array

        public Node createBST(int arr[], int st, int end) {
            if (st > end) {
                return null;
            }

            int mid = (st + end) / 2;

            Node root = new Node(arr[mid]);
            root.left = createBST(arr, st, mid - 1);
            root.right = createBST(arr, mid + 1, end);

            return root;
        }

        public void levelOrder(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node curr = q.remove();

                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(curr.data + " ");

                    if (curr.left != null) {
                        q.add(curr.left);
                    }

                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }

        // Q: Convert BST to a balanced BST

        public void getInorder(Node root, ArrayList<Integer> list) {
            if (root == null) {
                return;
            }

            getInorder(root.left, list);
            list.add(root.data);
            getInorder(root.right, list);
        }

        public Node createBST2(ArrayList<Integer> list, int st, int end) {
            if (st > end) {
                return null;
            }

            int mid = (st + end) / 2;
            Node root = new Node(list.get(mid));
            root.left = createBST2(list, st, mid - 1);
            root.right = createBST2(list, mid + 1, end);

            return root;
        }

        public Node balanced(Node root) {
            ArrayList<Integer> list = new ArrayList<>();
            getInorder(root, list);

            root = createBST2(list, 0, list.size() - 1);

            return root;
        }

        // Q: Size of Largest possible BST in a BT
        public static class Info {
            boolean isBST;
            int size;
            int min;
            int max;

            public Info(boolean isBST, int size, int min, int max) {
                this.isBST = isBST;
                this.size = size;
                this.min = min;
                this.max = max;
            }
        }

        public static int maxSize = 0;

        public Info largestBST(Node root) {
            if (root == null) {
                return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
            }

            Info left = largestBST(root.left);
            Info right = largestBST(root.right);

            int size = left.size + right.size + 1;
            int min = Math.min(root.data, Math.min(left.min, right.min));
            int max = Math.max(root.data, Math.max(left.max, right.max));

            if (root.data <= left.max || root.data >= right.min) {
                return new Info(false, size, min, max);
            }

            if (left.isBST && right.isBST) {
                maxSize = Math.max(maxSize, size);
                return new Info(true, size, min, max);
            }

            return new Info(false, size, min, max);
        }

        // Q: merge two BSt to form balanced BST
        public Node merge(ArrayList<Integer> list , int st , int end){
            if(st> end){
                return null;
            }

            int mid= (st+end)/2;
            Node root = new Node(list.get(mid));
            root.left = merge(list, st, mid-1);
            root.right = merge(list, mid+1, end);

            return root;
        }

        public Node mergeBST(Node root1, Node root2) {
            ArrayList<Integer> list1 = new ArrayList<>();
            getInorder(root1, list1);

            ArrayList<Integer> list2 = new ArrayList<>();
            getInorder(root2, list2);

            int i = 0, j = 0;
            ArrayList<Integer> finalList = new ArrayList<>();

            while (i < list1.size() && j < list2.size()) {
                if (list1.get(i) < list2.get(j)) {
                    finalList.add(list1.get(i));
                    i++;
                } else {
                    finalList.add(list2.get(j));
                    j++;
                }
            }

            while (i < list1.size()) {
                finalList.add(list1.get(i));
                i++;
            }

            while (j < list2.size()) {
                finalList.add(list2.get(j));
                j++;
            }

            Node root = merge(finalList, 0, finalList.size()-1);
            return root;
        }

    }

    public static void main(String[] args) {
        // int arr [] = {3,5,6,8,10,11,12};
        BST t = new BST();
        // Node root = t.createBST(arr, 0, arr.length-1);
        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.left.left = new Node(5);
        // root.left.left.left = new Node(3);

        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(12);

        // root = t.balanced(root);
        // t.levelOrder(root);

        // Node root = new Node(50);
        // root.left= new Node(30);
        // root.left.left= new Node(5);
        // root.left.right= new Node(20);

        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);

        // t.largestBST(root);
        // System.out.println(BST.maxSize);

        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        root = t.mergeBST(root, root2);
        t.levelOrder(root);
    }
}