package yxl.demo.tacit_agreement;

import java.io.*;

/**
 * @author yxl
 *
作者：Pein
链接：https://leetcode.cn/leetbook/read/meituan/oxxpwc/?discussion=iSZIfw
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = reader.readLine().split(" ");
        int m= Integer.parseInt(t[0]);
        int n= Integer.parseInt(t[1]);
        t = reader.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(t[i]);
        }
        int count = 0;
        //遍历所有r的值
        for(int r = m; r >= 1; r--){
            //二分查找lb表示从左开始，ub表示从右开始
            int lb = 1, ub = r;
            int curCnt = 0;
            while(lb <= ub){
                //二分查找尝试获取l的值
                int l = lb + ((ub - lb) >> 1);
                //若符合条件则找到l的最大值
                if(isIncrease(arr, l, r)){
                    curCnt = l;
                    lb = l + 1;
                }else{
                    ub = l - 1;
                }
            }
            count += curCnt;
        }
        reader.close();
        System.out.println(count);
    }

    private static boolean isIncrease(int[] arr, int l, int r) {
        int prev = 0;
        for(int i = 0; i < arr.length; i++){
            //若l小于等于x或者r大于等于x则不符合条件继续下一个数
            if(l <= arr[i] && arr[i] <= r){
                continue;
            }else{
                //判断是否为单调不下降子序列
                if(arr[i] >= prev){
                    prev = arr[i];
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
