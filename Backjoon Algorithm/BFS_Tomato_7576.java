import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_Tomato_7576 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int dirX[] = {0, 0, 1, -1};
		int dirY[] = {1, -1, 0, 0};
		
		Queue<Integer> qX = new LinkedList<Integer>();
		Queue<Integer> qY = new LinkedList<Integer>();
		Queue<Integer> level = new LinkedList<Integer>();
		
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int[][] map = new int[h+1][w+1];
		int[][] isvisit = new int[h+1][w+1];
		
		for(int i = 1 ; i <= h; i ++)
			for(int j = 1 ; j <= w; j ++){
				map[i][j] = sc.nextInt();
				
				if(map[i][j] == 1){
					qX.add(j);
					qY.add(i);
					level.add(1);
				}
			}
		
		while(!qX.isEmpty()){
			int currX = qX.poll();
			int currY = qY.poll();
			int currL = level.poll();
			
			for(int i = 0 ; i <4; i++){
				int nextX = currX + dirX[i];
				int nextY = currY + dirY[i];
				
				if(nextX>0 && nextY>0 && nextX<=w && nextY <= h){
					if((map[nextY][nextX] == 0) || (map[nextY][nextX] != 0 && map[nextY][nextX] > currL)){
						qX.add(nextX);
						qY.add(nextY);
						level.add(currL+1);
						map[nextY][nextX] = currL;
					}
				}
			}
		}
		
		int max = 0;
		
		for(int i = 1; i<=h; i++)
			for(int j = 1; j<=w; j++){
				
				if(max < map[i][j])
					max = map[i][j];
				if(map[i][j] == 0){
					System.out.println(-1);
					return;
				}
			}
		
		System.out.println(max);
	}
}
