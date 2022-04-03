package project;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BaekJoon_11724 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Boolean[] visited;
    public static void baekJoon_11724() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new Boolean[N + 1];
        int result = 0;
        
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Integer>());
            visited[i] = false;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }
        
        System.out.println(result);
    }
    
    public static void dfs(int start) {
        visited[start] = true;
        for (int i : graph.get(start)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
