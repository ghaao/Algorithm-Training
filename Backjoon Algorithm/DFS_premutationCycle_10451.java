import java.util.Scanner;

public class DFS_premutationCycle_10451 {
	static int map[] = new int[1001], isvisit[] = new int[1001], result[];
	static int cnt = 0;
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		result = new int[k];
		
		for(int i = 0; i < k; i++){
			int v = sc.nextInt();
			cnt = 0;
			
			for(int j = 1; j<= v; j++){
				map[j] = 0;
				isvisit[j] = 0;
			} 			
			for(int j = 1; j <= v; j++)
				map[j] = sc.nextInt(); 
			
			for(int j = 1; j <= v; j++)
				if(isvisit[j] == 0)
					dfs(j);
			
			result[i] = cnt;
		}	
		for(int i = 0 ; i < k; i++)
			System.out.println(result[i]);
	}
	
	public static void dfs(int v){
		isvisit[v] = 1; 
		if(isvisit[map[v]] == 1){
			cnt++; 
			return;
		}
		
		if(map[v] != 0 && isvisit[map[v]] ==0)
			dfs(map[v]);
	}
}
