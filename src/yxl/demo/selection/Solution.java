package yxl.demo.selection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        List<List<Integer>> list = new ArrayList<>();
        boolean[] isExist = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] ss = reader.readLine().split(" ");
            List<Integer> lists = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                lists.add(Integer.valueOf(ss[j]));
            }
            list.add(lists);
            isExist[i] = false;
        }

        for (int i = 0; i < n; i++) {
            List<Integer> is = list.get(i);
            for (Integer ni : is) {
                if (!isExist[ni - 1]) {
                    isExist[ni - 1] = true;
                    writer.write((ni) + " ");
                    break;
                }
            }
        }

        writer.write("\n");
        writer.flush();
        reader.close();
        writer.close();
    }
}
