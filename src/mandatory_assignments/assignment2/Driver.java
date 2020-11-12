package mandatory_assignments.assignment2;

import lecture_7_trees.BinarySearchTree;

import java.util.*;

public class Driver {

    private static int[][] board;
    private static int startXPos;
    private static int startYPos;
    private static int endXPos;
    private static int endYPos;
    private static int knightPossibleMovesX[] = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int knightPossibleMovesY[] = {1, 2, 2, 1, -1, -2, -2, -1};

    public int MinimumSteps(int boardHeight, int boardWidth, int knightStartXPosition,
                            int knightStartYPosition, int knightEndXPosition, int knightEndYPosition) {

        board = new int[boardWidth][boardHeight];
        int counter = 0;
        int[][] boardMarked = new int[boardWidth][boardHeight];
        Tree tree = new Tree();
        //tree.levelOrderQueue(new Node(startXPos, startYPos));
        for (int i = 0; i < board.length; i++) {

            // Generating co-ordinate of new cell ...............
            int new_x = knightStartXPosition + knightPossibleMovesX[i];
            int new_y = knightStartYPosition + knightPossibleMovesY[i];

            // If the move is valid and we have previously traversed new cell then push it into queue .........
            if (new_x >= 0 && new_y >= 0 && new_x < boardWidth && new_y < boardHeight && board[new_x][new_y] == 0) {
                tree.levelOrderQueue(new Node(new_x, new_y));
                boardMarked[new_x][new_y] = 1;
                counter++;
            } else if (new_x == knightEndXPosition && new_y == knightEndYPosition) {
                return counter;
            }
            printTwoDimensionalArray(boardMarked);
        }


        return -1;
    }


    public static void printTwoDimensionalArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%d ", a[i][j]);
            }
            System.out.println();
        }
    }


    public class Tree {
        Node root;

        private Node addRecursive(Node current, int x, int y) {
            if (current == null) {
                return new Node(x, y);
            }

           current.parent.children.add(addRecursive(current, x, y));
            return current;
        }

        public void add(int x, int y) {
            root = addRecursive(root, x, y);
        }

        public void traverseLevelOrder() {
            if (root == null) {
                return;
            }

            Queue<Node> nodes = new LinkedList<>();
            nodes.add(root);

            while (!nodes.isEmpty()) {

                Node node = nodes.remove();

                System.out.print(" " + node.value);

                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }
    }



    class Node {
        private int x;
        private int y;
        private List<Node> children;
        private Node parent;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.children = new ArrayList<Node>();
        }
    }
}
