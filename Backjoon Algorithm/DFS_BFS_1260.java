
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS_BFS_1260 {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		int S = keyboard.nextInt();
		int N = keyboard.nextInt();
		int M = keyboard.nextInt();

		int num[][] = new int[S + 1][S + 1];
		int isvisit[] = new int[S + 1];

		for (int i = 1; i <= N; i++) {
			int x = keyboard.nextInt();
			int y = keyboard.nextInt();

			num[x][y] = 1;
			num[y][x] = 1;
		}
		System.out.print(M + " ");
		DFS(num, isvisit, M);

		System.out.println();
		for (int i = 1; i <= S; i++)
			isvisit[i] = 0;

		BFS(num, isvisit, M);
	}

	public static void DFS(int[][] num, int[] isvisit, int M) {
		isvisit[M] = 1;

		for (int i = 1; i < isvisit.length; i++) {
			if (num[M][i] == 1 && isvisit[i] == 0) {
				System.out.print(i + " ");
				DFS(num, isvisit, i);
			}
		}
	}

	public static void BFS(int[][] num, int[] isvisit, int M) {
		Queue<Integer> qX = new LinkedList<Integer>();

		qX.add(M);
		isvisit[M] = 1;

		while (!qX.isEmpty()) {
			int current = qX.poll();
			System.out.print(current + " ");

			for (int i = 1; i < isvisit.length; i++) {
				if (num[current][i] == 1 && isvisit[i] == 0) {
					qX.add(i);
					isvisit[i] = 1;
				}
			}
		}
	}
}
