package com.BFS;

import java.util.Stack;

public class BFSGraph {

	int size;
	adjList2[] array; 
	
	public BFSGraph(int size) {
		this.size=size;
		this.array = new adjList2[this.size];
		for(int i =0; i<this.size; i++) {
			array[i]=new adjList2();
			array[i].head = null;
		}
	}
	
	public void add(int src, int dest) {
		Node2 n = new Node2(dest, null);
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
			System.out.println("Node :"+nb);
			
			visited[nb]= true;
			Node2 head = array[nb].head;
			
			while(head!=null) {
				if(visited[head.value] == false) {
					s.push(head.value);
					visited[head.value]=true;
					
				} else {
					head=head.next;

				}
			}
		}
		
	}

}
