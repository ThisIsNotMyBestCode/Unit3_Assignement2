public class CaveExplorerDriver {

    public static void main(String[] args) {
        // Default constructor
        CaveExplorer ce = new CaveExplorer();

        // Test solution and methods
        System.out.println("Initial grid: \n" + ce.toString());
        System.out.println("Is there a solution: " + ce.solve() + "\n");
        System.out.println("Solution path: " +ce.getPath() + "\n");
        System.out.println("Current state of grid: \n" + ce.toString() + "\n");
        System.out.println("=============================================\n");


        System.out.println("Now lets test with the file...\n");
        try {
            //Constructor with the file path
            CaveExplorer ce1 = new CaveExplorer("./src/cave_layout.txt");

            // Test solution and methods
            System.out.println("Initial grid: \n" + ce1.toString());
            System.out.println("Is there a solution: " + ce1.solve() + "\n");
            System.out.println("Solution path: " +ce1.getPath() + "\n");
            System.out.print("Current state of grid: \n" + ce1.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}