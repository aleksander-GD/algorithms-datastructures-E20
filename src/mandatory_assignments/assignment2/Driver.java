package mandatory_assignments.assignment2;

import java.util.*;

public class Driver {

    private int[][] board;
    private int boardWidth;
    private int boardHeight;
    private int[][] boardMarked;
    private int startXPos;
    private int startYPos;
    private int endXPos;
    private int endYPos;
    private int knightPossibleMovesX[] = {2, 1, -1, -2, -2, -1, 1, 2};
    private int knightPossibleMovesY[] = {1, 2, 2, 1, -1, -2, -2, -1};
    private Queue<Node> queue;
    private int counterNodes;
    private int height;

    private Node root;

    public int MinimumSteps(int boardHeight, int boardWidth, int knightStartXPosition,
                            int knightStartYPosition, int knightEndXPosition, int knightEndYPosition) {

        board = new int[boardWidth][boardHeight];
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.startXPos = knightStartXPosition;
        this.startYPos = knightStartYPosition;
        this.endXPos = knightEndXPosition;
        this.endYPos = knightEndYPosition;
        counterNodes = 0;
        queue = new LinkedList<>(); // Tree intepretation

        board[knightStartXPosition][knightStartYPosition] = 1;
        root = new Node(knightStartXPosition, knightStartYPosition);
        root.setHeightCounter(0);
        // level order
        levelOrder(root);

        return -1;
    }

    public void levelOrder(Node root) {
        queue.add(root);
        while (!queue.isEmpty()) {

            Node pollnode = queue.poll();
            System.out.println("x: " + pollnode.getX() + " Y: " + pollnode.getY());
            findValidMoves(pollnode);

            if (foundGoalTarget(pollnode)) {
                //printBoard(board);
                System.out.println("GOAL REACHED");
                System.out.println("Node count: " + counterNodes);
                System.out.println("Height: " + height);
                break;
            }
        }
    }

    private boolean foundGoalTarget(Node node) {
        if (node.getX() == endXPos && node.getY() == endYPos) {
            board[endXPos][endYPos] = 2;
            return true;
        }
        return false;
    }

    /***
     * Finder alle valid moves,
     * @param node
     */
    public void findValidMoves(Node node) {

        for (int i = 0; i < 8; i++) {
            height = node.getHeightCounter();

            // Nye koordinator for den næste nye valid move
            int newX = node.getX() + knightPossibleMovesX[i];
            int newY = node.getY() + knightPossibleMovesY[i];

            // hvis moves er valid, marker dem på board,
            //
            if (newX >= 0 && newY >= 0 && newX < boardWidth && newY < boardHeight && board[newX][newY] == 0) {
                board[newX][newY] = 1;

                Node tempNode = new Node(newX, newY);
                counterNodes++;
                height++;
                // tæller et til hver højde vi tilføjer
                tempNode.setHeightCounter(height);
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

    class Node {
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
}

