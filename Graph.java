import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
	
	private ArrayList<Vertices> graph;
	private HashMap<String, Integer> access;
	
	public int size(){
		return graph.size();
	}
	
	public Graph(String graphFile){
		graph = new ArrayList<Vertices>();
		access = new HashMap<String, Integer>();
		try {
			buildGraph(graphFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Graph() {
		
		graph = new ArrayList<Vertices>();
		access = new HashMap<String, Integer>();
		
	}
	
	public void buildGraph(String docsFile) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(docsFile));
		int counter = Integer.parseInt(sc.nextLine());
		while(counter != 0){
			String text = sc.nextLine();
			Vertices person;
			if(text.charAt(text.indexOf('|') + 1) == 'n'){
				person = new Vertices(text.substring(0, text.indexOf('|')), 'n', "");
			}else
				person = new Vertices(text.substring(0, text.indexOf('|')), 'y', text.substring(text.indexOf('y')+2));
			graph.add(person);
			//System.out.println(person);
			access.put(person.name, graph.indexOf(person));
			
			counter--;
		}while(sc.hasNext()){
			String text = sc.next();
			String name1 = text.substring(0, text.indexOf('|'));
			String name2 = text.substring(text.indexOf('|')+1);
			int index1 = access.get(name1);
			int index2 = access.get(name2);
 			Vertices temp1 = graph.get(index1);
 			Vertices temp2 = graph.get(index2);
 			temp1.next = null;
 			graph.get(index2).next = temp1;
 			temp2.next = null;
 			graph.get(index1).next = temp2;
		}
	}
	
	public ArrayList<Vertices> subGraph(String schoolname){
		if(schoolname.isEmpty()){
			return null;
		}ArrayList<Vertices> SubGraph = new ArrayList<Vertices>();
		for(int i = 0; i < graph.size(); i++){
			if(graph.get(i).schoolname.equals(schoolname)){
				Vertices temp = graph.get(i);
				Vertices temp1 = graph.get(i);
				temp.next = null;
				SubGraph.add(temp);
				while(temp1.next != null){
					if(temp1.next.schoolname.equals(schoolname)){
						Vertices tempNeighbor = temp1.next;
						tempNeighbor.next = null;
						SubGraph.get(access.get(temp)).next = tempNeighbor;
					}temp1 = temp1.next;	
				}
			}
		}return SubGraph;
	}
	
	public String shortestPath(String name1, String name2){
		boolean[]visited = new boolean[graph.size()];
		Queue<Vertices> q = new LinkedList<Vertices>();
		Vertices head = graph.get(access.get(name1));
		Vertices temp = head;
		visited[graph.indexOf(temp)] = true;
		String s = "";
		while(temp.next != null){
			q.add(temp.next);
			visited[graph.indexOf(temp.next)] = true;
			if(temp.next.name.equals(name2)){
				s = name1 +"--"+ name2;
				return s;
			}temp = temp.next;
		}while(!q.isEmpty()){
			Vertices temp1 = q.poll();
			while(temp1.next != null){
				if(visited[graph.indexOf(temp1.next)] == false){
					q.add(temp1.next);
					visited[graph.indexOf(temp1.next)] = true;
				}temp1 = temp1.next;
			}
			
		}
		
		return null;
	}
	
	public ArrayList<Vertices> dfsTraversal(String name1, String name2){
		boolean[]visited = new boolean[graph.size()];
		ArrayList<Vertices> paths = new ArrayList<Vertices>(); 
		boolean tracker = false;
		if(visited[access.get(name1)]){
			return null;
		}visited[access.get(name1)] = true;
		Vertices temp = graph.get(access.get(name1));
		paths.add(temp);
		while(temp != null){
			if(temp.name == name2){
				tracker = true;
				break;
			}
			dfsTraversal(temp.next.name, name2);
			temp = temp.next;
		}if(tracker)
			return paths;
		else
			return null;
	}
	
	public ArrayList<Graph> dfsTraversal() {
		boolean[] visited = new boolean[graph.size()];
		ArrayList<Graph> gr = new ArrayList<Graph>();
		for (int i = 0; i < graph.size(); i++) {
			// printDfs(i, visited);
			Graph subGraph = new Graph();
			Graph compliment = new Graph();
			for (int x = 0; x < visited.length; x++) {
				if (visited[x]) {
					subGraph.graph.add(graph.get(x));
					subGraph.access.put(graph.get(x).name, graph.indexOf(x));
				} else {
					compliment.graph.add(graph.get(x));
					compliment.access.put(graph.get(x).name, graph.indexOf(x));
				}
			}

			gr.add(subGraph);
			gr.addAll(compliment.dfsTraversal());
			return gr;
		}
		return gr;
	}
}
