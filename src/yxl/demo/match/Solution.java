package yxl.demo.match;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: yxl
 * @Date: 2022/7/11 11:12
 * 作者：sp1998
 * 链接：https://leetcode.cn/leetbook/read/meituan/ox5evi/?discussion=meaPhY
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int a, b, c, d, e, f, g;
        String[] s = reader.readLine().split(" ");
        a = Integer.parseInt(s[0]);//领带
        b = Integer.parseInt(s[1]);//裤子
        c = Integer.parseInt(s[2]);//帽子
        d = Integer.parseInt(s[3]);//衬衫
        e = Integer.parseInt(s[4]);//衬衫+领带
        f = Integer.parseInt(s[5]);//衬衫+裤子
        g = Integer.parseInt(s[6]);//衬衫+帽子

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{e, a});
        list.add(new int[]{f, b});
        list.add(new int[]{g, c});

        //学到了
        list.sort(Comparator.comparingInt(o -> o[0]));

        long res = 0;
        for (int i = 2; i >= 0; i--) {
            long cnt = list.get(i)[0], num = Math.min(d, list.get(i)[1]);
            res += cnt * num;
            d -= num;
        }

        writer.write(res + "\n");

        writer.flush();
        reader.close();
        writer.close();
    }
}
