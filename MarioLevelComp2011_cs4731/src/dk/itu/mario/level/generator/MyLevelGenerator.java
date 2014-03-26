package dk.itu.mario.level.generator;

import java.util.Random;

import dk.itu.mario.MarioInterface.Constraints;
import dk.itu.mario.MarioInterface.GamePlay;
import dk.itu.mario.MarioInterface.LevelGenerator;
import dk.itu.mario.MarioInterface.LevelInterface;
import dk.itu.mario.level.CustomizedLevel;
import dk.itu.mario.level.MyLevel;

public class MyLevelGenerator extends CustomizedLevelGenerator implements LevelGenerator{

	public LevelInterface generateLevel(GamePlay playerMetrics) {
        Random rand = new Random();
		MyLevel level = new MyLevel(320,15,rand.nextLong(),1,LevelInterface.TYPE_OVERGROUND ,playerMetrics);
		PlayerType pType = PlayerType.SPEEDER;
        System.out.println("width: " + level.width);
        level.buildStraight(0, 8, true);
        //do a bunch of calls to generate____Segment();
        if (pType == PlayerType.SPEEDER) {
            int curLength = 8;
            while (curLength < 64) {
                generateRunSegment(level, curLength, curLength + 8, level.height - 4, false);
                curLength += 8;
            }
            int floor = level.height - 1 - rand.nextInt(4);

	        level.end();




        }
		//generateJumpSegment(level, 5, 20);


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
    public void generateRunSegment(MyLevel curLevel, int start, int end, int floorHeight, boolean safe) { //needs params
        
        curLevel.buildStraightManual(start, end, floorHeight, safe);
    }
    /**
     * @author Nick Popescu
     */
    public void generateJumpSegment(MyLevel curLevel, int start, int end) {
    	//int length = curLevel.length;
    	//int width = curLevel.width;
    	//int height = curLevel.height;
    	
    	
    	//curLevel.length += curLevel.buildStraightManual(length, length+(end-start), height-5, true);

    }
    /**
     * @author Aaron Friesen
     */
    public void generateKickSegment(MyLevel curLevel, int start, int end) {

    }
    /**
     * @author Aaron Friesen
     */
    public void generateCollectSegment(MyLevel curLevel, int start, int end) {

    }

}
