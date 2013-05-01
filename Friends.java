// Alan Chen & Dhaval Patel
import java.util.Scanner;

public class Friends{

    public static void main(String[] args)
    {
        initGraph();

        while(true)
        {
            menu();
        }
    }
    
    public static void initGraph()
    {
        Scanner s = new Scanner(System.in);

        // Try to load and create the graph  

        System.out.print("Please enter the name of the graph file : ");
        String graph = s.nextLine();
        Graph g = new Graph(graph);

        
    }

    public static void menu()
    {
        System.out.println("Friendship Graph : Please choose an option.");
        System.out.println("(1) Students at a school");
        System.out.println("(2) Shortest intro chain");
        System.out.println("(3) Cliques at a school");
        System.out.println("(4) Connectors");
        System.out.println("(5) Quit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Students at a school
                break;
            case 2:
                // Shortest intro chain
                break;
            case 3:
                // Cliques at a school
                break;
            case 4:
                // Connectors
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Not a valid input, try again.");
        }
    }
}
