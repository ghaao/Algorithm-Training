
import java.util.Scanner;
import java.util.Stack;

public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int max = 0, mod = 0;
		int k = 0;
		
		int N = keyboard.nextInt();
		int num[] = new int[N]; 
		
		Stack[] s = new Stack[10];
		
		for (int j=0; j<s.length; j++) 
	          s[j] = new Stack();

		for(int i = 0; i < N; ++i){
			num[i] = keyboard.nextInt();
			
			if(0 < num[i])
				max = num[i];
		}
			
		while(max > mod ){
			mod += 10;
			k++;
			
			for(int j = 0; j < N; j++)
				s[num[j] % mod / k].push(num[j]);
			
			int cnt = 0;
			for(int j = 0; j < 10; j++){
				while(!s[j].empty()){
					num[cnt++] = (int)s[j].pop();
				}
			}
		}
		
		for(int c = 0; c<N; c++)
			System.out.println(num[c]);
	}

}
