package yxl.demo.code;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int len = Integer.parseInt(reader.readLine());
        String str = reader.readLine();
        char[] chars = str.toCharArray();
        int l = 0, r = len - 1;
        for (; l < len; l++) {//头部出现过'M'
            if (chars[l] == 'M') {
                l++;
                break;
            }
        }
        for (; r >= 0; r--) {//尾部出现过'T'
            if (chars[r] == 'T') {
                r--;
                break;
            }
        }
        while (!((chars[l] == 'T') && (chars[r] == 'M'))) {
            if (chars[l] != 'T') l++;
            if (chars[r] != 'M') r--;
        }
        writer.write(str.substring(l + 1, r));

        writer.flush();
        writer.close();
        reader.close();
    }
}
