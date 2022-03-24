package project;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BaekJoon_1260 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static ArrayList<Integer> output = new ArrayList<Integer>();
    static Boolean[] status;
    public static void baekJoon_1260() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        status = new Boolean[N];
        
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<Integer>());
            status[i] = false;
        }
        
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        output.add(V);
        dfs(V - 1, 1, N);
    }
    public static void dfs(int start, int depth, int N) {
        
        if (depth == N) {
            System.out.println(output);
            output.remove(output.size() - 1);
            return;
        }
        
        status[start] = true;
        for (int i : list.get(start)) {
            
            if (status[i] != true) {
                output.add(i + 1);
                dfs(i, depth + 1, N);
            }
        }
        output.remove(output.size() - 1);
        status[start] = false;
    }
}
