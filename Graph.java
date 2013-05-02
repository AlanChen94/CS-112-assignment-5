import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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
			System.out.println(person);
			access.put(person.name, graph.indexOf(person));
			counter--;
		}while(sc.hasNext()){
			String text = sc.next();
			String name1 = text.substring(0, text.indexOf('|'));
			String name2 = text.substring(text.indexOf('|')+1);
			int index1 = access.get(name1);
			int index2 = access.get(name2);
 			Vertices temp1 = graph.get(index1);
 			graph.get(index2).next = temp1;
 			Vertices temp2 = graph.get(index2);
 			temp2.next = null;
 			graph.get(index1).next = temp2;
		}
	}
}

