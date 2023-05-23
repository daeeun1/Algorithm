package bfs;

import java.util.*;
 
public class Boj16236_아기상어2 {
    
    static int n;
    static int[][] board;
    static int dx[] = {-1, 0, 1, 0}; //위 왼 아래 오
    static int dy[] = {0, 1, 0, -1};
    static ArrayList<Node> fishes;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        n = scan.nextInt(); 
        board = new int[n][n];
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = scan.nextInt();
                if(board[i][j] == 9){
                    q.add(new Node(i, j, 0));
                    board[i][j] = 0;
                }
            }
        }
        
        int eat = 0;
        int time = 0; 
        int age = 2;
        while(true){
            LinkedList<Node> fish = new LinkedList<>();
            int[][] dist = new int[n][n];
 
            while (!q.isEmpty()) {
                Node tmp = q.poll();
                
                for(int i=0; i<4; i++){
                    int nr = tmp.x + dx[i];
                    int nc = tmp.y + dy[i];
                 
                    if(nr >= 0 && nc >= 0 && nr < n && nc < n && dist[nr][nc]==0 && board[nr][nc] <= age){
                        dist[nr][nc] = dist[tmp.x][tmp.y] + 1;
                        q.add(new Node(nr, nc, dist[nr][nc]));
                        if(1 <= board[nr][nc] && board[nr][nc] <= 6 && board[nr][nc] < age) fish.add(new Node(nr, nc, dist[nr][nc]));
                    }
                }
            }
            System.out.println(fish.toString());
            if(fish.size() == 0){
                System.out.println(time);
                return;
            }
 
            Node currentFish = fish.get(0);
            for(int i = 1; i < fish.size(); i++){
                if(currentFish.dist > fish.get(i).dist) {
                    currentFish = fish.get(i);
                }
                else if(currentFish.dist == fish.get(i).dist) {
                    if(currentFish.x > fish.get(i).x) currentFish = fish.get(i);
                    else if(currentFish.x == fish.get(i).x){
                        if(currentFish.y > fish.get(i).y) currentFish = fish.get(i);   
                    }
                }   
            }
             
            time += currentFish.dist;
            eat++;
            board[currentFish.x][currentFish.y] = 0;
            if(eat == age) {
                age++;
                eat = 0;
            }
            q.add(new Node(currentFish.x, currentFish.y, 0));
        }
    }
    
    public static class Node {
        int x;
        int y;
        int dist;
        
        public Node(int x, int y, int dist) {
            super();
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", dist=" + dist + "]";
		}
    }
}    