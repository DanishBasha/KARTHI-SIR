import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int Q = sc.nextInt();
        long V = sc.nextLong();

        TreeMap<Long, Integer> map = new TreeMap<>();

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < Q; i++) {

            int type = sc.nextInt();
            long t = sc.nextLong();

            if (type == 1) {

                long w = sc.nextLong();

                long key = w - t;

                map.put(key, map.getOrDefault(key, 0) + 1);

            } else {

                if (map.isEmpty()) {
                    ans.append(-1).append('\n');
                    continue;
                }

                long key = map.lastKey();

                int count = map.get(key);

                if (count == 1)
                    map.remove(key);
                else
                    map.put(key, count - 1);

                long charge = t + key;

                if (charge >= V)
                    charge = V;

                ans.append(charge).append('\n');
            }
        }

        System.out.print(ans);
    }
}