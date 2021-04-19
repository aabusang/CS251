package gameOfLife;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameOfLife extends Application {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Conway's Game of Life");
        GridPane gridPane = new GridPane();
        double width = 1000;
        double height = 800;
        gridPane.setPadding(new Insets(20));
//        gridPane.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        Scene scene = new Scene(gridPane, width, height);
        stage.setScene(scene);
        stage.show();

        //Reading in input
        int rows  = 0, columns = 0;
        String firstGenStr = "";

        System.out.println("Do you want to read a file or generate (f/g)?");
        String choice = scanner.next();
        switch (choice){
            case "f":
                System.out.println("Enter the file path");
                String filePath = scanner.next();
                try(BufferedReader reader =
                        new BufferedReader(new FileReader(filePath))){

                    //read number of rows and columns
                    //assuming rows and columns will be 1 or 2 digits numbers each only
                    String firstLine = reader.readLine();
                    String row = "", col = "";
                    if (firstLine.length() == 5){
                        row = firstLine.substring(0, 2);
                        col = firstLine.substring(3, 5);
                    }
                    if (firstLine.length() == 3){
                        row = firstLine.substring(0, 1);
                        col = firstLine.substring(2, 3);
                    }
                    rows = Integer.parseInt(row);
                    columns = Integer.parseInt(col);

                    //read the first grid or generation by append each row/line to the whole string
                    StringBuilder firstG = new StringBuilder();

                    String line;
                    while ((line = reader.readLine()) != null){
                        firstG.append(line);
                    }
                    if (firstG.length() != (rows * columns)){
                        System.out.println("Make sure grid matches grid size");
                        break;
                    }

                    firstGenStr = String.valueOf(firstG);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                break;
            case "g":
                System.out.println("Enter number of rows");
                rows = scanner.nextInt();
                System.out.println("Enter number of columns");
                columns = scanner.nextInt();
                do {
                    System.out.println("Enter the initial grid with space between each '0' or '1'");
                    System.out.println("\nGrid rows and columns should match your rows \n" +
                            "and columns numbers entered above");
                    firstGenStr = scanner.next();
                }while (firstGenStr.length() != (rows * columns));
                break;
            default:
                System.out.println("Enter a valid choice 'f' or 'g'");
                break;
        }

        System.out.println("Rows: "+ rows + "\nColumns: "+ columns);
        System.out.println(firstGenStr);

        List<List<Cell>> firstGen = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < rows; i++){
            List<Cell> givenRow = new ArrayList<>();
            for (int j = 0; j < columns; j++){
                 givenRow.add(Cell.fromChar(firstGenStr.charAt(k)));
                 k++;
            }
            firstGen.add(givenRow);
        }

        Grid2d grid2d = new Grid2d(gridPane, rows, columns, firstGen, 50);
        Runner.run(grid2d);
    }
}
