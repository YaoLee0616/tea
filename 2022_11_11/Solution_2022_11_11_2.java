import java.io.*;
import java.util.*;

class Solution_2022_11_11_2 {
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

        /**
         * 用数组来存双向链表，常规的做法是用value存元素值，
         * L存左值的下标，R存右值的下标，这里考虑到是序列，
         * 并且做法要求从元素值从小到大遍历，所以这里改变策略，以元素值作为下标，存的值为编号。
         */

        int[] pos = new int[n + 1];
        int[] L = new int[n];
        int[] R = new int[n];
        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
            L[i] = i - 1;
            R[i] = i + 1;
        }
        long sum = 0L;
        for(int i=1;i<=n;i++){
            int index = pos[i];
            int l = L[index];
            int r = R[index];
            if(l > -1) sum += (long)(i) * (r - index) * (l - L[l]);
            if(r < n) sum += (long)(i) * (index - l) * (R[r] - r);
            if(r < n) L[r] = l;
            if(l > -1) R[l] = r;
        }
        System.out.println(sum);
    }

}