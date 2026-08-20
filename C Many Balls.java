import java.util.*;
class Main{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		long N = scan.nextLong();
		StringBuilder sb = new StringBuilder();
		while(N>0){
			if(N%2 == 0){
				sb.append("B");
				N = N/2L;
			}else{
				sb.append("A");
				N--;
			}
		}
		System.out.println(sb.reverse().toString());
		System.out.print(Integer.MIN_VALUE);
	}
}