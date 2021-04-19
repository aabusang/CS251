package langtonsLoop;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

import static gameOfLife.Cell.BLACK;

public class GridLL {

    private final GridPane gridPane;
    private List<List<Cell>> currentGen;
    private final List<List<Cell>> ruleList;
    private final double cellSize;
    private final int rows = 100;
    private final int columns = 100;
    public GridLL(GridPane gridPane,
                  List<List<Cell>> currentGen,
                  List<List<Cell>> ruleList,
                  double cellSize){
        this.gridPane = gridPane;
        this.currentGen = currentGen;
        this.ruleList = ruleList;
        this.cellSize = cellSize;

        //show first generation to the screen
        show();
    }

    /**
     * this function return true if a given neighbor
     * in a given cells radia is an immediate neighbor
     * **/
    private boolean closeNeb(List<List<Cell>> givenGen,
                             int row, int col){
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int rowIndex = ((row - i) + columns) % columns;
                int colIndex = ((col - j) + rows) % rows;
                if  (givenGen.get(rowIndex).get(colIndex) ==
                        givenGen.get(row).get(col -1) ||
                        givenGen.get(rowIndex).get(colIndex) ==
                        givenGen.get(row).get(col + 1) ||
                        givenGen.get(rowIndex).get(colIndex) ==
                        givenGen.get(row - 1).get(col) ||
                        givenGen.get(rowIndex).get(colIndex) ==
                        givenGen.get(row + 1).get(col)){
                    return true;
                };
            }
        }
        return false;
    }

    /**
     * this function returns the list of all a given
     * cell's immediate neighbors
     * **/
    private List<Cell> myNeighbors(
            List<List<Cell>> givenGen,
            int row, int col){
        List<Cell> realNebs = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int rowIndex = ((row - i) + columns) % columns;
                int colIndex = ((col - j) + rows) % rows;
                if (closeNeb(givenGen, i, j)){
                    realNebs.add(givenGen.get(rowIndex).get(colIndex));
                }
            }
        }
        return  realNebs;
    }
    private void evolve(){

        List<List<Cell>> nextG = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                List<Cell> neighbors = myNeighbors(currentGen, i, j);
                Cell currentCell = currentGen.get(i).get(j);
                for (int k = 0; k < 219; k++){
                    List<Cell> rule = ruleList.get(k);
                    if (rule.equals(neighbors)){
                        currentCell = rule.get(rule.size() - 1);
                    }
                }
            }
        }
//        currentGen = nextG;
    }
    private void show(){
        //show next generation on screen on it's own space
        int colIndex = 0;
        int rowIndex = 0;
        for (List<Cell> row : currentGen){
            for (Cell cell : row){
                Rectangle rect = new
                        Rectangle(cellSize, cellSize, cell.getColor());
                gridPane.add(rect, colIndex, rowIndex);
                colIndex++;
            }
            rowIndex++;
        }
    }

    public void nextGeneration(){
        evolve();
        show();
    }
}
