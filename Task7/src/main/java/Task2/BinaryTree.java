package Task2;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char item) {
            data = item;
            left = right = null;
        }
    }

    private Node root; // tree base node

    public BinaryTree() {
        root = null;
    }

    // Method to insert a character into the binary tree
    public void insert(char data) { // Different naming add / insert to add element
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, char data) {
        if (root == null) { //if we don't have elements in tree
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    // Method for recursive depth-first traversal (preorder)
    public void recursiveDepthFirstTraversal() {
        recursiveDepthFirstTraversal(root);
    }

    private void recursiveDepthFirstTraversal(Node root) { // рекурсивный обход в глубину
        if (root != null) {
            System.out.print(root.data + " ");
            recursiveDepthFirstTraversal(root.left);
            recursiveDepthFirstTraversal(root.right);
        }
    }

    // Method for iterative breadth-first traversal
    public void iterativeBreadthFirstTraversal() { // ИТЕРАТИВНЫЙ ОБХОД В ШИРИНУ
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    private boolean containsNodeRecursive(Node current, char value) {
        if (current == null) {
            return false;
        }
        if (value == current.data) {
            return true;
        }
        return value < current.data ? containsNodeRecursive(current.left, value) : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(char value) {
        return containsNodeRecursive(root, value);
    }

    private Node deleteRecursive(Node current, char value) {
        if (current == null) {
            return null;
        }

        if (value == current.data) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }
            char smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.data) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private char findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    public void delete(char value) {
        root = deleteRecursive(root, value);
    }


}
