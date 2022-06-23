package yxl.demo.Thigh;
import java.io.*;
import java.util.*;

/**
 *
 作者：sp1998
 链接：https://leetcode.cn/leetbook/read/meituan/oh1sq3/?discussion=pKvXdT
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FromLeetCode {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);

        Queue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o2[1], o1[1]);
            return Integer.compare(o1[0], o2[0]);
        });
        List<int[]> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            strings = reader.readLine().split(" ");
            int v = Integer.parseInt(strings[0]);
            int w = Integer.parseInt(strings[1]);

            int t = v + w * 2;
            heap.offer(new int[]{t, i});

            if (heap.size() > m) heap.poll();
        }

        while (!heap.isEmpty()) res.add(heap.poll());

        res.sort(Comparator.comparingInt(o -> o[1]));

        for (int[] x : res) writer.write(x[1] + " ");

        writer.flush();
        reader.close();
        writer.close();
    }
}

