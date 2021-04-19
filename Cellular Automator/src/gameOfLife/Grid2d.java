package gameOfLife;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Rectangle;

import static gameOfLife.Cell.*;

public class Grid2d {

    private final GridPane gridPane;
    private final int rows;
    private final int columns;
    private final double cellSize;
    List<List<Cell>> currentGen;
    public Grid2d(GridPane gridPane, int rows, int columns,
                  List<List<Cell>> currentGen,
                  double cellSize) {
        this.gridPane = gridPane;
        this.rows = rows;
        this.columns = columns;
        this.currentGen = currentGen;
        this.cellSize = cellSize;
        show();
    }


    //a function to return the number of live neighbors
    private int numberOfLiveNeighbors(List<List<Cell>> currentGen,int x, int y) {
        int neighborCount = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int rowIndex = ((x - i) + columns) % columns;
                int colIndex = ((y - j) + rows) % rows;
                if (currentGen.get(colIndex).get(rowIndex) == BLACK) {
                    neighborCount++;
                }
            }
        }
//        for (int i = x - 1; i <= x + 1; i++){
//            for (int j = y - 1; j <= y + 1; j++){
//                int rowIndex = (i + rows) % rows;
//                int colIndex = (j + columns) % columns;
//                if (i != x && j != y){
//                    if (currentGen.get(rowIndex).get(colIndex) == BLACK){
//                        neighborCount++;
//                    }
//                }
//            }
//        }
        return neighborCount;

    }

//    protected List<Cell>
//    neighborCells(List<List<Cell>> currentG, int rowIndex, int colIndex){
//    List<Cell> neighbors = new ArrayList<>();
//
//        for (int i = -1; i < 2; i++){
//            for (int j = -1; j < 2; j++){
//                int rowI = ( (colIndex - i) + columns) % columns;
//                int colJ = ( (rowIndex - j) + rows) % rows;
//                neighbors.add(currentG.get(rowI).get(colJ));
//            }
//        }
//        return neighbors;
//    }

    private void evolve(){
        int neighborCount;
        Cell currentCell;
        List<List<Cell>> nextGen = new ArrayList<>();
        for (int i = 0; i < rows; i++){
            List<Cell> givenRow = new ArrayList<>();
            for (int j = 0; j < columns; j++){

                currentCell = currentGen.get(j).get(i);
                neighborCount = numberOfLiveNeighbors(currentGen, j, i);

                if (currentCell == BLACK){
                    if (neighborCount < 2 || neighborCount > 3){
                        currentCell = WHITE;
                    }
                }
                if (currentCell == WHITE){
                    if (neighborCount == 3){
                        currentCell = BLACK;
                    }
                }
                givenRow.add(currentCell);
            }
            nextGen.add(givenRow);
        }
        currentGen = nextGen;
    }


    private void show(){
        gridPane.getChildren().clear();
        int rowIndex = 0;
        int colIndex = 0;
        for (List<Cell> row : currentGen){
            for (Cell cell : row){
                Rectangle rect = new
                        Rectangle(cellSize, cellSize, cell.getColor());
                gridPane.add(rect, colIndex, rowIndex);
                colIndex++;
            }
            colIndex = 0;
            rowIndex++;
        }
    }
    public void nextGeneration(){
        evolve();
        show();
    }
}
