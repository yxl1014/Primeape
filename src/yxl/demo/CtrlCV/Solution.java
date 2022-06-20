package yxl.demo.CtrlCV;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(reader.readLine());

        int[] A = new int[size];
        int[] B = new int[size];

        String[] datas = reader.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            A[i] = Integer.parseInt(datas[i]);
            B[i] = -1;
        }

        int doNum = Integer.parseInt(reader.readLine());

        for (int i = 0; i < doNum; i++) {
            String[] ss = reader.readLine().split(" ");
            switch (Integer.parseInt(ss[0])) {
                case 1: {
                    int len = Integer.parseInt(ss[1]);
                    int ai = Integer.parseInt(ss[2]) - 1;
                    int bi = Integer.parseInt(ss[3]) - 1;

                    for (int j = 0; ai < size && bi < size && j < len; j++, ai++, bi++) {
                        B[bi] = A[ai];
                    }

                    break;
                }
                case 2:
                    int bi = Integer.parseInt(ss[1]) - 1;
                    writer.write(B[bi] + "\n");
            }
        }

        writer.flush();
        reader.close();
        writer.close();
    }
}