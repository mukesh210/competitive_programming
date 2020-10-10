import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }

    Node root;

    public BinarySearchTree(int key) {
        root = new Node(key);
    }

    public BinarySearchTree() {
        root = null;
    }

    public void insertKey(int key) {
        root = insert(root, key);
    }

    public Node insert(Node root, int key) {
        if(root == null) {
            Node newNode = new Node(key);
            return newNode;
        }

        if(key < root.key) {
            root.left = insert(root.left, key);
        } else if(key > root.key) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public void inorderTraversal(Node root) {
        if(root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()) {
                Node extractedNode = queue.poll();
                System.out.print(extractedNode.key + " ");
                if(extractedNode.left != null)
                    queue.add(extractedNode.left);
                if(extractedNode.right != null)
                    queue.add(extractedNode.right);
            }

            System.out.println();
        }

    }

    public Node search(Node root, int key) {
        if(root == null)
            return null;

        if(key < root.key) {
            return search(root.left, key);
        } else if(key > root.key) {
            return search(root.right, key);
        }

        return root;
    }

    public void deleteKey(int key) {
        root = delete(root, key);
    }

    public Node delete(Node root, int key) {
        if(key < root.key) {
            root.left = delete(root.left, key);
            return root;
        } else if(key > root.key) {
            root.right = delete(root.right, key);
            return root;
        }
        // Node with no child or only one child node
        if(root.left == null) {
            return root.right;
        } else if(root.right == null) {
            return root.left;
        }

        // Node with both the child
        Node successor = getSuccessor(root.right);
        root.key = successor.key;

        root.right = delete(root.right, successor.key);
        return root;
    }

    public Node getSuccessor(Node root) {
        Node currentSuccessorValue = root;
        Node parent = root;
        while(root.left != null) {
            root = root.left;
        }
        currentSuccessorValue = root;
        return currentSuccessorValue;
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertKey(8);
        bst.insertKey(3);
        bst.insertKey(10);
        bst.insertKey(1);
        bst.insertKey(6);
        bst.insertKey(14);
        bst.insertKey(4);
        bst.insertKey(7);
        bst.insertKey(13);

        bst.inorderTraversal(bst.root);

        Node searchedNode = bst.search(bst.root, 7);
        System.out.println("SearchedNode: " + searchedNode);

        bst.deleteKey(3);
        bst.inorderTraversal(bst.root);
    }
}
