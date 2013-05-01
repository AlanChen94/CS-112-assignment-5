public class Vertices {
  
	String name;
	char school;
	String schoolname;
	Vertices next;
	
	public Vertices (String name, char school, String schoolname){
		
		this.name = name;
		this.school = school;
		this.schoolname = schoolname;
		this.next = null;
		
	}
	
	public String toString(){
		return name + " " + school + " " + school;
	}
}
