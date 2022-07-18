package yxl.demo.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yxl
 * @Date: 2022/7/18 16:03
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int M, N, Q;
        String[] s = reader.readLine().split(" ");
        M = Integer.parseInt(s[0]);//书编号
        N = Integer.parseInt(s[1]);//行编号
        Q = Integer.parseInt(s[2]);//操作数

        //书架行号 == 是否上锁
        Map<Integer, Boolean> locks = new HashMap<>();

        //书本号 == 书架行号
        Map<Integer, Integer> book = new HashMap<>();

        //书本号 == 在谁手上   1=小美  0=小团
        Map<Integer, Integer> owns = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            locks.put(i, false);
        }
        for (int i = 1; i <= M; i++) {
            owns.put(i, 1);
        }

        for (int i = 0; i < Q; i++) {
            String[] ops = reader.readLine().split(" ");
            switch (ops[0]) {
                case "1": {//放书
                    int x = Integer.parseInt(ops[1]);//书本的编号
                    int y = Integer.parseInt(ops[2]);//行号

                    if (locks.get(y)) {//若书架上锁，则无效操作
                        break;
                    }

                    if (book.containsKey(x)) {//若这本是书在书架上
                        if (locks.get(book.get(x))) {//且本来就上锁
                            break;
                        }
                    }

                    if (owns.containsKey(x) && owns.get(x) == 0) {//若这本书在小团手上
                        break;
                    }

                    book.put(x, y);
                    owns.put(x, 1);

                    break;
                }
                case "2": {
                    int y = Integer.parseInt(ops[1]);//行号
                    locks.put(y, true);
                    break;
                }
                case "3": {
                    int y = Integer.parseInt(ops[1]);//行号
                    locks.put(y, false);
                    break;
                }
                case "4": {
                    int x = Integer.parseInt(ops[1]);//书本的编号
                    if (!book.containsKey(x)) {//若这本书没有放进去
                        System.out.println(-1);
                        break;
                    }
                    int y = book.get(x);//行号
                    if (owns.get(x) == 0) {//若这本书本来就在小团手上
                        System.out.println(-1);
                        break;
                    }
                    if (locks.get(y)) {//若这行书架上锁了
                        System.out.println(-1);
                        break;
                    }

                    System.out.println(y);
                    owns.put(x, 0);

                    break;
                }
                case "5": {
                    int x = Integer.parseInt(ops[1]);//书本的编号
                    if (owns.get(x) == 1) {//若这本书本来不在小团手上
                        break;
                    }
                    owns.put(x, 1);
                    break;
                }
            }
        }
        reader.close();
    }
}
