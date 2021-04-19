package langtonsLoop;


import gameOfLife.Grid2d;
import javafx.animation.AnimationTimer;

import java.util.concurrent.TimeUnit;

public class Runner {

    /**
     * Starts the animation timer that controls the visualization.
     * @param gridLL of cells to be shown to the screen. At each time step
     *             it is evolved using its given ruleset.
     */
    public static void run(GridLL gridLL) {
        AnimationTimer timer = new AnimationTimer() {
            private long prevUpdate = 0;
            @Override
            public void handle(long now) {
                if (now - prevUpdate >= TimeUnit.SECONDS.toNanos(2)) {
                    gridLL.nextGeneration();
                    prevUpdate = now;
                }
            }
        };
        timer.start();
    }
}
