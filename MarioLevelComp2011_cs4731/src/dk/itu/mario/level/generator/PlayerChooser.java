package dk.itu.mario.level.generator;

import dk.itu.mario.MarioInterface.GamePlay;
import java.util.HashMap;
public class PlayerChooser {

    public static HashMap<PlayerType, Double> choose(GamePlay playerMetrics) {
        System.out.println("time spent: " + playerMetrics.totalTime);
        //do stuff to figure out the player type

        
        HashMap<PlayerType, Double> hash = new HashMap<PlayerType, Double>();// HashMap<PlayerType, Double>;

        hash.put(PlayerType.SPEEDER, 0.0);
        hash.put(PlayerType.JUMPER, 0.0);
        hash.put(PlayerType.SHELLER, 0.0);
        hash.put(PlayerType.COLLECTOR, 0.0);
        
        //Speeder
        double speederChance = playerMetrics.timeSpentRunning;
        int safety = 0;
        
        if(playerMetrics.timeRunningLeft == 0 && playerMetrics.timeRunningRight == 0){
        	safety = 1;
        	
        }
        speederChance *= (double)(playerMetrics.timeRunningRight/(double)(playerMetrics.timeRunningLeft+playerMetrics.timeRunningRight+safety));
        speederChance /= (double)playerMetrics.totalTime;
        
        
        //Jumper
        double jumperChance = (double)playerMetrics.jumpsNumber/(double)playerMetrics.totalTime;
        
        System.out.println("Jumper chance: "+jumperChance);

        
        
        //Sheller
        int totalKilled = 	playerMetrics.RedTurtlesKilled+ 
        		playerMetrics.GreenTurtlesKilled+ 
        		playerMetrics.ArmoredTurtlesKilled+
        		playerMetrics.GoombasKilled+
        		playerMetrics.CannonBallKilled+
        		playerMetrics.JumpFlowersKilled+
        		playerMetrics.ChompFlowersKilled;
        
        double shellerChance;
        
        if(totalKilled>0){
        	shellerChance = (playerMetrics.kickedShells+playerMetrics.enemyKillByKickingShell)/(double)totalKilled;
        	shellerChance /= (playerMetrics.totalEnemies/5);
        }else{
        	shellerChance = 0;
        }
        
        
        //Collector
        double collectorChance = playerMetrics.coinsCollected/(double)playerMetrics.totalCoins;
        collectorChance += playerMetrics.percentageCoinBlocksDestroyed;
        collectorChance += playerMetrics.percentagePowerBlockDestroyed;
        collectorChance /=3;
        
        System.out.println("Collector chance: "+collectorChance);
        
        System.out.println("Sheller chance: "+shellerChance);
        
        hash.put(PlayerType.SPEEDER, speederChance);
        System.out.println("Speeder Chance"+speederChance);
        
        System.out.println("Run Right "+playerMetrics.timeRunningRight);
        System.out.println("Run Left "+playerMetrics.timeRunningLeft);
        System.out.println("Run "+playerMetrics.timeSpentRunning);
        System.out.println("Total Time: "+playerMetrics.totalTime);
        
        //double speederNumber = 
        
        
        
        

        return hash;//PlayerType.SPEEDER;
    }

}