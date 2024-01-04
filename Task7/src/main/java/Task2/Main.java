package Task2;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert characters into the binary tree
        tree.insert('F');
        tree.insert('D');
        tree.insert('J');
        tree.insert('B');
        tree.insert('E');
        tree.insert('G');
        tree.insert('K');
        tree.insert('A');
        tree.insert('C');
        tree.insert('I');

        tree.delete('C');
        tree.containsNode('C');

        // In order
        System.out.println("Travers in order: "); // left branch + core + right branch
        tree.traverseInOrder();
        System.out.println();
        // Recursive depth-first traversal (preorder)
        System.out.println("Recursive Depth-First Traversal:"); // core + left branch + right branch
        tree.recursiveDepthFirstTraversal();
        System.out.println();

        // Iterative breadth-first traversal
        System.out.println("Iterative Breadth-First Traversal:"); // left branch + right branch + core
        tree.iterativeBreadthFirstTraversal();



    }
}
