package yxl.demo.NoWayOut;

import java.io.*;
import java.util.*;
/**
 *
 作者：Pein
 链接：https://leetcode.cn/leetbook/read/meituan/ohfw76/?discussion=FmTQ7i
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int x = Integer.parseInt(params[1]);
        int y = Integer.parseInt(params[2]);
        x--;
        y--;
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n - 1; i++){
            params = br.readLine().split(" ");
            int u = Integer.parseInt(params[0]) - 1;
            int v = Integer.parseInt(params[1]) - 1;
            if(graph.containsKey(u)){
                graph.get(u).add(v);
            }else{
                LinkedList<Integer> neighbors = new LinkedList<>();
                neighbors.add(v);
                graph.put(u, neighbors);
            }
            if(graph.containsKey(v)){
                graph.get(v).add(u);
            }else{
                LinkedList<Integer> neighbors = new LinkedList<>();
                neighbors.add(u);
                graph.put(v, neighbors);
            }
        }
        if(x == y){
            System.out.println(0);
        }else{
            int[] disX = new int[n];
            int[] disY = new int[n];
            bfs(graph, x, disX);     // 求小美到所有节点的时间花费
            bfs(graph, y, disY);     // 求小团到所有节点的时间花费
            int maxTime = 0;
            for(int i = 0; i < n; i++){
                if(disX[i] > disY[i]){
                    // 小美到i点的时间更长，小团才会往i点跑
                    maxTime = Math.max(maxTime, disX[i]);
                }
            }
            System.out.println(maxTime);
        }
    }

    private static void bfs(HashMap<Integer, LinkedList<Integer>> graph, int start, int[] dis) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[dis.length];
        while(!queue.isEmpty()){
            int cur = queue.poll();
            visited[cur] = true;
            if(graph.containsKey(cur)){
                Iterator<Integer> neighbors = graph.get(cur).iterator();
                while(neighbors.hasNext()){
                    int next = neighbors.next();
                    if(!visited[next]){
                        dis[next] = dis[cur] + 1;
                        queue.offer(next);
                    }
                }
            }
        }
    }

}
