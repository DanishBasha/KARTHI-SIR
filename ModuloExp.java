import java.util.*;
public class ModuloExp{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		String str = scan.nextLine();
		for (int i = 0;i<num;i++){
			System.out.print(str.charAt(i%str.length()));	
			}
		}
	}
