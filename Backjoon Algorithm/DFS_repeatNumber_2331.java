import java.util.Scanner;

public class DFS_repeatNumber_2331 {
	static int check[] = new int[1000000];
	static int result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int P = sc.nextInt(); 
		
		checkLevel(A, P, 1);
		
		System.out.println(result);
	}

	public static void checkLevel(int A, int P, int cnt){
		if(check[A] != 0){
			result =  check[A]-1;
			return;
		}
		
		check[A] = cnt;
		int B = next(A, P);
		checkLevel(B,P,++cnt);
	}
	
	public static int next(int A, int P){
		int ans = 0;
		while(A > 0){
			ans += multi(A%10, P);
			A /= 10;
		}
		return ans;
	}
	
	public static int multi(int A, int P){
		int ans = 1;
		for(int i = 0; i < P; i++)
			ans*=A;

		return ans;
	}
}
