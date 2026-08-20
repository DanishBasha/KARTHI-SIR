import java.util.*;
public class LazyFaith{
	public static int lowerbound(long point,long[] arr){
		int low=0;
		int high=arr.length;
		while(low<high){
			int mid=low + (high - low)/2;
			if(arr[mid]>= point){
				high=mid;
			}else {
				low=mid+1;
			}
		}
		return low;
		
	}
	public static int left(long point,long[] arr){
		 if (arr.length == 0 || arr[0] > point) {
        return -1;
    }
		int low=0;
		int high=arr.length-1;
		while(low<high){
			int mid=(low+high+1)/2;
			if(arr[mid]<=point){
				low=mid;
			}else{
				high=mid-1;
			}
		}
		return low;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int A=sc.nextInt();
		int B=sc.nextInt();
		int Q=sc.nextInt();
		long[] s=new long[A];
		long[]t=new long[B];
		for(int i=0;i<A;i++){
			s[i]=sc.nextLong();
		}
		for(int i=0;i<B;i++){
			t[i]=sc.nextLong();
		}
		Arrays.sort(t);
		Arrays.sort(s);
		while(Q-->0){
			long point=sc.nextLong();
			long ans=Long.MAX_VALUE;
			int sr=lowerbound(point,s);
			int tr=lowerbound(point,t);
			int sl=left(point,s);
			int tl=left(point,t);
			
			if(sr<A && tr<B && s[sr]>=point && t[tr]>=point){
				long dis=Math.max(s[sr],t[tr]) -point;
				ans=Math.min(dis,ans);
			}
			
			if(tl!=-1 && sl!=-1 && s[sl]<=point && t[tl]<=point){
				long dis=point- Math.min(s[sl],t[tl]);
				ans=Math.min(dis,ans);
			}
			if( sr<A && tl!=-1 && s[sr]>=point && t[tl]<=point){
				long dis=Math.min((point-t[tl]),(s[sr]-point)) +(s[sr]-t[tl]);
				ans=Math.min(dis,ans);
			}
			if( tr<B && sl!=-1 && s[sl]<=point && t[tr]>=point){
				long dis= (t[tr]-s[sl]) + Math.min((point-s[sl]),(t[tr]-point));
				ans=Math.min(dis,ans);
			}
			
			
			
			System.out.println(ans);
		}
	}
}