package project;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_2667 {
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int result;
    static int[] x = {0, 0, -1, 1};
    static int[] y = {-1, 1, 0, 0};
    static int N;
    
    public static void baekJoon_2667() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        String input;
        for (int i = 0; i < N; i++) {
            input = bf.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
                visited[i][j] = false;
            }
        }
    
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visited[i][j] == false) {
                    
                    System.out.println(map[i][j] + " " + visited[i][j]);
                    
                    result = 1;
                    count++;
                    dfs(i, j);
                    System.out.println(count);
                    for (int q = 0; q < N; q++) {
                        for (int w = 0; w < N ; w++) {
                            System.out.print(visited[q][w]);
                            
                        }
                        System.out.println("  ");
                    }
                }
            }
        }
    }
    
    public static void dfs(int i, int j) {
        visited[i][j] = true;
        System.out.println(visited[i][j]);
        result++;
        
        for (int k = 0; k < x.length; k++) {
            int ix = i + x[k];
            int iy = i + y[k];
            
            if (ix >= 0 && ix < N && iy >= 0 && iy < N) {
                if (map[ix][iy] == 1 && visited[ix][iy] == false) {
                    dfs(ix, iy);   
                }
            }
        }
    }
}
