import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static class Node{
		int vertex, weight;
		Node next;
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		Node[] adjList = new Node[N+1];
		
		for (int i = 0; i < M+1; i++) {
			int from = sc.nextInt();
			int to =sc.nextInt();
			int weight = sc.nextInt();
			
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		
		int[] minEdge = new int[N+1];
		int[] maxEdge = new int[N+1];
		boolean[] minVisited = new boolean[N+1];
		boolean[] maxVisited = new boolean[N+1];
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		Arrays.fill(maxEdge, Integer.MIN_VALUE);
		
		minEdge[0] = 0;
		maxEdge[0] = 0;
		int minResult = 0;
		int maxResult = 0;
		for (int c = 0; c <= N; c++) {
			
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			int max = -1;
			int maxVertex = -1;
			for (int i = 0; i <= N; i++) {
				if(!minVisited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
				if(!maxVisited[i] && max < maxEdge[i]) {
					max = maxEdge[i];
					maxVertex = i;
				}
			}
			
			minVisited[minVertex] = true;
			minResult += min;
			maxVisited[maxVertex] = true;
			maxResult += max;

			for (Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
				if(!minVisited[temp.vertex] && minEdge[temp.vertex] > temp.weight) // 인접리스트로 돌려서 인접 체크는 할 필요 없다.
				{
					minEdge[temp.vertex] = temp.weight;
				}
			}
			for (Node temp = adjList[maxVertex]; temp != null; temp = temp.next) {
				if(!maxVisited[temp.vertex] && maxEdge[temp.vertex] < temp.weight) // 인접리스트로 돌려서 인접 체크는 할 필요 없다.
				{
					maxEdge[temp.vertex] = temp.weight;
				}
			}
		}
		
//		System.out.println(Arrays.toString(maxEdge));
//		System.out.println(Arrays.toString(minEdge));
		System.out.println( (N-minResult)*(N-minResult) - (N-maxResult) * (N-maxResult));
	}

}
