public class CaveExplorerDriver {

    public static void main(String[] args) {
        CaveExplorer ce = new CaveExplorer();

        System.out.println("Initial grid: \n" + ce.toString());
        System.out.println("Is there a solution: " + ce.solve() + "\n");
        System.out.println("Solution path: " +ce.getPath() + "\n");
        System.out.println("Current state of grid: \n" + ce.toString() + "\n");
        System.out.println("=============================================\n");

        System.out.println("Now lets test with the file...\n");
        try {
            CaveExplorer ce1 = new CaveExplorer("./src/cave_layout.txt");

            System.out.println("Initial grid: \n" + ce1.toString());
            System.out.println("Is there a solution: " + ce1.solve() + "\n");
            System.out.println("Solution path: " +ce1.getPath() + "\n");
            System.out.print("Current state of grid: \n" + ce1.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        //  backtracking
        String[] caveLayouts = {
                "5 6\n" +
                        "RRRRRR\n" +
                        "R..S.R\n" +
                        "R.R.RR\n" +
                        "R.MRRR\n" +
                        "RRRRRR"
        };

        for (String layout : caveLayouts) {
            System.out.println("Now let's test a new cave layout:\n");
            try {
                // Constructor with the string input
                CaveExplorer ce2 = new CaveExplorer(layout, true);

                // Test solution and methods
                System.out.println("Initial grid: \n" + ce2.toString());
                System.out.println("Is there a solution: " + ce2.solve() + "\n");
                System.out.println("Solution path: " + ce2.getPath() + "\n");
                System.out.print("Current state of grid: \n" + ce2.toString());
                System.out.println("=============================================\n");
            } catch (Exception e) {
                e.printStackTrace();}
        }
    }
}
