package elementaryCA.backend;

import elementaryCA.backend.cell.Cell;
import elementaryCA.backend.grid.Grid1D;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import elementaryCA.backend.cell.Cell;



public class ElementaryCA extends Application {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("1D Cellular Automata");

        GridPane gridPane;
        gridPane = new GridPane();
        double width = 1000;
        double height = 800;
        gridPane.setPadding(new Insets(30));
        Scene scene = new Scene(gridPane, width, height);
        stage.setScene(scene);
        stage.show();


        String firstGenStr = "";
        List<Cell> firstGen = new ArrayList<>();
        // TODO: Turn the firstGen string into a list of cells
        int ruleNum;
        String rule = "00011110";
        System.out.println("Do you want to read a file or generate (f/g)?");
        String choice = scanner.next();
        switch (choice){
            case "f":
                System.out.println("Enter file path");
                String filePath = scanner.next();
                try (BufferedReader reader =
                             new BufferedReader(new FileReader(filePath)))
                {
                    rule = reader.readLine();
                    firstGenStr = reader.readLine();
                    reader.close();
                    BufferedReader.nullReader().close();
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                break;
            case "g":
                do {
                    System.out.println("Which rule do you want to see?");
                    System.out.println("Enter an integer between 0 and 255 inclusive");
                    ruleNum = scanner.nextInt();
                    if (ruleNum < 0 || ruleNum > 255 )
                    {
                        System.out.println("\nEnter a valid rule number (0-255)");
                    }
                }while(ruleNum < 0 || ruleNum > 255);
                rule = Integer.toBinaryString(ruleNum);
                rule = String.format("%8s", rule).replaceAll(" ", "0");

                System.out.println("Rule in binary" + rule);
                System.out.println("What's your first generation?");
                firstGenStr = scanner.next();
                break;
            default:
                System.out.println("Enter a valid choice");
                break;
        }


        //convert the first generation string to a list of cells
        for (int i = 0; i < firstGenStr.length(); i++) {
            firstGen.add(i, Cell.fromChar(firstGenStr.charAt(i)));
        }
        double cellSize = (width/firstGenStr.length());
        Grid1D grid = new Grid1D(gridPane, rule, firstGen, 20);
        Runner.run(grid);
    }
}
