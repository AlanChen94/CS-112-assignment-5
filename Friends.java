// Alan Chen & Dhaval Patel
import java.util.Scanner;

public class Friends{

    public static void main(String[] args)
    {
        initGraph();

        Scanner s = new Scanner(System.in);

        while(true)
        {
            menu();
        }
    }
    
    public void initGraph()
    {
        String graph = s.nextString();
        System.out.print("Please enter the name of the graph file : ")
        // Try to load and create the graph
        try 
        {
            Scanner s = new Scanner(System.in);   
            graph = s.nextLine();
            Graph g = new Graph(graph);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: File not found");
        }

    }

    public void menu()
    {
        System.out.println("Friendship Graph : Please choose an option.");
        System.out.println("(A) Students at a school");
        System.out.println("(B) Shortest intro chain");
        System.out.println("(C) Cliques at a school");
        System.out.println("(D) Connectors");
        System.out.println("(Q) Quit");
    }


}
