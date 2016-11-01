import java.util.Scanner;

public class DFS_TermProject_9466 {
	static int map[] = new int[1000001], isvisit[] = new int[1000001], result[];
	static int last;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		result = new int[T];
		
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			last = 0;

			for (int j = 1; j <= n; j++)
				map[j] = sc.nextInt();

			for (int j = 1; j <= n; j++) 
				dfs(j, j, 1);
			
			System.out.println(n- last);
		}
	}

	public static void dfs(int s, int v, int num) {
		isvisit[v] = 1;

		if (isvisit[map[v]] == 1 && s == map[v]) {
			last += num;
			return;
		}else if(isvisit[map[v]] == 1 && s != map[v])
			return;
		
		if (isvisit[map[v]] == 0)
			dfs(s, map[v], ++num);
	}

}
