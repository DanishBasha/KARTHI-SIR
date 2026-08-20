import java.util.*;
class Main {
    static int N, A, B, C;
    static int[] l;
    static int answer = Integer.MAX_VALUE;
    static void dfs(int idx, int sumA, int sumB, int sumC,
                    int countA, int countB, int countC) {
        if (idx == N) {
            if (countA == 0 || countB == 0 || countC == 0) {
                return;
            }
            int costA = Math.abs(sumA - A) + (countA - 1) * 10;
            int costB = Math.abs(sumB - B) + (countB - 1) * 10;
            int costC = Math.abs(sumC - C) + (countC - 1) * 10;
            answer = Math.min(answer, costA + costB + costC);
            return;
        }
        dfs(idx + 1, sumA, sumB, sumC,
            countA, countB, countC);
        dfs(idx + 1, sumA + l[idx], sumB, sumC,
            countA + 1, countB, countC);
        dfs(idx + 1, sumA, sumB + l[idx], sumC,
            countA, countB + 1, countC);
        dfs(idx + 1, sumA, sumB, sumC + l[idx],
            countA, countB, countC + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        l = new int[N];
        for (int i = 0; i < N; i++) {
            l[i] = sc.nextInt();
        }
        dfs(0, 0, 0, 0, 0, 0, 0);
        System.out.println(answer);
    }
}