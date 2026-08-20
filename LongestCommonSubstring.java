import java.util.*;
class Main{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String s1 = new String(scan.nextLine());
		String s2 = new String(scan.nextLine());
		int len1 = s1.length();
		int len2 = s2.length();
		int [][] dp = new int[len1+1][len2+1];
		int max = 0;
		for (int row =1;row<=len1;row++){
			for(int col =1;col<=len2;col++){
				if(s1.charAt(row-1) == s2.charAt(col-1)){
					dp[row][col] = dp[row-1][col-1]+1;
				}
				max = Math.max(max,dp[row][col]);
			}
		}
		System.out.print(max);
		
	}
}