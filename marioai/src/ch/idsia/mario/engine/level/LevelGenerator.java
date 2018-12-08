package ch.idsia.mario.engine.level;

import ch.idsia.mario.engine.sprites.Enemy;

import java.util.Random;
import java.io.*;

public class LevelGenerator
{
    public static final int TYPE_OVERGROUND = 0;
    public static final int TYPE_UNDERGROUND = 1;
    public static final int TYPE_CASTLE = 2;

    byte BLOCK_EMPTY = (byte) (0 + 1 * 16);
    byte BLOCK_POWERUP   = (byte) (4 + 2 + 1 * 16);
    byte BLOCK_COIN  = (byte) (4 + 1 + 1 * 16);
    byte GROUND      = (byte) (1 + 9 * 16);
    byte ROCK            = (byte) (9 + 0 * 16);
    byte COIN            = (byte) (2 + 2 * 16);


    byte LEFT_GRASS_EDGE = (byte) (0+9*16);
    byte RIGHT_GRASS_EDGE = (byte) (2+9*16);
    byte RIGHT_UP_GRASS_EDGE = (byte) (2+8*16);
    byte LEFT_UP_GRASS_EDGE = (byte) (0+8*16);
    byte LEFT_POCKET_GRASS = (byte) (3+9*16);
    byte RIGHT_POCKET_GRASS = (byte) (3+8*16);

    byte HILL_FILL = (byte) (5 + 9 * 16);
    byte HILL_LEFT = (byte) (4 + 9 * 16);
    byte HILL_RIGHT = (byte) (6 + 9 * 16);
    byte HILL_TOP = (byte) (5 + 8 * 16);
    byte HILL_TOP_LEFT = (byte) (4 + 8 * 16);
    byte HILL_TOP_RIGHT = (byte) (6 + 8 * 16);

    byte HILL_TOP_LEFT_IN = (byte) (4 + 11 * 16);
    byte HILL_TOP_RIGHT_IN = (byte) (6 + 11 * 16);

    byte TUBE_TOP_LEFT = (byte) (10 + 0 * 16);
    byte TUBE_TOP_RIGHT = (byte) (11 + 0 * 16);

    byte TUBE_SIDE_LEFT = (byte) (10 + 1 * 16);
    byte TUBE_SIDE_RIGHT = (byte) (11 + 1 * 16);

    private static Random levelSeedRandom = new Random();
    public static long lastSeed;
    public static final int LevelLengthMinThreshold = 50;

    public static Level createLevel(int width, int height, long seed, int difficulty, int type)
    {
        LevelGenerator levelGenerator = new LevelGenerator(width, height);
        return levelGenerator.createLevel(seed, difficulty, type);
    }

    private int width;
    private int height;
    Level level = new Level(100, 15);
    Random random;

    private static final int ODDS_STRAIGHT = 0;
    private static final int ODDS_HILL_STRAIGHT = 1;
    private static final int ODDS_TUBES = 2;
    private static final int ODDS_JUMP = 3;
    private static final int ODDS_CANNONS = 4;
    private int[] odds = new int[5];
    private int totalOdds;
    private int difficulty;
    private int type;

