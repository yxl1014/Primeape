package yxl.demo.Thigh;

import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> ws = new ArrayList<>();
        List<Integer> vs = new ArrayList<>();
        String[] os = reader.readLine().split(" ");
        int all = Integer.parseInt(os[0]), get = Integer.parseInt(os[1]);
        if (all < get)
            return;

        for (int i = 0; i < all; i++) {
            String[] wv = reader.readLine().split(" ");
            ws.add(Integer.valueOf(wv[0]));
            vs.add(Integer.valueOf(wv[1]));
        }
        ArrayList<Pair<Integer, Integer>> res = new ArrayList<>();
        int[] wss = new int[all];
        for (int i = 0; i < all; i++) {
            int wwss = ws.get(i) + vs.get(i) * 2;
            res.add(new Pair<>(wwss, i + 1));
            wss[i] = wwss;
        }

        Arrays.parallelSort(wss);

        for (int i = 0; i < get; i++) {
            int w = wss[all - 1 - i];
            for (Pair<Integer, Integer> p : res) {
                if (p.getKey() == w) {
                    writer.write(p.getValue() + " ");
                    res.remove(p);
                    break;
                }
            }
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}
