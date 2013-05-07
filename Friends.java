// Alan Chen & Dhaval Patel
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Friends {

	static Graph g;

	public static void main(String[] args) {
		g = initGraph();

		while (true) {
			menu();
		}
	}

	public static Graph initGraph() {
		Scanner s = new Scanner(System.in);

		// Try to load and create the graph

		System.out.print("Please enter the name of the graph file : ");
		String graph = s.nextLine();
		return new Graph(graph);

	}

	public static void menu() {
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
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter school:");
			String sch = sc.nextLine();
			Graph subG = new Graph(g.subGraph(sch));
			for(Vertices vert : subG.vertices)
			{
				vert.print();
			}
			break;
		case 2:
			// Shortest intro chain
			break;
		case 3:
			// Cliques at a school
			Scanner x = new Scanner(System.in);
			System.out.println("Enter school:");
			String school = x.nextLine();
			Graph subGraph = new Graph(g.subGraph(school));
			ArrayList<Graph> currentGraphs = subGraph.dfsTraversal();
			for (int i = 0; i < currentGraphs.size(); i++) {
				int number = i + 1;
				System.out.println();
				System.out.println("Clique " + number);
				for(Vertices vert : currentGraphs.get(i).vertices)
				{
					vert.print();
				}
			}
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
