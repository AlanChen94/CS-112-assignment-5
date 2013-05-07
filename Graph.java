import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Graph {

	public ArrayList<Vertices> vertices;
	private HashMap<String, Integer> access;

	public int size() {
		return vertices.size();
	}

	public Graph(String graphFile) {
		vertices = new ArrayList<Vertices>();
		access = new HashMap<String, Integer>();
		try {
			buildGraph(graphFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Graph() {
		vertices = new ArrayList<Vertices>();
		access = new HashMap<String, Integer>();
	}

	public Graph(ArrayList<Vertices> g) {
		vertices = g;
		access = new HashMap<String, Integer>();
	}

	public void buildGraph(String docsFile) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(docsFile));
		int counter = Integer.parseInt(sc.nextLine());
		while (counter != 0) {
			String text = sc.nextLine();
			Vertices Vertices;
			if (text.charAt(text.indexOf('|') + 1) == 'n') {
				Vertices = new Vertices(text.substring(0, text.indexOf('|')),
						'n', "");
			} else
				Vertices = new Vertices(text.substring(0, text.indexOf('|')),
						'y', text.substring(text.indexOf('y') + 2));
			vertices.add(Vertices);
			System.out.println(Vertices);
			access.put(Vertices.name, vertices.indexOf(Vertices));
			counter--;
		}
		while (sc.hasNext()) {
			String text = sc.next();
			String name1 = text.substring(0, text.indexOf('|'));
			String name2 = text.substring(text.indexOf('|') + 1);
			int index1 = access.get(name1);
			int index2 = access.get(name2);
			Vertices temp1 = vertices.get(index1);
			Vertices temp2 = vertices.get(index2);
			temp1.next = null;
			vertices.get(index2).next = temp1;
			temp2.next = null;
			vertices.get(index1).next = temp2;
		}
	}

	public ArrayList<Vertices> subGraph(String schoolname) {


		if (schoolname.isEmpty()) {
			return null;
		}
		ArrayList<Vertices> SubGraph = new ArrayList<Vertices>();
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).schoolname.equals(schoolname)) {
				Vertices temp = vertices.get(i);
				Vertices temp1 = vertices.get(i);
				temp.next = null;
				SubGraph.add(temp);
				while (temp1.next != null) {
					if (temp1.next.schoolname.equals(schoolname)) {
						Vertices tempNeighbor = temp1.next;
						tempNeighbor.next = null;
						SubGraph.get(access.get(temp)).next = tempNeighbor;
					}
					temp1 = temp1.next;
				}
			}
		}
		return SubGraph;
	}

	public String shortestPath(String name1, String name2) {

		return null;
	}

	public ArrayList<Graph> dfsTraversal() {
		boolean[] visited = new boolean[vertices.size()];
		ArrayList<Graph> gr = new ArrayList<Graph>();
		for (int i = 0; i < vertices.size(); i++) {
			update(visited, i);
			Graph subGraph = new Graph();
			Graph compliment = new Graph();
			for (int x = 0; x < visited.length; x++) {
				if (visited[x]) {
					subGraph.vertices.add(vertices.get(x));
					subGraph.access.put(vertices.get(x).name(),
							vertices.indexOf(x));
				} else {
					compliment.vertices.add(vertices.get(x));
					compliment.access.put(vertices.get(x).name(),
							vertices.indexOf(x));
				}
			}

			gr.add(subGraph);
			gr.addAll(compliment.dfsTraversal());
			return gr;
		}
		return gr;
	}

	public void update(boolean[] visited, int i) {
		if (visited[i])
			return;

		visited[i] = true;

		for (Vertices head = vertices.get(i); head != null; head = head.next) {
			Integer d = this.access.get(head.name);
			update(visited, d);
		}
	}

	public boolean isEmpty() {
		if (vertices.size() == 0)
			return true;
		else
			return false;
	}

	public void printGraph() {
	}

	public ArrayList<Graph> dfsTraversal(String name1, String name2) {
		boolean[] visited = new boolean[vertices.size()];
		ArrayList<Graph> gr = new ArrayList<Graph>();
		Graph subGraph = new Graph();
		Graph compliment = new Graph();
		Vertices holder = vertices.get(access.get(name1));
		for (Vertices temp = vertices.get(access.get(name1)); temp != null; temp = temp.next) {
			if (visited[access.get(name1)]) {
				subGraph.vertices.add(vertices.get(access.get(name1)));
				subGraph.access.put(name1, vertices.indexOf(temp));
				if (name1.equals(name2)) {
					break;
				}
			} else {
				compliment.vertices.add(vertices.get(access.get(name1)));
				compliment.access.put(name1, vertices.indexOf(temp));
				visited[access.get(name1)] = true;
				if (name1.equals(name2)) {
					break;
				}
			}
		}
		gr.add(subGraph);
		gr.addAll(compliment.dfsTraversal(holder.next.name, name2));
		return gr;
	}
}
