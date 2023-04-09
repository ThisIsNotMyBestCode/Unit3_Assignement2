/* CaveExplorer.java:
 * The CaveExplorer class is designed to find a unique path
 * to a mirror pool in a cave represented by a 2D grid of characters.
 *
 * Author: Otabek Aripdjanov 597066
 * Last updated: 4/9/2023
 */

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class CaveExplorer {
    private int rows;
    private int cols;
    private int startRow;
    private int startCol;
    private char[][] cave;
    private String path;

    // Step 1: Zero parameter constructor to create the specified cave
    public CaveExplorer() {
        this.path = "";
        this.rows = 5;
        this.cols = 6;
        this.startRow = 1;
        this.startCol = 3;

        // Initialize the cave 2D array
        this.cave = new char[][] {
                {'R', 'R', 'R', 'R', 'R', 'R'},
                {'R', '.', '.', 'S', '.', 'R'},
                {'R', '.', 'R', '.', 'R', 'R'},
                {'R', '.', 'M', 'R', 'R', 'R'},
                {'R', 'R', 'R', 'R', 'R', 'R'}
        };
    }

    // Step 2: toString method
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                sb.append(this.cave[r][c]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    class Position {
        int row;
        int col;
        String path;

        public Position(int row, int col, String path) {
            this.row = row;
            this.col = col;
            this.path = path;
        }
    }

    // Step 3: solve method
    public boolean solve() {

        Stack<Position> stack = new Stack<>();

        // Push the starting coordinates to stack as the first item
        stack.push(new Position(this.startRow, this.startCol, ""));

        while (!stack.isEmpty()) {

            Position current = stack.pop();
            int r = current.row;
            int c = current.col;
            String pathSoFar =  current.path;

            // Out of bounds check
            if (this.outOfBounds(r, c)) {
                continue;
            }

            // if the current cell contains the target value, add the position to the path and return true
            if (this.cave[r][c] == 'M') {
                this.path = pathSoFar;
                return true;
            }

            // mark the current cell as visited
            this.cave[r][c] = 'S';

            if(!this.outOfBounds(r-1, c) && this.validCell(r-1,c)) {
                stack.push(new Position( r-1, c, pathSoFar+"n"));
            }

            if (!this.outOfBounds(r+1, c) && this.validCell(r+1, c)) {
                stack.push(new Position(r+1, c, pathSoFar+"s"));
            }

            if (!this.outOfBounds(r, c-1) && this.validCell(r, c-1)) {
                stack.push(new Position(r, c-1, pathSoFar+"w"));
            }

            if (!this.outOfBounds(r, c+1) && this.validCell(r, c+1)) {
                stack.push(new Position(r, c+1, pathSoFar+"e"));
            }
        }

        return false;
    }

    // 2D array outOfBounds check
    public boolean outOfBounds(int r, int c) {
        if (r >= this.cave.length || r < 0 || c < 0 | c >= this.cave[0].length) {
            return true;
        }

        return false;
    }

    public boolean validCell(int r, int c) {
        // check if the move in a path is possible
        if ( this.cave[r][c] == 'S' || this.cave[r][c] == 'R') {
            return false;
        }

        return true;
    }

    // Step 4: getPath method
    public String getPath() {
        return this.path;
    }

    // Step 5: One parameter constructor to read from a file
    public CaveExplorer(String fname) throws Exception {
        Scanner in = new Scanner(new File(fname));
        initializeCave(in);
    }

    // New method to initialize the cave with a Scanner object
    private void initializeCave(Scanner in) throws Exception {
        this.rows = in.nextInt();
        this.cols = in.nextInt();
        this.cave = new char[this.rows][this.cols];

        this.path = "";
        in.nextLine(); // consume the newline character
        for (int r = 0; r < this.rows; r++) {
            String line = in.nextLine();
            for (int c = 0; c < this.cols; c++) {
                this.cave[r][c] = line.charAt(c);
                if (this.cave[r][c] == 'S') {
                    this.startRow = r;
                    this.startCol = c;
                }
            }
        }
        if (this.startRow == 0) {
            throw new Exception("Missing start location");
        }
    }

    // New constructor to accept a String layout
    public CaveExplorer(String layout, boolean isLayout) {
        Scanner in = new Scanner(layout);
        try {
            initializeCave(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
