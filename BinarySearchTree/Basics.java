import java.util.*;

public class Basics {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class BST {
        public Node insert(Node root, int val) {
            if (root == null) {
                root = new Node(val);
                return root;
            }

            if (root.data > val) {
                root.left = insert(root.left, val);
            } else {
                root.right = insert(root.right, val);
            }
            return root;
        }

        public void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // Q: search in BST
        public boolean search(Node root, int key) {
            if (root == null) {
                return false;
            }

            if (root.data == key) {
                return true;
            }

            if (root.data > key) {
                return search(root.left, key);
            } else {
                return search(root.right, key);
            }
            // return false;
        }

        // Q: delete a Node in BST
        public Node delete(Node root, int key) {
            if (root.data > key) {
                root.left = delete(root.left, key);
            } else if (root.data < key) {
                root.right = delete(root.right, key);
            } else {
                // case 1 - leaf node
                if (root.left == null && root.right == null) {
                    return null;
                }

                // case2 - one child
                if (root.left == null) {
                    return root.right;
                }

                if (root.right == null) {
                    return root.left;
                }

                // case 3 - two child
                Node IS = inOrderSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, key);
            }
            return root;

        }

        public Node inOrderSuccessor(Node root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }

        // Q: Print in range
        public void printRange(Node root, int n1, int n2) {
            if (root == null) {
                return;
            }

            if (root.data >= n1 && root.data <= n2) {
                printRange(root.left, n1, n2);
                System.out.print(root.data + " ");
                printRange(root.right, n1, n2);
            } else if (root.data < n1) {
                printRange(root.right, n1, n2);
            } else {
                printRange(root.left, n1, n2);
            }
        }

        // Q: Print root to leaf
        public void printLeafToRoot(Node root, ArrayList<Integer> path) {
            if (root == null) {
                return;
            }

            path.add(root.data);
            if (root.left == null && root.right == null) {
                printPath(path);
            }
            printLeafToRoot(root.left, path);
            printLeafToRoot(root.right, path);
            path.remove(path.size() - 1);
        }

        public void printPath(ArrayList<Integer> path) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i) + " ");
            }
            System.out.println("null");
        }

        // Q: Check if BST is valid
        public boolean isValid(Node root, Node min, Node max) {
            if (root == null) {
                return true;
            }

            if (min != null && root.data <= min.data) {
                return false;
            } else if (max != null && root.data >= max.data) {
                return false;
            }

            return isValid(root.left, min, root) && isValid(root.right, root, max);
        }

        public void levelOrder(Node root) {
            if (root == null) {
                return;
            }

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

        public Node mirror(Node root) {
            if (root == null) {
                return null;
            }

            Node leftS = mirror(root.left);
            Node rightS = mirror(root.right);

            root.left = rightS;
            root.right = leftS;

            return root;
        }
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        BST t = new BST();
        for (int i = 0; i < values.length; i++) {
            root = t.insert(root, values[i]);
        }
        // System.out.println(t.search(root, 6));
        // t.inorder(root);
        // System.out.println();
        // t.delete(root, 10);
        // t.inorder(root);
        // t.printRange(root, 1, 8);
        // System.out.println(t.isValid(root, null, null));
        t.mirror(root);
        t.levelOrder(root);
    }
}