    private LevelGenerator(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    private Level createLevel(long seed, int difficulty, int type) 
    {
        int array[] = new int[400];
        try
        {
            File file = new File("input.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            for(int i =0;i<399;i++)
            {
                array[i] = Integer.parseInt(br.readLine());
            }
        }
        catch(Exception e)
        {
            System.err.println("Error");
        }
        int output[] = new int[400];
        for(int i=0;i<399;i++)
        {
            if(output[i]!=0)
            {
                continue;
            }
            switch(array[i])
            {
                case 0:
                output[i]=array[i];
                break;

                case 1:
                output[i]=array[i];
                break;

                case 2:
                output[i]=array[i];
                break;

                case 4:
                if(i%100 >= 97) 
                {
                    output[i] = array[i];
                    break;
                }
                else
                {
                    output[i] = array[i];
                    output[i+2] = array[i];
                    if(i<299)
                    {
                        output[i+101] = array[i];
                    }
                }   
                break;

                case 5:
                output[i]=array[i];
                break;


                case 6:
                if(i%100 >= 95)  
                {
                    output[i] = array[i];
                    break;
                }
                else
                {
                    output[i] = array[i];
                    output[i+2] = array[i];
                    output[i+4] = array[i];
                }   
                break;

                case 7:
                if(i%100 >= 95) 
                {
                    output[i] = array[i];
                    break;
                }
                else
                {
                    output[i] = array[i];
                    output[i+2] = array[i];
                    output[i+4] = array[i];

                    if(i<296)
                    {
                        output[i+101] = array[i];
                        output[i+103] = array[i];
                    }
                    if(i<198)
                    {
                        output[i+202] = array[i];
                    }

                }   
                break;


                case 8:
                    output[i] = array[i];
                break;


                case 9:
                if(i%100 >= 97)  
                {
                    output[i] = array[i];
                    break;
                }
                else
                {
                    output[i] = array[i];
                    output[i+2] = array[i];
                    if(i<299)
                    {
                        output[i+101] = array[i];
                    }
                }   
                break;


                case 10:
                if(i%100 >= 95)  
                {
                    output[i] = array[i];
                    break;
                }
                else
                {
                    output[i] = array[i];
                    if(i<299)
                    {
                        output[i+101] = array[i];
                    }
                    if(i<198)
                    {
                        output[i+202] = array[i];
                    }

                }   
                break;

                case 11:
                if(i%100 >= 95)  
                {
                    output[i] = array[i];
                    break;
                }
                else
                {
                    output[i] = array[i];
                    if(i>101)
                    {
                        output[i-99] = array[i];
                    }
                    if(i>202)
                    {
                        output[i-198] = array[i];
                    }

                }   
                break;

                case 12:
                output[i]=array[i];
                break;

                case 13:
                output[i]=array[i];
                break;

                case 14:
                output[i]=array[i];
                break;

                case 15:
                output[i]=15;
                output[i+1]=15;
                break;
    
                case 16:
                output[i]=16;   
                output[i+1]=16;
                output[i+2]=16;
                break;

                case 17:
                output[i]=17;
                output[i+1]=17;
                output[i+2]=17;
                output[i+3]=17;
                output[i+4]=17;
                break;

                case 20:
                output[i]=array[i];
                break;
            }
        }

        for(int i=0;i<399;i++)
        {
            switch(output[i])
            {
                case 0:
                break;
                
                case 1:
                level.setBlock(i%100, 15-1, GROUND);
                level.setBlock(i%100, 15-2, HILL_TOP);
                if(i!=0)
                {
                    if(output[i-1]!=1)
                    {
                        level.setBlock(i%100, 15-1, HILL_LEFT);
                        level.setBlock(i%100, 15-2, HILL_TOP_LEFT);
                    }
                }
                if(output[i+1]!=1)
                {
                    level.setBlock(i%100, 15-1, HILL_RIGHT);                   
                    level.setBlock(i%100, 15-2, HILL_TOP_RIGHT);
                }
                if(i!=0)
                {
                    if(output[i-1]!=1 && output[i+1]!=1)
                    {
                        level.setBlock((i%100)-1, 15-1, HILL_LEFT);
                        level.setBlock((i%100)-1, 15-2, HILL_TOP_LEFT);
                        level.setBlock(i%100, 15-1, HILL_RIGHT);                   
                        level.setBlock(i%100, 15-2, HILL_TOP_RIGHT);
                        i++;
                    }
                }
                break;

                case 2:
                level.setBlock(i%100, 11-(i/100), BLOCK_COIN);
                break;

                case 4:
                level.setBlock(i%100, 11-(i/100), BLOCK_COIN);
                break;
                
                case 5:
                level.setBlock(i%100, 11-(i/100), COIN);
                break;
                
                case 6:
                level.setBlock(i%100, 11-(i/100), COIN);
                break;

                case 7:
                level.setBlock(i%100, 11-(i/100), COIN);
                break;

                case 8:
                level.setBlock(i%100, 11-(i/100), BLOCK_EMPTY);
                break;
                
                case 9:
                level.setBlock(i%100, 11-(i/100), BLOCK_EMPTY);
                break;
                
                case 10:
                level.setBlock(i%100, 11-(i/100), BLOCK_EMPTY);
                break;

                case 11:
                level.setBlock(i%100, 11-(i/100), BLOCK_EMPTY);
                break;
                
                case 12:
                for (int j=0; j<(i/100); j++) 
                {
                    level.setBlock((i%100-1), 12 - j, this.TUBE_SIDE_LEFT);               
                    level.setBlock((i%100), 12 - j, this.TUBE_SIDE_RIGHT);                            
                }
                level.setBlock((i%100-1), 12-(i/100), this.TUBE_TOP_LEFT);                
                level.setBlock((i%100), 12-(i/100), this.TUBE_TOP_RIGHT); 
                break;

                case 13:
                int goomba = Enemy.ENEMY_GOOMBA;
                level.setSpriteTemplate(i%100, 11-(1/100), new SpriteTemplate(goomba, false));
                break;
                
                case 14:
                int koopa = Enemy.ENEMY_RED_KOOPA;
                level.setSpriteTemplate(i%100, 11-(1/100), new SpriteTemplate(koopa, false));
                break;

                case 15:
                case 16:
                case 17:
                break;

                case 20:
                level.setBlock(i%100, 11-(i/100), BLOCK_POWERUP);
                break;

            }

        }
        for(int i=100;i<130;i++)
        {
            level.setBlock(i, 15-1, GROUND);
            level.setBlock(i, 15-2, HILL_TOP);
        }
        level.xExit=100;
        level.yExit=13;
        return level;
    }
}