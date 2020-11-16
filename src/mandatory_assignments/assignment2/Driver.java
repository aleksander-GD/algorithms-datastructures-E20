package mandatory_assignments.assignment2;

import lecture_7_trees.BinarySearchTree;

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

        board = new int[boardHeight][boardWidth];
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.startXPos = knightStartXPosition;
        this.startYPos = knightStartYPosition;
        this.endXPos = knightEndXPosition;
        this.endYPos = knightEndYPosition;
        queue = new LinkedList<>();

        board[knightStartXPosition][knightStartYPosition] = 1;
        root = new Node(knightStartXPosition, knightStartYPosition);

        // level order
        root.setHeightCounter(0);
        queue.add(root);
        while (!queue.isEmpty()) {

            Node pollnode = queue.poll();

            counterNodes++;
            System.out.println("x: " + pollnode.getX() + " Y: " + pollnode.getY());
            findValidMoves(pollnode);
            if (foundGoalTarget(pollnode)) {
                System.out.println("GOAL REACHED");
                System.out.println("Node count: " + counterNodes);
                System.out.println("Height: " + height);
                break;
            }

        }

        return -1;
    }

    /*private int height(Node t) {
        if (t == null)
            return -1;
        else
            return 1 + Math.max(height(t));
    }*/

    private boolean foundGoalTarget(Node node) {
        if (node.getX() == endXPos && node.getY() == endYPos) {
            return true;
        }
        return false;
    }

    /***
     * Finder alle valid moves,
     * @param node
     */
    public void findValidMoves(Node node) {
        height = node.getHeightCounter();
        for (int i = 0; i < 8; i++) {

            // Nye koordinator for den næste nye valid move
            int new_x = node.getX() + knightPossibleMovesX[i];
            int new_y = node.getY() + knightPossibleMovesY[i];
            // hvis move er
            if (new_x >= 0 && new_y >= 0 && new_x < boardWidth && new_y < boardHeight && board[new_x][new_y] == 0) {
                board[new_x][new_y] = 1;
                Node tempNode = new Node(new_x, new_y);
                height++;
                // tæler et til hver højde vi tilføjer
                tempNode.setHeightCounter(height);
                queue.add(tempNode);

                node.addChild(new Node(new_x, new_y));

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


    public class Tree {
        Node root;
        Queue<Node> list = new LinkedList<>();

        public void buildTree(Node node) {
            if (root == null) {
                this.root = node;
                return;
            }

            list.add(node);
            Node temp = new Node(node.x, node.y);
            while (!list.isEmpty()) {


                if (list.size() == 8) {
                    node.addChild(list.poll());
                }
            }
        }

        public Node getRoot() {
            return root;
        }
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

