import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class BFS_numberOfIsland_4963 {
    static int dirX[] = { 0, 0, 1, -1, 1, 1, -1, -1 };
    static int dirY[] = { 1, -1, 0, 0, 1, -1, 1, -1 };
   
    static int map[][] = new int[51][51];
    static int isvisit[][] = new int[51][51];
    
    static Queue<Integer> qX = new LinkedList<Integer>();
    static Queue<Integer> qY = new LinkedList<Integer>();

    static int w, h;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            int cnt = 0;
 
            if (w == 0 && h == 0)
                break;
 
            for (int i = 1; i <= h; i++)
                for (int j = 1; j <= w; j++){
                    map[i][j] = sc.nextInt();
                    isvisit[i][j] = 0;
                }
 
            for (int i = 1; i <= h; i++)
                for (int j = 1; j <= w; j++)
                    if (map[i][j] == 1 && isvisit[i][j] == 0){
                        bfs(i, j);
                        cnt++;
                    }
            
            System.out.println(cnt);
        }
    }
 
    public static void bfs(int y, int x) {
        qX.add(x);
        qY.add(y);
 
        while (!qX.isEmpty()) {
            int currentX = qX.poll();
            int currentY = qY.poll();
            
            isvisit[currentY][currentX] = 1;
 
            for (int i = 0; i < 8; i++) {
                int nextX = currentX + dirX[i];
                int nextY = currentY + dirY[i];
 
                if (nextX > 0 && nextY > 0 && nextX <= w && nextY <= h) 
                    if (map[nextY][nextX] == 1 && isvisit[nextY][nextX] == 0) {
                        qX.add(nextX);
                        qY.add(nextY);
                    }
                
            }
        }
    }
}