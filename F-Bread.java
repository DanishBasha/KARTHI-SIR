import java.util.*;
class Main {
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		long L = scan.nextLong();
		PriorityQueue<Long> pq = new PriorityQueue<>();
		long sum = 0L;
		for(int idx = 0;idx<N;idx++){
			long num = scan.nextLong();
			pq.add(num);
			sum = sum+num;
		}
		if (sum < L){
			pq.add(L-sum);
		}
		long ans = 0L;
		while(pq.size()>1){
			long merged = pq.poll() + pq.poll();
			pq.add(merged);
			ans = ans + merged;
		}
		System.out.println(ans);
		
	}
}