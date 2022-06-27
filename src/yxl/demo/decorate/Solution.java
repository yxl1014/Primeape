package yxl.demo.decorate;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.*;
import java.util.Scanner;

/**
 * @author yxl
 * <p>
 * 作者：阿飞
 * 链接：https://leetcode.cn/leetbook/read/meituan/oxh202/?discussion=1PQENN
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {

    final static int MOD = 998244353;

    public static void main(String[] args) {//动态规划
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        //f[i][j]表示第i个装饰物 价格为j时的方案总数，对于i-1个装饰物 j，i装饰物价格必须是j的倍数 j*k
        //需要累加组合数
        int[][] f = new int[m + 1][n + 1];
        //初始化第一个商品的价值
        //第1个装饰物在价格确定后，方案数为
        for (int j = 1; j <= n; j++) {
            f[1][j] = 1;
        }
        //从第二个物品开始
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k * j <= n; k++) {
                    f[i][j * k] += f[i - 1][j];
                    f[i][j * k] %= MOD;
                }
            }
        }
        int res = 0;
        for (int j = 1; j <= n; j++) {
            res += f[m][j];
            res %= MOD;
        }
        System.out.printf("%d\n", res);
    }
}
