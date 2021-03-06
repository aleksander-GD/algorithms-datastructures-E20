package lecture_7_8_trees;
// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 *
 * @author Mark Allen Weiss
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    /**
     * Construct the tree.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     *
     * @param x the item to insert.
     */
    public void insert(AnyType x) {
        root = insert(x, root);
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     *
     * @param x the item to remove.
     */
    public void remove(AnyType x) {
        root = remove(x, root);
    }

    /**
     * Find the smallest item in the tree.
     *
     * @return smallest item or null if empty.
     */
    public AnyType findMin() {
        if (isEmpty())
            throw new RuntimeException("Error in BinarySearchTree.findMin()");
        return findMin(root).element;
    }

    /**
     * Find the largest item in the tree.
     *
     * @return the largest item of null if empty.
     */
    public AnyType findMax() {
        if (isEmpty())
            throw new RuntimeException("Error in BinarySearchTree.findMax()");
        return findMax(root).element;
    }

    /**
     * Find an item in the tree.
     *
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    /**
     * Internal method to insert into a subtree.
     *
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return new BinaryNode<>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else
            ;  // Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     *
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return t;   // Item not found; do nothing

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) // Two children
        {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t != null)
            while (t.right != null)
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     *
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return false;

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true;    // Match
    }

    /**
     * Internal method to print a subtree in sorted order.
     *
     * @param t the node that roots the subtree.
     */
    private void printTree(BinaryNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }


    public void createPerfectBinarySearchTree(AnyType[] sortedArray) {
        root = createPerfectBinarySearchTree(sortedArray, 0, sortedArray.length - 1);
    }

    public BinaryNode<AnyType> createPerfectBinarySearchTree(AnyType[] sortedArray, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryNode node = new BinaryNode(sortedArray[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = createPerfectBinarySearchTree(sortedArray, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = createPerfectBinarySearchTree(sortedArray, mid + 1, end);

        return node;
    }


    public void preorder(BinaryNode<AnyType> node) {
        if (node != null) {
            System.out.println(node.element);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(BinaryNode<AnyType> node) {
        if (node != null) {
            preorder(node.left);
            preorder(node.right);
            System.out.println(node.element);
        }

    }

    public void inorder(BinaryNode<AnyType> node) {
        if (node != null) {
            preorder(node.left);
            System.out.println(node.element);
            preorder(node.right);
        }

    }

    LinkedList<AnyType> level_order_values = new LinkedList<>();

    public void levelOrder(BinaryNode<AnyType> node) {
        Queue<BinaryNode<AnyType>> list = new LinkedList<>();
        list.add(node);
        while (!list.isEmpty()) {
            BinaryNode tempnode = list.poll();
            System.out.println(tempnode.element);
            if (tempnode.left != null) {
                list.add(tempnode.left);
            }
            if (tempnode.right != null) {
                list.add(tempnode.right);
            }
        }
    }

    public Queue<BinaryNode<AnyType>> getLevelOrder(BinaryNode<AnyType> node) {
        Queue<BinaryNode<AnyType>> list = new LinkedList<>();
        Queue<BinaryNode<AnyType>> levelOrderList = new LinkedList<>();
        list.add(node);
        while (!list.isEmpty()) {
            BinaryNode<AnyType> tempnode = list.poll();
            levelOrderList.add(tempnode);
            if (tempnode.left != null) {
                list.add(tempnode.left);
            }
            if (tempnode.right != null) {
                list.add(tempnode.right);
            }
        }
        return list;
    }

    private int sum = 0;

    private int internalPathLength(BinaryNode<AnyType> node, int depth) {

        if (node == null) {
            return 0;
        }
        return internalPathLength(node.left, depth + 1) + internalPathLength(node.right, depth + 1) + depth;
    }

    public int internalPathLength() {
        return internalPathLength(root, 0);
    }


    /**
     * Internal method to compute height of a subtree.
     *
     * @param t the node that roots the subtree.
     */
    private int height(BinaryNode<AnyType> t) {
        if (t == null)
            return -1;
        else
            return 1 + Math.max(height(t.left), height(t.right));
    }

    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType> {
        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child

        // Constructors
        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
    }

    /**
     * The tree root.
     */
    private BinaryNode<AnyType> root;


    // Test program
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        final int NUMS = 20;
        final int GAP = 37;

        System.out.println("Checking... (no more output means success)");

        for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
            bst.insert(i);
        //bst.createPerfectBinarySearchTree(i);

        for (int i = 1; i < NUMS; i += 2)
            bst.remove(i);

        //if (NUMS < 40)
        //    bst.printTree();
        if (bst.findMin() != 2 || bst.findMax() != NUMS - 2)
            System.out.println("FindMin or FindMax error!");

        for (int i = 2; i < NUMS; i += 2)
            if (!bst.contains(i))
                System.out.println("Find error1!");

        for (int i = 1; i < NUMS; i += 2) {
            if (bst.contains(i))
                System.out.println("Find error2!");
        }
        System.out.println("print tree: \n");
        bst.printTree();
        System.out.println("print inorder: \n");
        bst.inorder(bst.root);
        System.out.println("print postorder: \n");
        bst.postorder(bst.root);
        System.out.println("print preorder: \n");
        bst.preorder(bst.root);
        System.out.println("print level order: \n");
        bst.levelOrder(bst.root);

        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        Integer[] integerArray = new Integer[]{1, 2, 3, 4, 5, 6, 7};

        bst2.createPerfectBinarySearchTree(integerArray);
        bst2.levelOrder(bst2.root);

        System.out.println("path length: " + bst.internalPathLength());
    }
}
