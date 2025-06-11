import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class BST {
    public static void main(String[] args) throws IOException {
        int key;
        boolean flag = true;
        Node node = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (flag) {
            System.out.println("""
                    Enter 1 to insert to BST
                    Enter 2 to search in BST
                    Enter 3 to delete from BST
                    Enter 4 to print the BST
                    Enter anyother choice to exit
                    Enter choice:
                    """);
            char choice = in.readLine().charAt(0);
            switch (choice) {
                case '1':
                    System.out.println("Enter key to insert to BST");
                    key = Integer.parseInt(in.readLine());
                    node = insert(node, key);
                    break;
                case '2':
                    System.out.println("Enter key to search in BST");
                    key = Integer.parseInt(in.readLine());
                    search(node, key);
                    break;
                case '3':
                    System.out.println("Enter key to delete from BST");
                    key = Integer.parseInt(in.readLine());
                    node = delete(node, key);
                    break;
                case '4':
                    System.out.println("InOrder Traversal");
                    printInOrder(node);
                    System.out.println();
                    System.out.println("PreOrder Traversal");
                    printPreOrder(node);
                    System.out.println();
                    break;
                default:
                    flag = false;
            }
        }
    }

    static Node insert(Node node, int key) {
        if (null == node) {
            return new Node(key);
        } else if (node.val > key) {
            node.left = insert(node.left, key);
        } else if (node.val < key) {
            node.right = insert(node.right, key);
        } else {
            System.out.println("Value already present");
        }
        return node;
    }

    static void search(Node node, int key) {
        if (null == node) {
            System.out.println("Key not found");
        } else if (node.val == key) {
            System.out.println("Key found");
        } else if (node.val > key) {
            search(node.left, key);
        } else {
            search(node.right, key);
        }
    }

    static Node delete(Node node, int key) {
        if (null == node) {
            System.out.println("key not found");
            return null;
        } else if (node.val < key) {
            node.right = delete(node.right, key);
        } else if (node.val > key) {
            node.left = delete(node.left, key);
        } else {
            if (null == node.left && null == node.right) {
                node = null;
            } else if (null == node.left || null == node.right) {
                node = Optional.ofNullable(node.left).orElse(node.right);
            } else {
                Node successor = inOrderSuccessor(node.right);
                delete(node, successor.val);
                node.val = successor.val;
            }
        }
        return node;
    }

    static Node inOrderSuccessor(Node node) {
        if (node.left == null) {
            return node;
        }
        return inOrderSuccessor(node.left);
    }

    static void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }

    static void printPreOrder(Node root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printInOrder(root.left);
            printInOrder(root.right);
        }
    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}
