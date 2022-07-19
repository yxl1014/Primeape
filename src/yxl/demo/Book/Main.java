package yxl.demo.Book;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        int q = Integer.parseInt(params[2]);
        int[] position = new int[10001];            // 每本书放置的书架，0表示还未上架
        boolean[] borrowed = new boolean[10001];    // 每本书是否被借走
        boolean[] locked = new boolean[10001];      // 每层书架是否被锁
        for(int i = 0; i < q; i++){
            params = br.readLine().split(" ");
            int op = Integer.parseInt(params[0]);
            if(op == 1){
                int x = Integer.parseInt(params[1]);
                if(borrowed[x] || locked[position[x]]){
                    // 书没被还回来或书所在书架有锁都放不了
                    continue;
                }
                // 要放的架子也没被上锁才能放上去
                int y = Integer.parseInt(params[2]);
                if(!locked[y]){
                    position[x] = y;
                }
            }else if(op == 2){
                int y = Integer.parseInt(params[1]);
                locked[y] = true;
            }else if(op == 3){
                int y = Integer.parseInt(params[1]);
                locked[y] = false;
            }else if(op == 4){
                int x = Integer.parseInt(params[1]);
                if(position[x] > 0){
                    if(locked[position[x]]){
                        // 这本书所在的书架加锁了
                        System.out.println(-1);
                    }else{
                        System.out.println(position[x]);
                        borrowed[x] = true;
                        position[x] = 0;
                    }
                }else{
                    // 这本书没在书架上
                    System.out.println(-1);
                }
            }else{
                int x = Integer.parseInt(params[1]);
                if(borrowed[x]){
                    // 借过这本书才存在还书操作
                    borrowed[x] = false;
                }
            }
        }
    }
}