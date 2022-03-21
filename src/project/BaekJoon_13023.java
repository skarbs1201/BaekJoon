package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BaekJoon_13023 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static boolean status = false;
    public static void baekJoon_13023() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited =  new boolean[N];
        
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
        }
        System.out.println(status ? "1" : "0");
        br.close();
    }
    
    public static void dfs(int i, int depth) {
        for (int k = 0; k < 8; k++) {
            System.out.print(visited[k] + " ");
        }
        System.out.println("");
        if (depth == 5) {
            status = true;
            return;
        }
        
        visited[i] = true;
        for (int j : list.get(i)) {
            if (visited[j] != true) {
                dfs(j, depth + 1);
            }
        }
        visited[i] = false;
    }
}
