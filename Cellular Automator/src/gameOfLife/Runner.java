package gameOfLife;


import javafx.animation.AnimationTimer;

import java.util.concurrent.TimeUnit;

public class Runner {

    /**
     * Starts the animation timer that controls the visualization.
     * @param grid2d of cells to be shown to the screen. At each time step
     *             it is evolved using its given ruleset.
     */
    public static void run(Grid2d grid2d) {
        AnimationTimer timer = new AnimationTimer() {
            private long prevUpdate = 0;
            @Override
            public void handle(long now) {
                if (now - prevUpdate >= TimeUnit.SECONDS.toNanos(1)) {
                    grid2d.nextGeneration();
                    prevUpdate = now;
                }
            }
        };
        timer.start();
    }
}
