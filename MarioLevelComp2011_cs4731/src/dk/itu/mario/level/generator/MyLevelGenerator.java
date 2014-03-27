package dk.itu.mario.level.generator;

import java.util.Random;
import java.util.HashMap;
import dk.itu.mario.MarioInterface.Constraints;
import dk.itu.mario.MarioInterface.GamePlay;
import dk.itu.mario.MarioInterface.LevelGenerator;
import dk.itu.mario.MarioInterface.LevelInterface;
import dk.itu.mario.level.CustomizedLevel;
import dk.itu.mario.level.MyLevel;

public class MyLevelGenerator extends CustomizedLevelGenerator implements LevelGenerator{
    private Random rand;
	public LevelInterface generateLevel(GamePlay playerMetrics) {
        rand = new Random();
		MyLevel level = new MyLevel(320,15,rand.nextLong(),5,LevelInterface.TYPE_CASTLE ,playerMetrics);
		HashMap<PlayerType,Double> pTypes = PlayerChooser.choose(playerMetrics);
        pTypes = normalize(pTypes);
        //do a bunch of calls to generate____Segment();
        PlayerType pType = chooseMax(pTypes); //currently just choosing the max - will change to percentage based approach soon
        
        generateRunSegment(level, level.length, 8, level.height - 4, false); //initial safe spot
        int levelLength = 128;
        while (level.length < levelLength) {
            switch (chooseRandom(pTypes)) {
                case SPEEDER:
                    generateRunSegment(level, level.length, 8, level.height - 4, false); break;
                case JUMPER:
                    generateJumpSegment(level, level.length, 8,level.height - rand.nextInt(5)); break;
                case SHELLER:
                    generateKickSegment(level, level.length, 8); break;
                case COLLECTOR:
                    generateCollectSegment(level, level.length, 8); break;
            }
        }
        /*
        if (pType == PlayerType.SPEEDER) {
            int curLength = 0;
            while (curLength < 256) {
                generateRunSegment(level, curLength, 8, level.height - 4, false);
                curLength += 8;
            }





        }
        if (pType == PlayerType.JUMPER) {
            int curLength = 0;
            generateRunSegment(level, level.length, 8, level.height - 4, rand.nextBoolean());
            while (level.length < 256) {
                switch (rand.nextInt(2)) {
                    case 0: generateJumpSegment(level, level.length, 8);
                    case 1: generateRunSegment(level, level.length, 8, level.height - 4, rand.nextBoolean()); break;
                }
            }



        } */


        level.end();
        return level;
	}

	@Override
	public LevelInterface generateLevel(String detailedInfo) {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * @author Nick Popescu
     */
    public void generateRunSegment(MyLevel curLevel, int start, int length, int floorHeight, boolean safe) { //needs params
        
        curLevel.buildStraightManual(start, length, floorHeight, safe);
    }
    /**
     * @author Nick Popescu
     */
    public void generateJumpSegment(MyLevel curLevel, int start, int length, int floorHeight) {
        switch (rand.nextInt(2)) {
            case 0: curLevel.buildJump(start, length); break;
            case 1: curLevel.buildStraightManual(start, length, floorHeight, rand.nextBoolean()); break;
        }
    }
    /**
     * @author Aaron Friesen
     */
    public void generateKickSegment(MyLevel curLevel, int start, int length) {
        
    }
    /**
     * @author Aaron Friesen
     */
    public void generateCollectSegment(MyLevel curLevel, int start, int length) {

    }

    public HashMap<PlayerType, Double> normalize(HashMap<PlayerType, Double> notNormalizedTypes) {
        HashMap<PlayerType, Double> types = new HashMap<PlayerType, Double>();

        double total = 0.0;
        for (PlayerType t : notNormalizedTypes.keySet()) {
            total += notNormalizedTypes.get(t);
        }

        for (PlayerType t : notNormalizedTypes.keySet()) {
            types.put(t, notNormalizedTypes.get(t) / total);
        }
        return types;
    }

    public PlayerType chooseMax(HashMap<PlayerType, Double> types) {
        PlayerType type = PlayerType.SPEEDER;
        double best = 0.0;
        for (PlayerType t : types.keySet()) {
            if (types.get(t) > best) {
                best = types.get(t);
                type = t;
            }
        }
        return type;
    }

    public PlayerType chooseRandom(HashMap<PlayerType, Double> types) {
        double d = rand.nextDouble();
        double total = 0.0;
        for (PlayerType p : types.keySet()) {
            total += types.get(p);
            if (total >= d) return p;
        }
        return null;
        


    }

}
