public class CaveExplorer {
    private int numRows;
    private int numCols;

    // new vars
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
                {'R', '.', '.', 'S', 'R', 'R'},
                {'R', '.', 'R', 'R', 'R', 'R'},
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

    // Step 3: solve method
    public boolean solve() {
        int r = this.startRow;
        int c = this.startCol;

        // iterate through the cells in the path
        while (r < this.rows && c < this.cols) {

            // check if we are  at the target
            if (this.cave[r][c] == 'M') {
                return true;
            }

            // Mark the location to avoid looping
            this.cave[r][c] = 'S';

            // search for path now in all four directions [N,S,W,E]
            if(this.validCell(r-1,c)) {
                this.path += "n";
                r--;
            } else if (this.validCell(r+1, c)) {
                this.path += "s";
                r++;
            } else if (this.validCell(r, c-1)) {
                this.path += "w";
                c--;
            } else if (this.validCell(r, c+1)) {
                this.path += "e";
                c++;
            } else {
                return false;
            }
        }

        // No valid path
        return false;
    }

    public boolean validCell(int r, int c) {
        // 2D array outOfBounds check
        if (r >= this.cave.length || r < 0 || c < 0 | c >= this.cave[0].length) {
            return false;
        }

        // check if the move in a path is possible
        if (this.cave[r][c] == 'S' || this.cave[r][c] == 'R') {
            return false;
        }

        return true;
    }

    // Step 4: getPath method
    public String getPath() {
        return this.path;
    }
}