import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int Q=sc.nextInt();
		
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		Queue<Integer> q=new LinkedList<>();
		while(Q-->0){
			int c=sc.nextInt();
			if(c==1){
				int x=sc.nextInt();
				q.offer(x);
			}
			else if(c==2){
				if(!pq.isEmpty()){
					System.out.println(pq.poll());
				}else {
					System.out.println(q.poll());
				}
			}else{
				while(!q.isEmpty()){
					pq.offer(q.poll());
				}
				
			}
		}
		
	}
}