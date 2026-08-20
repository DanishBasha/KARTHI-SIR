import java.util.*;
class Main{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		HashMap<Long, Long> map = new HashMap<>();
		map.put(0L,1L);
		long prefix = 0L;
		long answer = 0L;
		for (int i = 0;i<N;i++){
			long a = scan.nextLong();
			prefix += a;
			long rem = prefix%M;
			long count = map.getOrDefault(rem,0L);
			answer += count;
			map.put(rem,count+1);
		}
		System.out.print(answer);
	}
}