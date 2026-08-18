import java.util.*;
class Main{
	static ArrayList<Integer>[] graph;
	static int [] distB;
	static int [] distW;
	private static void bfs(int start , int [] dist){
		Queue <Integer> q = new LinkedList<>();
		q.add(start);
		dist[start] = 0;
		while(!q.isEmpty()){
			int curr = q.poll();
			for (int nxt : 	graph[curr]){
				if(dist[nxt] != -1){
					continue;
				}
				dist[nxt] = dist[curr]+1;
				q.add(nxt);
			}
		}
	}
	public static void main(String []args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		graph = new ArrayList[N+1];
		for(int i = 1;i<=N;i++){
			graph[i] = new ArrayList();
		}
		for (int i = 0;i<N-1;i++){
			int a = scan.nextInt();
			int b = scan.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		distB = new int[N+1];
		distW = new int[N+1];
		
		Arrays.fill(distB,-1);
		Arrays.fill(distW,-1);
		
		bfs(1,distB);
		bfs(N,distW);
		
		int black = 0;
		int white = 0;
		 
		for(int i =1;i<=N;i++){
			if(distB[i] <= distW[i]){
				black++;
			}else{
				white++;
			}
		}
		if(black > white){
			System.out.println("Fennec");
		}else{
			System.out.print("Snuke");
		}
		
	}
}