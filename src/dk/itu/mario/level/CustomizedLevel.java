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

        int array[] = new int[400];
        for(int i =0;i<399;i++)
        {
            array[i] = Integer.parseInt(br.readLine());
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
                setBlock(i%100, getHeight()-1, Level.GROUND);
                setBlock(i%100, getHeight()-2, Level.HILL_TOP);
                if(i!=0)
                {
                	if(output[i-1]!=1)
                	{
                		setBlock(i%100, getHeight()-1, Level.HILL_LEFT);
                		setBlock(i%100, getHeight()-2, Level.HILL_TOP_LEFT);
                	}
                }
                if(output[i+1]!=1)
                {
                	setBlock(i%100, getHeight()-1, Level.HILL_RIGHT);                	
                	setBlock(i%100, getHeight()-2, Level.HILL_TOP_RIGHT);
                }
                if(i!=0)
				{
                	if(output[i-1]!=1 && output[i+1]!=1)
                	{
                	    setBlock((i%100)-1, getHeight()-1, Level.HILL_LEFT);
                		setBlock((i%100)-1, getHeight()-2, Level.HILL_TOP_LEFT);
                		setBlock(i%100, getHeight()-1, Level.HILL_RIGHT);                	
                		setBlock(i%100, getHeight()-2, Level.HILL_TOP_RIGHT);
                		i++;
               		}
               	}
                break;

                case 2:
                setBlock(i%100, 11-(i/100), Level.BLOCK_COIN);
                break;

                case 4:
                setBlock(i%100, 11-(i/100), Level.BLOCK_COIN);
                break;
                
                case 5:
                setBlock(i%100, 11-(i/100), Level.COIN);
                break;
                
                case 6:
                setBlock(i%100, 11-(i/100), Level.COIN);
                break;

                case 7:
                setBlock(i%100, 11-(i/100), Level.COIN);
                break;

                case 8:
                setBlock(i%100, 11-(i/100), Level.BLOCK_EMPTY);
                break;
                
                case 9:
                setBlock(i%100, 11-(i/100), Level.BLOCK_EMPTY);
                break;
                
                case 10:
                setBlock(i%100, 11-(i/100), Level.BLOCK_EMPTY);
                break;

                case 11:
                setBlock(i%100, 11-(i/100), Level.BLOCK_EMPTY);
                break;
                
                case 12:
                for (int j=0; j<(i/100); j++) 
                {
					setBlock((i%100-1), 12 - j, this.TUBE_SIDE_LEFT);				
					setBlock((i%100), 12 - j, this.TUBE_SIDE_RIGHT);							
				}
				setBlock((i%100-1), 12-(i/100), this.TUBE_TOP_LEFT);				
				setBlock((i%100), 12-(i/100), this.TUBE_TOP_RIGHT);	
                break;

                case 13:
                int goomba = SpriteTemplate.GOOMPA;
                setSpriteTemplate(i%100, 11-(1/100), new SpriteTemplate(goomba, false));
                break;
                
                case 14:
                int koopa = SpriteTemplate.RED_TURTLE;
                setSpriteTemplate(i%100, 11-(1/100), new SpriteTemplate(koopa, false));
                break;

                case 15:
                case 16:
                case 17:
                break;

                case 20:
                setBlock(i%100, 11-(i/100), Level.BLOCK_POWERUP);
                break;

            }

        }
        for(int i=100;i<130;i++)
        {
        	setBlock(i, getHeight()-1, Level.GROUND);
            setBlock(i, getHeight()-2, Level.HILL_TOP);
        }
        xExit=105;
        yExit=13;

    }
}