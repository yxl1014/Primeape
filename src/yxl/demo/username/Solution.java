package yxl.demo.username;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        while (t-- != 0) {
            char[] s = reader.readLine().toCharArray();

            int n = s.length;
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                char c = s[i];

                boolean isLetter = (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
                boolean isDigit = c >= '0' && c <= '9';

                if (i == 0 && !isLetter) break;
                if (i != 0 && isDigit) flag = true;
                if (i != 0 && !isLetter && !isDigit) {
                    flag = false;
                    break;
                }
            }

            if (flag) writer.write("Accept\n");
            else writer.write("Wrong\n");
        }

        writer.flush();
        reader.close();
        writer.close();
    }
}
/*import java.io.*;

public class Solution {
    private int len;
    private String[] names;

    private String[] over;

    public void init() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.len = Integer.parseInt(reader.readLine());
        this.names = new String[len];
        this.over = new String[len];
        for (int i = 0; i < this.len; i++) {
            this.names[i] = reader.readLine();
        }
    }

    public void check() {
        for (int i = 0; i < len; i++)
            this.over[i] = checkName(this.names[i]);
    }

    public void printf() throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : this.over) {
            writer.write(s+"\n");
        }
    }

    private String checkName(String name) {
        char[] chars = name.toCharArray();
        if (chars[0] < 65 || chars[0] > 90)
            return "Wrong";
        boolean a = false, b = false, c = false;

        for (char c1 : chars) {
            switch (getInt(c1)) {
                case -1:
                    return "Wrong";
                case 1:
                    a = true;
                    break;
                case 2:
                    b = true;
                    break;
                case 3:
                    c = true;
            }
        }
        if (a && b && c)
            return "Accept";
        else
            return "Wrong";
    }

    private int getInt(char c) {
        if (c >= 65 && c <= 90)
            return 1;
        if (c >= 97 && c <= 122)
            return 2;
        if (c >= 48 && c <= 57)
            return 3;
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Solution username = new Solution();
        username.init();
        username.check();
        username.printf();
    }
}*/

