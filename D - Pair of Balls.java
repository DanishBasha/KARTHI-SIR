import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] cylinders = new int[M][];
        int[] pos = new int[M];

        int[] first = new int[N + 1];
        int[] second = new int[N + 1];
        int[] count = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int k = sc.nextInt();
            cylinders[i] = new int[k];

            for (int j = 0; j < k; j++) {
                cylinders[i][j] = sc.nextInt();
            }

            int color = cylinders[i][0];

            if (count[color] == 0)
                first[color] = i;
            else
                second[color] = i;

            count[color]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int color = 1; color <= N; color++) {
            if (count[color] == 2)
                queue.offer(color);
        }

        int removed = 0;

        while (!queue.isEmpty()) {
            int color = queue.poll();

            int c1 = first[color];
            int c2 = second[color];

            count[color] = 0;

            pos[c1]++;
            pos[c2]++;
            removed += 2;

            if (pos[c1] < cylinders[c1].length) {
                int next = cylinders[c1][pos[c1]];

                if (count[next] == 0)
                    first[next] = c1;
                else
                    second[next] = c1;

                count[next]++;

                if (count[next] == 2)
                    queue.offer(next);
            }

            if (pos[c2] < cylinders[c2].length) {
                int next = cylinders[c2][pos[c2]];

                if (count[next] == 0)
                    first[next] = c2;
                else
                    second[next] = c2;

                count[next]++;

                if (count[next] == 2)
                    queue.offer(next);
            }
        }

        System.out.println(removed == 2 * N ? "Yes" : "No");
    }
}