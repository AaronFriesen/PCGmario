package dk.itu.mario.level.generator;

import dk.itu.mario.MarioInterface.GamePlay;
public class PlayerChooser {

    public static PlayerType choose(GamePlay playerMetrics) {
        System.out.println("time spent: " + playerMetrics.totalTime);
        //do stuff to figure out the player type





        return PlayerType.SPEEDER;
    }

}