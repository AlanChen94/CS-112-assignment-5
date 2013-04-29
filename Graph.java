import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
  
	int size;
	ArrayList<Vertices> graph;
	
	public Graph(){
		graph = new ArrayList<Vertices>();
	}
	
	public void buildGraph(String docsFile) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(docsFile));
		int counter = Integer.parseInt(sc.nextLine());
		while(counter != 0){
			String text = sc.next();
			Vertices person;
			if(text.indexOf('|') + 1 == 'n'){
				person = new Vertices(text.substring(0, text.indexOf('|')), 'n', "");
			}else
				person = new Vertices(text.substring(0, text.indexOf('|')), 'y', text.substring(text.indexOf('y')+2));
			graph.add(person);
		}
	}
}
