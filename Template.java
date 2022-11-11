import java.io.*;
import java.util.*;

class Template {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // 读取一行的数据，保存为int数组
    static int[] readLine() throws Exception {
        String s = reader.readLine();
        String[] strs = s.split(" ");
        int[] res = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            res[i] = Integer.parseInt(strs[i]);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        int n = readLine()[0]; // 读入输入的数个数n
        int[] arr = readLine(); // 读入一行数
        // 打印输出
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
        

        /***** 主代码 *****/
    }

}