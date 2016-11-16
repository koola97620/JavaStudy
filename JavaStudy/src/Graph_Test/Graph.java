package Graph_Test;

import java.util.Stack;

class Vertex {
	public char label;
	public boolean visited;
	public Vertex(char lab) {
		this.label = lab;
		this.visited =false;
	}
}

public class Graph {
	private final int maxVertices = 20;
	private Vertex vertexList[];
	private int adjMatrix[][];
	private int vertexCount;
	private Stack<Integer> theStack;
	public Graph() {
		vertexList = new Vertex[maxVertices];
		adjMatrix = new int[maxVertices][maxVertices];
		vertexCount =0;
		for(int y=0 ; y < maxVertices ; y++) 
			for(int x=0 ; x < maxVertices; x++) 
				adjMatrix[x][y] = 0;
		
		theStack = new Stack<Integer>();
	}
	
	public void addVertex(char lab) {
		vertexList[vertexCount++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end) {
		adjMatrix[start][end] =1;
		adjMatrix[end][start] =1;
	}
	
	public void displayVertex(int v) {
		System.out.println(vertexList[v].label);
	}
	public void dfs() {  // 무조건 0부터 시작하냐!!?
		vertexList[0].visited = true;
		displayVertex(0);
		theStack.push(0);
		
		while(!theStack.isEmpty()) {
			int v = getAdjUnvisitedVertex(theStack.peek());
			if(v== -1) { //이미 방문 했던거면.
				theStack.pop();
			} else {
				vertexList[v].visited = true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		
		for(int j=0 ; j < vertexCount ; j++) {  // 초기화.
			vertexList[j].visited = false;
		}
		
	}
	
	public int getAdjUnvisitedVertex(int v) {
		for(int j=0; j < vertexCount ; j++) {
			if(adjMatrix[v][j]==1 && vertexList[j].visited==false) {  //선이 연결되어 있고 방문을 안했으면
				return j;
			}
		}
		return -1;
		
	}
	

}
