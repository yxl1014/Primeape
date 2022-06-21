package yxl.demo.Meeting;

import java.io.*;
import java.util.*;

public class Solution {
    static final int MOD = (int) (1e9) + 7;

    static int n, k;
    static List<List<Integer>> edges;
    static int[] level;
    static boolean[] vis;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        edges = new ArrayList<>();
        level = new int[n + 1];//级别
        vis = new boolean[n + 1];//访问数组
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList());
        }
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges.get(a).add(b);
            edges.get(b).add(a);
        }
        for (int i = 1; i <= n; i++) {
            level[i] = sc.nextInt();
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(vis, false);//每一轮都初始化
            res = (res + dfs(i, i)) % MOD;
        }
        System.out.println(res);
    }


    private static long dfs(int u, int s) {//需要获取次数的下标，自己下标
        vis[u] = true;//标记已经被访问过
        long res = 1;
        for (int v : edges.get(u)) {
            if (vis[v]) continue;
            //两种情况：1.当前v的级别应该大于s的级别，但是级别差距控制在k以内
            //2.相同级别时，按从小到大开始遍历
            if (level[v] > level[s] /*当前级别要大于初始级别*/&& level[v] - level[s] <= k//级别差距控制在k以内
                    || level[v] == level[s] && v > s/*相同级别时，按从小到大开始遍历*/) {
                res = res * (1 + dfs(v, s)) % MOD;
            }
        }
        return res;
    }
}
