package dk.itu.mario.level;

import java.util.Random;
import java.io.*;

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
                           int type, GamePlay playerMetrics) throws Exception{
        super(width, height);
        this.playerM = playerMetrics;
        creat();
    }

    public void creat() throws Exception {
        
        File file = new File("input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        int array[] = new int[500];
        for(int i =0;i<499;i++)
        {
            array[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<499;i++)
        {
            switch(array[i])
            {
                case 0:
                break;
                
                case 1:
                setBlock(i%100, getHeight()-1, Level.GROUND);
                setBlock(i%100, getHeight()-2, Level.HILL_TOP);
                break;

                case 2:
                setBlock(i%100, 13-(i/100), Level.BLOCK_EMPTY);
                break;

                case 3:
                setBlock(i%100, 13-(i/100), Level.BLOCK_COIN);
                break;
                
                case 4:
                setBlock(i%100, 13-(i/100), Level.BLOCK_POWERUP);
                break;
                
                case 5:
                setBlock(i%100, 13-(i/100), Level.COIN);
                break;

            }

        }
        for(int i=99;i<115;i++)
        {
            setBlock(i, getHeight()-1, Level.GROUND);
            setBlock(i, getHeight()-2, Level.HILL_TOP);
        }
        xExit=100;
        yExit=13;

    }
}