package mandatory_assignments.assignment2;

import java.util.*;

public class Driver {

    private static int[][] board;
    private static int boardX;
    private static int boardY;
    private static int startXPos;
    private static int startYPos;
    private static int endXPos;
    private static int endYPos;
    private static int knightPossibleMovesX[] = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int knightPossibleMovesY[] = {1, 2, 2, 1, -1, -2, -2, -1};
    private static Queue<Node> queue;
    private static int counterNodes;
    private static int height;
    private static Node root;
    private static Tree tree;

    public static int MinimumSteps(int boardHeight, int boardWidth, int knightStartXPosition,
                                   int knightStartYPosition, int knightEndXPosition, int knightEndYPosition) {

        board = new int[boardWidth][boardHeight];
        boardX = boardWidth;
        boardY = boardHeight;
        startXPos = knightStartXPosition;
        startYPos = knightStartYPosition;
        endXPos = knightEndXPosition;
        endYPos = knightEndYPosition;

        counterNodes = 0;
        queue = new LinkedList<>(); // Tree intepretation

        board[startXPos][startYPos] = 1;
        root = new Node(startXPos, startYPos);
        root.setHeightCounter(0);
        tree = new Tree();
        tree.insert(startXPos, startYPos);
        // level order
        int h = levelOrder(root);

        return h;
    }

    public static int levelOrder(Node root) {
        queue.add(root);
        while (!queue.isEmpty()) {

            Node pollnode = queue.poll();
            //System.out.println("x: " + pollnode.getX() + " Y: " + pollnode.getY());
            findValidMoves(pollnode);

            if (foundGoalTarget(pollnode)) {
                //printBoard(board);
                //System.out.println("GOAL REACHED");
                //System.out.println("Node count: " + counterNodes);
                //System.out.println("Height: " + height);
                break;
            }
        }
        return height;
    }


    private static boolean foundGoalTarget(Node node) {
        if (node.getX() == endXPos && node.getY() == endYPos) {

            board[endXPos][endYPos] = 1;
            return true;
        }
        return false;
    }

    /***
     * Finder alle valid moves,
     * @param node
     */
    public static void findValidMoves(Node node) {
        for (int i = 0; i < 8; i++) {
            height = node.getHeightCounter();

            // Nye koordinator for den næste nye valid move
            int newX = knightPossibleMovesX[i] + node.getX();
            int newY = knightPossibleMovesY[i] + node.getY();

            // hvis moves er valid, marker dem på board,
            //
            if (newX >= 0 && newY >= 0 && newX < boardX && newY < boardY && board[newX][newY] == 0) {
                board[newX][newY] = 1;
                Node tempNode = new Node(newX, newY);

                counterNodes++;
                height++;

                // tæller et til hver højde vi tilføjer
                tempNode.setHeightCounter(height);
                height = tempNode.getHeightCounter() - 1;
                queue.add(tempNode);

                node.addChild(new Node(newX, newY));
            }
            //printBoard(board);
        }
    }

    public static void printBoard(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    static class Node {
        private int x;
        private int y;
        private List<Node> children;
        private int heightCounter = 0;


        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.children = new ArrayList<Node>();
        }

        public int getHeightCounter() {
            return heightCounter;
        }

        public void setHeightCounter(int heightCounter) {
            this.heightCounter = heightCounter;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void addChild(Node newChild) {
            children.add(newChild);
        }

        public List<Node> getChildren() {
            return children;
        }
    }

    static class Tree {
        private Node root;

        public Node insert(Node node, int x, int y) {
            if (node == null) {
                return new Node(x, y);
            }
            return node = insert(node, x, y);
        }

        public void insert(int x, int y) {
            root = insert(root, x, y);
        }
    }
}

