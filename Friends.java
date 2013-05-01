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
        System.out.print("Please enter the name of the graph file : ");
        String graph = s.nextLine();
        // Try to load and create the graph  
         Graph g = new Graph(graph);
  

    }

    public static void menu()
    {
        System.out.println("Friendship Graph : Please choose an option.");
        System.out.println("(A) Students at a school");
        System.out.println("(B) Shortest intro chain");
        System.out.println("(C) Cliques at a school");
        System.out.println("(D) Connectors");
        System.out.println("(Q) Quit");
    }
}
