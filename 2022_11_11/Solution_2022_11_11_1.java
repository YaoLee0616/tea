import java.io.*;
import java.util.*;

class Solution_2022_11_11_1 {
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

        Deque<Integer> s = new LinkedList();
        Deque<Integer> t = new LinkedList();

        int[] R = new int[n]; Arrays.fill(R, n);
        int[] RR = new int[n]; Arrays.fill(RR, n);

        for (int i = 0; i < n; i++) {
            while (!t.isEmpty() && arr[t.peek()] < arr[i]) {
                RR[t.pop()] = i;
            }
            List<Integer> tmp = new ArrayList();
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                tmp.add(s.peek());
                R[s.pop()] = i;
            }
            for (int j = tmp.size() - 1; j >= 0; j--) {
                t.push(tmp.get(j));
            }
            s.push(i);
        }
        int[] L = new int[n]; Arrays.fill(L, -1);
        int[] LL = new int[n]; Arrays.fill(LL, -1);
        s.clear();
        t.clear();
        for (int i = n-1; i >= 0; i--) {
            while (!t.isEmpty() && arr[t.peek()] < arr[i]) {
                LL[t.pop()] = i;
            }
            List<Integer> tmp = new ArrayList();
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                tmp.add(s.peek());
                L[s.pop()] = i;
            }
            for (int j = tmp.size() - 1; j >= 0; j--) {
                t.push(tmp.get(j));
            }
            s.push(i);
        }

        long sum = 0L;
        for (int i = 0; i < n; i++) {
            sum += (long)arr[i] * ((i - L[i]) * (RR[i] - R[i]) + (R[i] - i) * (L[i] - LL[i]));
        }
        System.out.println(sum);
    }

}