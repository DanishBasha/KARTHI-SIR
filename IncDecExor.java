import java.util.*;
public class IncDecExor{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
			int N=sc.nextInt();
			int Q=sc.nextInt();
			List<Integer> pos=new ArrayList<>();
			int[] arr=new int[N+1];
			int ans=0;
			while(Q-->0){
				int tas=sc.nextInt();
				if(tas==1){
					int po=sc.nextInt();
					ans^=arr[po];
					arr[po]++;
					ans^=arr[po];
					if(arr[po]==1){
						pos.add(po);
					}
				}else{
					List<Integer>newpos=new ArrayList<>();
					for(int po:pos){
						ans^=arr[po];
						arr[po]--;
						if(arr[po]>0){
							ans^=arr[po];
							newpos.add(po);
						}
					}
					pos=newpos;
				}
				System.out.println(ans);
			
		}
	}
}