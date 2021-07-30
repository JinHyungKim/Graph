/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Graph{
    class Node{
        int vertexNum;
        LinkedList<Node> adjacencyList; // 노드의 인접리스트
        boolean marked;                 // 노드 방문 여부
        public Node(int n){
            this.vertexNum = n;
            this.marked = false;
            adjacencyList = new LinkedList<Node>();
        }
        @Override
        public String toString(){
            return String.valueOf(vertexNum);
        }
    }   // 노드 클래스
    
    void printAdjacencyList(){  // 인접리스트 출력 메소드
        for(int i=1;i<nodes.length;i++){
            System.out.print("Vertex's Number:("+i+")\t");
            for(Node n:nodes[i].adjacencyList){
                System.out.print(n+"\t");
            }
            System.out.println();
        }
    }
    Node[] nodes;
    Graph(int size){
        nodes = new Node[size+1];
    }
    void init(int a, int b){    // Graph초기화 메소드
        if(nodes[a] == null)
            nodes[a] = new Node(a);
        
        if(nodes[b] == null)
                nodes[b] = new Node(b);
                
        this.nodes[a].adjacencyList.add(nodes[b]);
        this.nodes[b].adjacencyList.add(nodes[a]);
    }
    @Override
    public String toString(){
        return Arrays.toString(nodes);
    }
}
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
	    Graph graph = new Graph(N);
	    for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine(), " ");
	        graph.init(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	    }
		System.out.println(graph);  // 그래프의 노드 출력
		graph.printAdjacencyList();
		
	}
}
