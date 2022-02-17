import java.util.ArrayList;
import java.util.Stack;

public class DFSGraph {

	int size;
	adjList[] array;
	
	ArrayList<Integer> nvisited = new ArrayList<>();
	
	public DFSGraph(int size) {
		this.size = size;
		this.array = new adjList[this.size];
		for(int i =0; i<this.size; i++) {
			array[i]=new adjList();
			array[i].head = null;
		}
	}
	
	public void add(int src, int dest) {
		Node n = new Node(dest, null);
		n.next = array[src].head;
		array[src].head=n;
	}
	
	public void explore(int vertex) {
		Boolean[] visited = new Boolean[array.length];
		for(int i =0; i<array.length; i++) {
			visited[i]=false;
		}
		Stack<Integer> s = new Stack<Integer>();
		s.push(vertex);
		
		while(!s.isEmpty()) {
			int nb = s.pop();
			s.push(nb);
		
			visited[nb]= true;
			Node head = array[nb].head;
			boolean isDone = true;
			
			while(head!=null) {
				if(visited[head.value] == false) {
					s.push(head.value);
					visited[head.value]=true;
					isDone = false;
					break;
					
				} else {
					head=head.next;

				}
			}
			
			if(isDone == true )
			nvisited.add(s.pop());
			
		}
		
		System.out.println(nvisited);
	}

}
