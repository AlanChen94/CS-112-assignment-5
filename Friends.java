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


            System.output.println("Do you want to continue? y/n");

        }
    }
    
    public void initGraph()
    {
        String graph = s.nextString();
        System.out.print("Please enter the name of the graph file : ")
        try 
        {
            Scanner s = new Scanner(System.in);   
            graph = s.nextString();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: File not found");
        }
        Graph g = new Graph(graph);
    }

    public void menu()
    {

    }


}
