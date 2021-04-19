package langtonsLoop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LangtonsLoop extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Langton's Loop");
        GridPane Grid_Pane = new GridPane();
        double width = 600;
        double height = 500;
        double cellSize = 20;
        Grid_Pane.setPadding(new Insets(10));
        Scene scene = new Scene(Grid_Pane, width, height);
        stage.setScene(scene);
        stage.show();

        String initialConfig = "resources/langtonsLoop/init_config.txt";
        String ruleTableFile = "resources/langtonsLoop/rule_table.txt";
        StringBuilder firstG = new StringBuilder();
        String line;
        String firstGenStr = "", rules = "";
        int row = 100;
        int column = 100;
        try(BufferedReader reader =
                    new BufferedReader(new FileReader(initialConfig))){

            String firstLine = reader.readLine();
            while ((line = reader.readLine()) != null){
                firstG.append(line);
            }
            firstGenStr = String.valueOf(firstG);
        }
        try (BufferedReader reader =
                     new BufferedReader((new FileReader(ruleTableFile)))){
            while ((line = reader.readLine()) != null){
                firstG.append(line);
            }
            rules = String.valueOf(firstG);
        }

        //turn rule table to a list of rules;
        List<List<Cell>> ruleList = new ArrayList<>();
        int x = 0;
        for (int i = 0; i < 219; i++){
            List<Cell> givenRule = new ArrayList<>();
            for (int j = 0; j < 6; j++){
                givenRule.add(Cell.fromChar(rules.charAt(x)));
                x++;
            }
            ruleList.add(i, givenRule);
        }
        //turn first generation string to list of cells
        List<List<Cell>> firstGenCells = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < row; i++){
            List<Cell> givenRow = new ArrayList<>();
            for (int j = 0; j < column; j++){
                givenRow.add(Cell.fromChar(firstGenStr.charAt(k)));
                k++;
            }
            firstGenCells.add(givenRow);
        }

        GridLL gridLL = new GridLL(Grid_Pane, firstGenCells, ruleList, cellSize);
        Runner.run(gridLL);
    }
}
