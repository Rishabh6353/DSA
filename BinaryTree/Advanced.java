import java.util.*;

public class Advanced {

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

        public void levelOrder(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node curr = q.remove();
                if (curr == null) {
                    System.out.println();

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

        public int height(Node root) {
            if (root == null) {
                return 0;
            }

            int left = height(root.left);
            int right = height(root.right);

            return Math.max(left, right) + 1;
        }

        // Q-1: Find diameter of a Binary Tree
        // o(n2) - becuase of recursive heigh fn call
        public int diameter(Node root) {
            if (root == null) {
                return 0;
            }

            int leftDia = diameter(root.left);
            int leftHt = height(root.left);
            int rightDia = diameter(root.right);
            int rightHt = height(root.right);

            int selfDia = leftHt + rightHt + 1;
            return Math.max(selfDia, Math.max(leftDia, rightDia));
        }

        // O(n)

        static class Info {
            int diam;
            int ht;

            public Info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }

        public Info diameter2(Node root) {
            if (root == null) {
                return new Info(0, 0);
            }
            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);

            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            return new Info(diam, ht);
        }

        // Q2 : Given roots of 2 BT , return true if there is a subtree of root with
        // same structure and node values of subroot and false otherwise

        public boolean isIdentical(Node root, Node subroot) {
            if (root == null && subroot == null) {
                return true;
            } else if (root == null || subroot == null || root.data != subroot.data) {
                return false;
            }

            if (!isIdentical(root.left, subroot.left)) {
                return false;
            }

            if (!isIdentical(root.right, subroot.right)) {
                return false;
            }

            return true;
        }

        public boolean isSubtree(Node root, Node subroot) {
            if (root == null) {
                return false;
            }

            if (root.data == subroot.data) {
                if (isIdentical(root, subroot)) {
                    return true;
                }
            }

            return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
        }

        // Q- Print Top view of the Binary Tree
        static class Info2 {
            Node node;
            int hd;

            Info2(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        public void topView(Node root) {
            // level order traversal
            Queue<Info2> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();

            int min = 0, max = 0;
            q.add(new Info2(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                Info2 curr = q.remove();

                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {

                    if (!map.containsKey(curr.hd)) {
                        map.put(curr.hd, curr.node);
                    }

                    if (curr.node.left != null) {
                        q.add(new Info2(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    }

                    if (curr.node.right != null) {
                        q.add(new Info2(curr.node.right, curr.hd + 1));
                        max = Math.max(max, curr.hd + 1);
                    }
                }
            }

            for (int i = min; i <= max; i++) {

                System.out.print(map.get(i).data + " ");
            }
        }

        // Q: Print nodes of kth level - iterative
        public void kthLevel(Node root, int level) {
            int lev = 1;
            Queue<Node> c = new LinkedList<>();
            c.add(root);
            c.add(null);
            while (!c.isEmpty()) {
                Node curr = c.remove();

                if (curr == null) {
                    if (c.isEmpty()) {
                        break;
                    } else {
                        c.add(null);
                        lev++;
                    }
                } else {
                    if (lev == level) {
                        System.out.print(curr.data + " ");
                    }
                    if (curr.left != null) {
                        c.add(curr.left);
                    }
                    if (curr.right != null) {
                        c.add(curr.right);
                    }
                }
            }
        }

        // Q: Print nodes of kth level - recursive
        public void kthLevelRecursive(Node root, int level, int k) {
            if (root == null) {
                return;
            }
            if (level == k) {
                System.out.print(root.data + " ");
                return;
            }

            kthLevelRecursive(root.left, level + 1, k);
            kthLevelRecursive(root.right, level + 1, k);
        }

        // Q: find lowest common ancestor - TC O(N) and SC O(N)

        public boolean getPath(Node root, int n, ArrayList<Node> path) {
            if (root == null) {
                return false;
            }

            path.add(root);

            if (root.data == n) {
                return true;
            }

            boolean left = getPath(root.left, n, path);
            boolean right = getPath(root.right, n, path);

            if (left || right == true) {
                return true;
            }

            path.remove(path.size() - 1);
            return false;
        }

        public Node lca(Node root, int n1, int n2) {
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);

            int i = 0;
            for (; i < path1.size() - 1 && i < path2.size() - 1; i++) {
                if (path1.get(i) != path2.get(i)) {
                    break;
                }
            }

            Node ans = path1.get(i - 1);
            return ans;
        }

        // Optimised - TC O(N) && SC O(1)

        public Node lca2(Node root, int n1, int n2) {
            if (root == null) {
                return null;
            }

            if (root.data == n1 || root.data == n2) {
                return root;
            }

            Node left = lca2(root.left, n1, n2);
            Node right = lca2(root.right, n1, n2);

            if (right == null) {
                return left;
            }

            if (left == null) {
                return right;
            }

            return root;
        }

        // Q: Find min distance between 2 noodes
        public int minDistance(Node root, int n1, int n2) {
            Node ancestor = lca2(root, n1, n2);

            int dist1 = lcaDist(ancestor, n1);
            int dist2 = lcaDist(ancestor, n2);

            return dist1 + dist2;
        }

        public int lcaDist(Node root, int n) {
            if (root == null) {
                return -1;
            }

            if (root.data == n) {
                return 0;
            }

            int leftDist = lcaDist(root.left, n);
            int rightDist = lcaDist(root.right, n);

            if (leftDist == -1 && rightDist == -1) {
                return -1;
            } else if (leftDist == -1) {
                return rightDist + 1;
            } else {
                return leftDist + 1;
            }
        }

        // Q: Find kth ancestor of a node
        public int kthAncestor(Node root, int n, int k) {
            if (root == null) {
                return -1;
            }

            if (root.data == n) {
                return 0;
            }

            int leftDist = kthAncestor(root.left, n, k);
            int rightDist = kthAncestor(root.right, n, k);

            if (leftDist == -1 && rightDist == -1) {
                return -1;
            }

            int max = Math.max(leftDist, rightDist);
            if (max + 1 == k) {
                System.out.println(root.data);
            }

            return max + 1;
        }

        // Q: Transform to sum tree
        public int sumTree(Node root) {
            if (root == null) {
                return 0;
            }
            int leftchild = sumTree(root.left);
            int rightchild = sumTree(root.right);

            int data = root.data + leftchild + rightchild;
            root.data = leftchild + rightchild;

            return data;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };

        BinaryTree t = new BinaryTree();
        Node root = t.buildTree(nodes);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        // t.preorder(root);
        // System.out.println(t.isSubtree(root,subRoot));
        // t.kthLevelRecursive(root, 1, 3);
        // System.out.println(t.lca2(root, 4, 5).data);
        // System.out.println(t.minDistance(root, 4, 6));
        // t.kthAncestor(root, 5, 2);
        t.sumTree(root);
        t.levelOrder(root);
    }
}