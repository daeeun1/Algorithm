 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Vertex implements Comparable<Vertex>{
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken());
		ArrayList<Vertex>[] adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[from].add(new Vertex(to, weight));
		}

		// 프림 알고리즘에 필요한 자료구죠
		int[] minEdge = new int[V + 1]; // 각 정점 입장에서 신장트리에 포함된 정점과의 간선 비용중 최소비용
		boolean[] visited = new boolean[V + 1]; // 신장트리에 포함여부

		Arrays.fill(minEdge, Integer.MAX_VALUE); // 최소값 관리하기 위한 큰 값 세팅

		// 1. 임의의 시작점 처리, 0 변정점을 신장트리의 구성의 시작점
		minEdge[start] = 0;
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
		pQueue.offer(new Vertex(start, minEdge[start]));

		while (!pQueue.isEmpty()) {
			Vertex minVertex = pQueue.poll();
			if(visited[minVertex.no]) continue; 
			visited[minVertex.no] = true;
			// step3 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않는 정점들의 기존 최소비용과 비교해서 갱신
			// 신장트리에 새롭게 추가되는 정점의 모든 인접정점 들여다보며 처리
			for (Vertex temp : adjList[minVertex.no]) {
				if (minEdge[temp.no] > temp.weight + minEdge[minVertex.no]) {
					minEdge[temp.no] = temp.weight + minEdge[minVertex.no];
					pQueue.offer(new Vertex(temp.no, minEdge[temp.no]));
				}

			}
//			System.out.println(Arrays.toString(minEdge));
		}
		for (int i = 1; i <= V; i++) {
			if(minEdge[i] != Integer.MAX_VALUE) System.out.println(minEdge[i]);
			else {
				System.out.println("INF");
			}
		}
	}

}
