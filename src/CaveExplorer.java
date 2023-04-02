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
}