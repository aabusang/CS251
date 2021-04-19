package langtonsLoop;

import javafx.scene.paint.Color;

import java.util.Scanner;

public enum Cell {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    ZERO(0);
    private final int cellValue;
    Cell(int cellValue){
        this.cellValue = cellValue;
    }

    public int getCellValue() {
        return cellValue;
    }

    //Return a cell color depending on it's value or number
    Color getColor(){
        Color c = null;
        switch (cellValue){
            case 0:
                c = Color.WHITE;
            case 1:
                c = Color.BLACK;
                break;
            case 2:
                c = Color.YELLOW;
                break;
            case 3:
                c = Color.GREEN;
                break;
            case 4:
                c = Color.RED;
                break;
            case 5:
                c = Color.BROWN;
                break;
            case 6:
                c = Color.PURPLE;
                break;
            case 7:
                c = Color.BLUE;
                break;
            case 8:
                c = Color.ORANGE;
                break;
            case 9:
                c = Color.BLUEVIOLET;
        }
        return c;
    }

    //gives a character an enum / color depending on the characters value
    public static Cell fromChar(char c) throws IllegalArgumentException {
        if (c == '0') {
            return Cell.ZERO;
        }
        else if (c == '1') {
            return Cell.ONE;
        }
        else if (c == '2') {
            return Cell.TWO;
        }
        else if (c == '3') {
            return Cell.THREE;
        }
        else if (c == '4') {
            return Cell.FOUR;
        }
        else if (c == '5') {
            return Cell.FIVE;
        }
        else if (c == '6') {
            return Cell.SIX;
        }
        else if (c == '7') {
            return Cell.SEVEN;
        }
        else if (c == '8') {
            return Cell.EIGHT;
        }
        else if (c == '9') {
            return Cell.NINE;
        }
        else {
            throw new IllegalArgumentException("Input char must be either 0 or 1.");
        }
    }
}
