package project;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BaekJoon_1707 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] group;
    static String result = "YES";
    public static void baekJoon_1707() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            graph = new ArrayList<>();
            st = new StringTokenizer(bf.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            group = new int[V + 1];
            
            for (int j = 0; j < V + 1; j++) {
                graph.add(new ArrayList<>());
                group[j] = 0;
            }
            
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            
            for (int j = 1; j < V + 1; j++) {
                if (group[j] == 0) {
                    dfs(j, 1);
                }
            }
            System.out.println(result);
        }
    }
    
    public static void dfs(int start, int team) {
        group[start] = team;
        for (int i : graph.get(start)) {
            if (group[i] == 0) {
                dfs(i, -team);
            }
            else if (group[start] == group[i]) {
                result = "NO";
            }
        }
    }
}
