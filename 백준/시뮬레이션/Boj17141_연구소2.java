package 시뮬레이션;

import java.util.*;


public class Boj17141_연구소2 {
    static int N, M, zeroCnt = 0, ans = Integer.MAX_VALUE;
    static ArrayList<Loc> list;
    static Queue<Loc> queue;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) zeroCnt++;
                if (map[i][j] == 2) {
                    list.add(new Loc(i, j));
                    map[i][j] = 0; // 2인 곳을 0으로 만듬
                }
            }
        }
//        System.out.println(queue);
        col(0, 0, new int[M]);
        System.out.println(ans);
    }

    private static void col(int idx, int k, int[] sel) {
        boolean[][] v = new boolean[N][N];
        if(k == sel.length){
            int[][] tmp = new int[N][N];
            queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tmp[i][j] = map[i][j];
                    if(tmp[i][j] == 1){
                        tmp[i][j] = -1; // 벽
                    }
                }
            }

            for (int i = 0; i < k; i++) {
                tmp[list.get(sel[i]).r][list.get(sel[i]).c] = 2;
                v[list.get(sel[i]).r][list.get(sel[i]).c] = true;
                queue.add(new Loc(list.get(sel[i]).r, list.get(sel[i]).c, 0));
            }

//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(tmp[i]));
//            }
//            System.out.println();
            bfs(tmp, sel, v);

            return;
        }

        for (int i = idx; i < list.size(); i++) {
                sel[k] = i;
                col(i + 1, k+1, sel);

        }
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    private static void bfs(int[][] tmp, int[] sel, boolean[][] v) {
        int max = 0;
        int zero = zeroCnt;
        while(!queue.isEmpty()) {
            Loc tmpQueue = queue.poll();
            max = tmpQueue.depth;

            for (int num = 0; num < M; num++) {
                int r= tmpQueue.r;
                int c= tmpQueue.c;

                for (int d = 0; d < 4; d++) {
                    int nr = dr[d] + r;
                    int nc = dc[d] + c;

                    // 범위안에 있고 벽이 아니고 방문한 곳이 아니면
                    if (check(nr, nc) && tmp[nr][nc] != -1 && !v[nr][nc]){
                        queue.add(new Loc(nr, nc, tmpQueue.depth+1));
                        v[nr][nc] = true;
                        if(map[nr][nc] == 0) zero--;
//                        System.out.println(max);
                    }

                }
            }
        }
        System.out.println(zero);
        if(zero == 0) ans = Math.min(ans, max);
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < N;
    }

    static class Loc{
        int r, c, depth;

        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Loc(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "Loc{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
