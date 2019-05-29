package com.example.labirintgame;

/**
 * Created by pro on 17.01.2017.
 */
public class Exit {
    static LabirintGame.cell currentCell = new LabirintGame.cell(0, 0);
    static boolean flag = true;
    static int[][] finalMaze( int[][] maze ){
        do {
            flag = true;
            for (int i = 0; i < Window.height - 2; i++) {
                for (int j = 0; j < Window.width - 1; j++) {
                    LabirintGame.cellString ends = getExit(Window.width, Window.height, Window.maze2, i, j);
                    if (ends.size == 3 && maze[i][j] == 2) {
                        maze[i][j] = 3;
                        flag = false;
                    }
                }
            }
        } while (flag == false);


        return maze;
    }

    static LabirintGame.cellString getExit(int width, int height, int[][] maze, int t, int j) {
        LabirintGame.cell currentCell = new LabirintGame.cell(t,j);
        int i;
        int x = currentCell.x;
        int y = currentCell.y;
        int distance = 1;
        LabirintGame.cell up = new LabirintGame.cell(x, y - distance);
        LabirintGame.cell rt = new LabirintGame.cell(x + distance, y);
        LabirintGame.cell dw = new LabirintGame.cell(x, y + distance);
        LabirintGame.cell lt = new LabirintGame.cell(x - distance, y);
        LabirintGame.cell[] d = {up, rt, dw, lt};
        int size = 0;
        LabirintGame.cellString cells = new LabirintGame.cellString();
        cells.cells = new LabirintGame.cell[4];
        for (i = 0; i < 4; i++) { //для каждого направдения
            if (d[i].x >= 0 && d[i].x < width && d[i].y >= 0 && d[i].y < height) { //если не выходит за границы лабиринта
                int mazeCellCurrent = maze[d[i].x][d[i].y];
                LabirintGame.cell cellCurrent = d[i];
                if (mazeCellCurrent == 0 || mazeCellCurrent == 3) { //и не посещена\является стеной
                    cells.cells[size] = cellCurrent; //записать в массив;
                    size++;
                }
            }
        }
        cells.size = size;
        return cells;
    }



}
