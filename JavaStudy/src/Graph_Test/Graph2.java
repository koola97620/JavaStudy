package Graph_Test;

import java.util.LinkedList;
import java.util.Queue;

class Vertex2 {
	public char label;
	public boolean visited;
	public Vertex2(char lab) {
		this.label = lab;
		this.visited =false;
	}
}

public class Graph2 {
	private final int maxVertices = 20;
	private Vertex2 Vertex2List[];
	private int adjMatrix[][];
	private int Vertex2Count;
	private Queue<Integer> theQueue;
	
	public Graph2() {
		Vertex2List = new Vertex2[maxVertices];
		adjMatrix = new int[maxVertices][maxVertices];
		Vertex2Count =0;
		for(int y=0 ; y < maxVertices ; y++) 
			for(int x=0 ; x < maxVertices; x++) 
				adjMatrix[x][y] = 0;
		
		theQueue = new LinkedList<Integer>();
	}
	
	public void addVertex2(char lab) {
		Vertex2List[Vertex2Count++] = new Vertex2(lab);
	}
	
	public void addEdge(int start, int end) {
		adjMatrix[start][end] =1;
		adjMatrix[end][start] =1;
	}
	
	public void displayVertex2(int v) {
		System.out.println(Vertex2List[v].label);
	}
	public void bfs() {  // 무조건 0부터 시작하냐!!?
		Vertex2List[0].visited = true;
		displayVertex2(0);
		theQueue.offer(0);
		int v2;
		while(!theQueue.isEmpty()) {
			int v1 = theQueue.poll();
			while((v2 = getAdjUnvisitedVertex2(v1)) != -1) {
				Vertex2List[v2].visited = true;
				displayVertex2(v2);
				theQueue.offer(v2);
			}
			
		}
		
		
		for(int j=0 ; j < Vertex2Count ; j++) {  // 초기화.
			Vertex2List[j].visited = false;
		}
		
	}
	
	public int getAdjUnvisitedVertex2(int v) {
		for(int j=0; j < Vertex2Count ; j++) {
			if(adjMatrix[v][j]==1 && Vertex2List[j].visited==false) {  //선이 연결되어 있고 방문을 안했으면
				return j;
			}
		}
		return -1;
		
	}
	

}
