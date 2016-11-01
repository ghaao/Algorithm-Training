import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class DFS_attachDANJInumber_2667 {
 
    static int isvisit[][], group[][], map[][], n;
    static int dirX[] = { 0, 0, 1, -1 };
    static int dirY[] = { 1, -1, 0, 0 };
     
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
         
        n = Integer.parseInt(N);
         
        map = new int[n+1][n+1];
        isvisit = new int[n+1][n+1];
        group = new int[n+1][n+1];
         
        for(int i = 1; i <= n; i++){
            String line = sc.nextLine();
             
            for(int j = 1; j <= n; j++)
                map[i][j] = line.charAt(j-1) - 48;          
        }
             
        int cnt = 0;
         
        for(int i = 1; i <= n; i++)
            for(int j =1; j <= n; j++)
                if(map[i][j] == 1 && isvisit[i][j] == 0)
                    bfs(i,j,++cnt);
             
        System.out.println(cnt);
         
        int result[] = new int[25*25];
          
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                result[group[i][j]] += 1;
          
        Arrays.sort(result, 1, cnt+1);
         
        for(int i = 1; i <= cnt; i++)
            System.out.println(result[i]);      
         
    }
     
    public static void bfs(int y, int x, int cnt){
         
        Queue<Integer> qX = new LinkedList<Integer>();
        Queue<Integer> qY = new LinkedList<Integer>();
         
        qX.add(x);
        qY.add(y);
         
        while(!qX.isEmpty()){
            int currentX = qX.poll();
            int currentY = qY.poll();
             
            isvisit[currentY][currentX] = 1;
            group[currentY][currentX] = cnt;
             
            for(int i = 0; i < 4; i++){
                int nextX = currentX + dirX[i];
                int nextY = currentY + dirY[i];
                 
                if(nextX >= 1 && nextY >= 1 && nextX <= n && nextY <= n ){
                    if(map[nextY][nextX] == 1 && isvisit[nextY][nextX] == 0){
                        qX.add(nextX);
                        qY.add(nextY);
                    }
                }
            }
        }
 
    }
 
}