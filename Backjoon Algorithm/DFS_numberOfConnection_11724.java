import java.util.Scanner;

public class DFS_numberOfConnection_11724 {

	static int map[][];
	static int isVisit[];
	static int cnt = 0, n ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int m = sc.nextInt();
		
		map = new int[n+1][n+1];
		isVisit = new int[n+1];
		
	
		for(int i = 0 ; i < m; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				if(map[i][j] == 1 && isVisit[j] == 0)
					dfs(++cnt, i);
				
		for(int i = 1; i <=n; i++)
			if(isVisit[i] == 0)
				cnt++;
			
		System.out.println(cnt);
	}
	
	public static void dfs(int cnt, int u){
		isVisit[u] = 1;
		
		for(int i = 1; i <= n; i++)
			if(map[u][i] == 1 && isVisit[i] == 0)
				dfs(cnt, i);
		
	}

}
