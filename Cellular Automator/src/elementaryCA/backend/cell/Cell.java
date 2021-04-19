package elementaryCA.backend.cell;

import javafx.scene.paint.Color;

public enum Cell {
    WHITE(false),
    BLACK(true);

    private final boolean STATE;

    Cell(boolean state) {
        this.STATE = state;
    }

    public boolean isOn() {
        return STATE;
    }

    public Color getColor() {
        if (this == WHITE) {
            return Color.WHITE;
        }
        else {
            return Color.BLACK;
        }
    }


    public static Cell fromChar(char c) throws IllegalArgumentException {
        if (c == '0') {
            return WHITE;
        }
        else if (c == '1') {
            return BLACK;
        }
        else {
            throw new IllegalArgumentException("Input char must be either 0 or 1.");
        }
    }
}
