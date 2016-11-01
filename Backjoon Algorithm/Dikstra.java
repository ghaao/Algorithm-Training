
import java.io.BufferedReader;

import java.io.InputStreamReader;

public class Dikstra {
	public static void main(String[] args) throws Exception {
		int n = 10; // 배열의 최대길이
		int m = 5000; // 너무 멀어서 이동하지 못하는 값 (다른수에 비해 충분히 크면 됨)
		int i, j, k = 0;
		int s, e, min;
		int[] v = new int[n];
		int[] distance = new int[n]; // 누적거리 배열
		int[] via = new int[n];

		// 인접-행렬 메트릭스
		int[][] data = { { 0, 2, m, m, m, 3, m, m, 2, 1 }, { 2, 0, 4, 1, m, m, m, m, 2, 2 },
				{ m, 4, 0, m, 3, m, m, m, 2, m }, { m, 1, m, 0, 3, m, 2, m, 4, 2 }, { m, m, 3, 3, 0, m, m, 4, 6, 4 },
				{ 3, m, m, m, m, 0, 6, m, m, 1 }, { m, m, m, 2, m, 6, 0, 4, 7, 2 }, { m, m, m, m, 4, m, 4, 0, 5, 5 },
				{ m, 4, m, m, 2, m, 4, 2, m, m }, { m, 1, m, 5, 4, m, 4, m, 5, 8 } };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\n출발점을 입력하시오 : ");
		s = Integer.parseInt(br.readLine());
		System.out.print("\n도착점을 입력하시오 : ");
		e = Integer.parseInt(br.readLine());
		for (j = 0; j < n; j++) {
			v[j] = 0;
			distance[j] = m;
		}

		distance[s - 1] = 0;

		for (i = 0; i < n; i++) {
			min = m;
			for (j = 0; j < n; j++) {
				if (v[j] == 0 && distance[j] < min) {
					k = j;
					min = distance[j];
				}
			}

			v[k] = 1;

			if (min == m)
				break;

			for (j = 0; j < n; j++) {
				if (distance[j] > distance[k] + data[k][j]) {
					distance[j] = distance[k] + data[k][j];
					via[j] = k;
				}
			}
		}

		System.out.printf("\n %d에서 출발하여, %d로 가는 최단 거리는 %d입니다.\n", s, e, distance[e - 1]);
		int path[] = new int[n];
		int path_cnt = 0;
		k = e - 1;
		while (true) {
			path[path_cnt++] = k;
			if (k == s - 1)
				break;
			k = via[k];
		}

		System.out.print(" 경로는 : ");

		for (i = path_cnt - 1; i >= 1; i--) {
			System.out.printf("%d -> ", path[i] + 1);
		}

		System.out.printf("%d입니다", path[i] + 1);
	}

}
