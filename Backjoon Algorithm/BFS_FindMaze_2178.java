import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class BFS_FindMaze_2178 {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner keyboard = new Scanner(System.in);
         
        String s = keyboard.nextLine();
        String receive[] = s.split(" ");
         
        int n = Integer.parseInt(receive[0]);
        int m = Integer.parseInt(receive[1]);
        int num[][] = new int[n][m]; 
        int isvisit[][] = new int[n][m];
         
        for(int i = 0; i < n; i++){
            String temp = keyboard.nextLine();
             
            for(int j = 0; j < m; j++) 
                num[i][j] = temp.charAt(j) - 48;   
        }
         
        BFS(num, isvisit, n, m);
    }
     
    public static void BFS(int[][] num, int[][] isvisit, int n, int m){
         
        Queue<Integer> qX = new LinkedList<Integer>();
        Queue<Integer> qY = new LinkedList<Integer>();
        Queue<Integer> level = new LinkedList<Integer>();
         
        int dirX[] = {1, -1, 0, 0};
        int dirY[] = {0, 0, 1, -1};
             
        qX.add(0);
        qY.add(0);
        level.add(1);
        isvisit[0][0] = 1;
         
        while(!qX.isEmpty()){
             
            int currentX = qX.poll();
            int currentY = qY.poll();
            int currentLevel = level.poll();
  
            if(currentX == m-1 && currentY == n-1){
                System.out.println(currentLevel);
                return;
            }
             
            for(int i = 0; i < 4; i++){
                int nextX = currentX + dirX[i];
                int nextY = currentY + dirY[i];
                int nextLevel = currentLevel + 1;
                 
                if(nextX >= 0 && nextY >= 0 && nextX<m && nextY<n){
                    if(num[nextY][nextX] == 1 && isvisit[nextY][nextX] == 0){
                        qX.add(nextX);
                        qY.add(nextY);
                        level.add(nextLevel);
                        isvisit[nextY][nextX] = 1;
                    }               
                }
            }
        }
    }
}