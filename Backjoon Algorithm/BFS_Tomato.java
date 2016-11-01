/*
#include<iostream>
#include<stdlib.h>
#include<queue>
using namespace std;
int level = 0;
 
int main() {
 
    int M, N, **tomato, **isTomato, **TomatoLevel;
    queue<int> tomaX, tomaY, tomaLevel;
    int check = 0;
 
    cin >> M >> N;
 
    while (M < 2 || N > 1000 || N < 0) 
        cin >> M >> N;
     
    tomato = (int**)malloc(sizeof(int*) * N);
    isTomato = (int**)malloc(sizeof(int*) * N);
    TomatoLevel = (int**)malloc(sizeof(int*) * N);
 
    for (int i = 0; i < N; i++) {
        tomato[i] = (int *)malloc(sizeof(int*) * M);
        isTomato[i] = (int *)malloc(sizeof(int*) * M);
        TomatoLevel[i] = (int *)malloc(sizeof(int*) * M);
 
        for (int j = 0; j < M; j++) {
            TomatoLevel[i][j] = 0;
            cin >> tomato[i][j];
         
            if (tomato[i][j] == 1) {
                check++;
                tomaX.push(i);
                tomaY.push(j);
                tomaLevel.push(0);
                TomatoLevel[i][j] = -1;
                isTomato[i][j] = 1;
            }
            else if (tomato[i][j] == -1) {
                TomatoLevel[i][j] = -2;
                isTomato[i][j] = 1;
            }
            if (i == N - 1 && j == M - 1 && check == M*N) {
                cout << "0" << endl;
                exit(1);
            }
            else if (i == N - 1 && j == M - 1 && check == 0) {
                cout << "-1" << endl;
                exit(1);
            }
 
        }
    }
 
    int dirX[4] = { 0,0,1,-1 };
    int dirY[4] = { 1,-1,0,0 };
 
    while (!tomaX.empty()) {
 
        int currentX = tomaX.front();
        int currentY = tomaY.front();
        int currentLevel = tomaLevel.front();
        tomaX.pop();
        tomaY.pop();
        tomaLevel.pop();
 
        for (int i = 0; i < 4; i++) {
            int nextX = currentX + dirX[i];
            int nextY = currentY + dirY[i];
            int nextLevel = currentLevel + 1;
 
            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                if (tomato[nextX][nextY] == -1 || tomato[nextX][nextY] == -2)
                    continue;
                if (isTomato[nextX][nextY] != 1 && tomato[nextX][nextY] == 0) {
                    isTomato[nextX][nextY] = 1;
                    TomatoLevel[nextX][nextY] = nextLevel;
                    tomaX.push(nextX);
                    tomaY.push(nextY);
                    tomaLevel.push(nextLevel);
 
                }
                else if (isTomato[nextX][nextY] == 1 && tomato[nextX][nextY] == 0) {
                    if (TomatoLevel[nextX][nextY] > nextLevel) {
                        isTomato[nextX][nextY] = 1;
                        TomatoLevel[nextX][nextY] = nextLevel;
                        tomaX.push(nextX);
                        tomaY.push(nextY);
                        tomaLevel.push(nextLevel);
                    }
                }
            }
        }
    }
    int max = 0;
    int check2 = 0;
 
    for (int i = 0; i < N; i++){
        for (int j = 0; j < M; j++) {
            if (max < TomatoLevel[i][j])
                max = TomatoLevel[i][j];
            if (TomatoLevel[i][j] == 0 )
                check2++;
        }
    }
    if (check2 > 0)
        cout << "-1" << endl;
    else
        cout << max << endl;
 
    return 0;
}
*/