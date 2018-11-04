package dk.itu.mario.level;

import java.util.Random;

import dk.itu.mario.MarioInterface.Constraints;
import dk.itu.mario.MarioInterface.GamePlay;
import dk.itu.mario.MarioInterface.LevelInterface;
import dk.itu.mario.engine.sprites.SpriteTemplate;
import dk.itu.mario.engine.sprites.Enemy;
import dk.itu.mario.engine.LevelFactory;

public class CustomizedLevel extends Level implements LevelInterface {

    Random random;

    private static final int ODDS_STRAIGHT = 0;
    private static final int ODDS_HILL_STRAIGHT = 1;
    private static final int ODDS_TUBES = 2;
    private static final int ODDS_JUMP = 3;
    private static final int ODDS_CANNONS = 4;
    private static final int JumpingThreshold = 3;
    
    private int[] odds = new int[5];
    private int totalOdds;
    
    private int difficulty;
    private int type;
    private int gaps;
    private int turtles;
    private int coins;
    
    private GamePlay playerM;

    public CustomizedLevel(int width, int height, long seed, int difficulty,
                           int type, GamePlay playerMetrics) {
        super(width, height);
        this.playerM = playerMetrics;
        creat();
    }

    public void creat() {
        
        for(int i =0; i<100; i++)
        {
            setBlock(i,getHeight()-2, Level.HILL_TOP);
            setBlock(i,getHeight()-1,Level.GROUND); 
            setBlock(i,getHeight()-3,Level.COIN);
        }
        for(int i =5; i<10; i++)
        {
            setBlock(i,getHeight()-5, Level.HILL_TOP);
            setBlock(i,getHeight()-4,Level.GROUND); 
            setBlock(i,getHeight()-6,Level.COIN);
        }
        xExit=50;
        yExit=13;

    }
}