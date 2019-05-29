package com.example.labirintgame;


/**
 * Created by pro on 12.01.2017.
 */
class LabirintGame {

    static class cell {
        int x;
        int y;

        cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class cellString {
        int size;
        cell[] cells;
    }


    public static class Stack {
        private int mSize; //mSize - максимальный размер
        private cell[] stackArray;
        private int top;
        int stackSize;

        Stack(int m) {
            this.mSize = m;
            stackArray = new cell[mSize];
            top = -1;
        }

        void addElement(cell element) {
            stackSize++;
            stackArray[++top] = element;
        }

        cell deleteElement() {
            return stackArray[top--];
        }
    }

    private static int[][] returnmaze(int[][] maze) {
        cell currentCell = new cell(2, 2);
        cell neighbourCell;
        maze = new int[Window.height][Window.width];

        for (int i = 0; i < Window.height; i++) {
            for (int j = 0; j < Window.width; j++) {
                if ((i % 2 != 0 && j % 2 != 0) && //если ячейка нечетная по x и y,
                        (i < Window.height - 1 && j < Window.width - 1))   //и при этом находится в пределах стен лабиринта
                    maze[i][j] = 1;       //то это КЛЕТКА
                else
                    maze[i][j] = 0;           //в остальных случаях это СТЕНА.
            }
        }

        Stack d = new Stack(100000);
        do {
            cellString Neighbours = getNeighbours(Window.width, Window.height, maze, currentCell);
            int randNum;
            if (Neighbours.size != 0) { //если у клетки есть непосещенные соседи
                randNum = (int) (Math.random() * (Neighbours.size));
                neighbourCell = Neighbours.cells[randNum];//выбираем случайного соседа
                d.addElement(currentCell); //заносим текущую точку в стеке
                maze = removeWall(currentCell, neighbourCell, maze); //убираем стену между текущей и сосендней точками
                currentCell = neighbourCell; //делаем соседнюю точку текущей и отмечаем ее посещенной
            } else { //если нет соседей, возвращаемся на предыдущую точку
                currentCell = d.deleteElement();
            }
        }
        while (unvisitedCount(Window.width, Window.height, maze) > 0);
        maze[0][1] = 4;
        maze[Window.height - 2][Window.width - 3] = 2;

        return maze;
    }

    private static cellString getNeighbours(int width, int height, int[][] maze, cell c) {
        int i;
        int x = c.x;
        int y = c.y;
        int distance = 2;
        cell up = new cell(x, y - distance);
        cell rt = new cell(x + distance, y);
        cell dw = new cell(x, y + distance);
        cell lt = new cell(x - distance, y);
        cell[] d = {up, rt, dw, lt};
        int size = 0;
        cellString cells = new cellString();
        cells.cells = new cell[4];
        for (i = 0; i < 4; i++) { //для каждого направдения
            if (d[i].x > 0 && d[i].x < width && d[i].y > 0 && d[i].y < height) { //если не выходит за границы лабиринта
                int mazeCellCurrent = maze[d[i].x - 1][d[i].y - 1];
                cell cellCurrent = d[i];
                if (mazeCellCurrent != 0 && mazeCellCurrent != 2) { //и не посещена\является стеной
                    cells.cells[size] = cellCurrent; //записать в массив;
                    size++;
                }
            }
        }
        cells.size = size;
        return cells;
    }

    private static int[][] removeWall(cell first, cell second, int[][] maze) {
        int xDiff = second.x - first.x;
        int yDiff = second.y - first.y;
        int addX, addY;
        cell target = new cell(0, 0);
        addX = (xDiff != 0) ? (xDiff / Math.abs(xDiff)) : 0;
        addY = (yDiff != 0) ? (yDiff / Math.abs(yDiff)) : 0;
        target.x = first.x + addX; //координаты стенки
        target.y = first.y + addY;
        maze[first.x - 1][first.y - 1] = 2;
        maze[second.x - 1][second.y - 1] = 2;
        maze[target.x - 1][target.y - 1] = 2;
        return maze;
    }

    private static int unvisitedCount(int width, int height, int[][] maze) {
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (maze[i][j] == 1) count++;
            }
        }
        return count;
    }

}