package yxl.demo.Word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: yxl
 * @Date: 2022/7/19 11:38
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        char[] c = reader.readLine().toCharArray();

        int res = 0, num = 0;

        for (char cc : c) {
            if (cc == 'E') num++;
            if (cc == 'F') num--;
            res = Math.max(res, num);
            num = Math.max(num, 0);
        }

        System.out.println(res);

        reader.close();
    }
}
