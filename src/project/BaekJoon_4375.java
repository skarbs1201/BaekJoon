package project;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_4375 {
    public static void baekJoon_4375() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            long x = 1;
            int count = 1;

            while(true) {
                System.out.println(x);
                if(x % n == 0) {
                    System.out.println(count);
                    break;
                }
                x = (x * 10) + 1;
                count++;
            }
        }

    }
}
