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
		MyLevel level = new MyLevel(320,15,new Random().nextLong(),1,LevelInterface.TYPE_CASTLE,playerMetrics);
		
        //do a bunch of calls to generate____Segment();
        
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
    public void generateRunSegment(MyLevel curLevel, int start, int end) { //needs params

    }
    /**
     * @author Nick Popescu
     */
    public void generateJumpSegment(LevelInterface curLevel, int start, int end) {
    	//int length = curLevel.length;
    	//int width = curLevel.width;
    	//int height = curLevel.height;
    	
    	
    	//curLevel.length += curLevel.buildStraightManual(length, length+(end-start), height-5, true);

    }
    /**
     * @author Aaron Friesen
     */
    public void generateKickSegment(LevelInterface curLevel, int start, int end) {

    }
    /**
     * @author Aaron Friesen
     */
    public void generateCollectSegment(LevelInterface curLevel, int start, int end) {

    }

}
