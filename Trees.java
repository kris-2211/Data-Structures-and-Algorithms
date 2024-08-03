import java.util.Stack;

class Node {
    int data;
    Node left, right;

    public Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class Trees {
    public static void main(String[] args) {
        int a[] = { 10, 4, 2, 77, 43, 86, 12, 100 };
        Node root = null;
        for (int i : a) {
            root = insert(root, i);
        }
        inorder(root);
        System.out.println();
        System.out.println(search(root, 100));
        System.out.println(search(root, 1));
        System.out.println(search(root, 12));
        delete(root, 77);
        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
    }

    // inorder NON - recursion
    static void inorder(Node root) {
        Stack<Node> s = new Stack<>();
        while (root != null || s.size() > 0) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    // preorder NON - recursion
    static void preorder(Node root) {
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node temp = s.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null)
                s.push(temp.right);
            if (temp.left != null)
                s.push(temp.left);

        }
    }

    // postorder NON - recursion
    static void postorder(Node root) {
        Stack<Node> s = new Stack<>();
        boolean check = true;
        while (true) {
            while (root != null && check) {
                s.push(root);
                root = root.left;
            }
            if (s.isEmpty())
                break;
            if (root != s.peek().right) {
                root = s.peek().right;
                check = true;
                continue;
            }
            root = s.pop();
            System.out.print(root.data + " ");
            check = false;
        }
    }

    // insertion
    static Node insert(Node root, int val) {
        if (root == null)
            return new Node(val);
        if (root.data < val) {
            root.right = insert(root.right, val);
        } else
            root.left = insert(root.left, val);
        return root;
    }

    // search
    static boolean search(Node root, int val) {
        if (root == null)
            return false;
        if (root.data < val)
            return search(root.right, val);
        else if (root.data > val)
            return search(root.left, val);
        return true;
    }

    // deletion
    static Node delete(Node root, int val) {
        if (root == null)
            return root;
        if (root.data < val) {
            root.right = delete(root.right, val);
            return root;
        } else if (root.data > val) {
            root.left = delete(root.left, val);
            return root;
        }

        // When the node is found.
        if (root.left == null)
            return root.right;
        if (root.right == null)
            return root.left;
        Node temp = inorderSuccessor(root.right);
        root.data = temp.data;
        root.right = delete(root.right, temp.data);
        return root;
    }

    static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
