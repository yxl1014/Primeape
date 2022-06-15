package yxl.demo.Cargo;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int size =Integer.parseInt(reader.readLine());
        String[] ws = reader.readLine().split(" ");
        String[] is = reader.readLine().split(" ");
        int[] w = new int[size];
        int[] i9n = new int[size];
        int[] ok =  new int[size];
        for (int i = 0; i < size; i++) {
            w[i] = Integer.parseInt(ws[i]);
            i9n[i] = Integer.parseInt(is[i]);
            ok[i] = 1;
        }

        for (int i = 0; i < size; i++) {
            int[] sum = new int[size];
            for (int j = 0; j < size; j++)
                sum[j] = -1;
            int s = 0;

            ok[i9n[i] - 1] = 0;

            int j = 0;
            for (; j < size; j++) {
                if (ok[j] == 0) {
                    sum[j] = s;
                    s = 0;
                } else {
                    s += w[j];
                }
            }
            sum[j - 1] = s;

            int flag = 0;
            for (int z = 0; z < size; z++) {
                if (flag < sum[z])
                    flag = sum[z];
            }

            writer.write(flag + "\n");
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}
