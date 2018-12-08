package ch.idsia.tools;

import ch.idsia.mario.engine.sprites.Mario;

import java.text.DecimalFormat;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy
 * Date: Apr 12, 2009
 * Time: 12:44:51 AM
 * Package: .Tools
 */
public class EvaluationInfo
{
    private static final int MagicNumberUndef = -42;
    public int levelType = MagicNumberUndef;
    public int marioStatus = MagicNumberUndef;
    public int livesLeft = MagicNumberUndef;
    public double lengthOfLevelPassedPhys = MagicNumberUndef;
    public int lengthOfLevelPassedCells = MagicNumberUndef;
    public int totalLengthOfLevelCells = MagicNumberUndef;
    public double totalLengthOfLevelPhys = MagicNumberUndef;
    public int timeSpentOnLevel = MagicNumberUndef;
    public int totalTimeGiven = MagicNumberUndef;
    public int numberOfGainedCoins = MagicNumberUndef;
//    public int totalNumberOfCoins = MagicNumberUndef;
    public int totalActionsPerfomed = MagicNumberUndef;
    public int totalFramesPerfomed = MagicNumberUndef;
    public int totalJumpsDone = MagicNumberUndef;
    // Number Of collisions with creatures
    // if large
    // if fire
    public String Memo = "";
    public int timeLeft = MagicNumberUndef;
    public String agentName = "undefinedAgentName";
    public String agentType = "undefinedAgentType";
    public int levelDifficulty = MagicNumberUndef;
    public int levelRandSeed = MagicNumberUndef;
    public int marioMode = MagicNumberUndef;
    public int killsTotal = MagicNumberUndef;

    public double computeBasicFitness()
    {
        // neglect totalActionsPerfomed;
        // neglect totalLengthOfLevelCells;
        // neglect totalNumberOfCoins;
        return lengthOfLevelPassedPhys - timeSpentOnLevel + numberOfGainedCoins + marioStatus*5000;
    }

    public double computeDistancePassed()
    {
        return lengthOfLevelPassedPhys;
    }

    public int computeKillsTotal()
    {
        return this.killsTotal;
    }

    //TODO: possible fitnesses adjustments: penalize for collisions with creatures and especially for  suicide. It's a sin.

    public double [] toDouble()
    {
        
        return new double[]
                {
                        marioStatus,
                        lengthOfLevelPassedPhys,
                        totalLengthOfLevelCells,
                        timeSpentOnLevel,
                        numberOfGainedCoins,
//                        totalNumberOfCoins,
                        totalActionsPerfomed,
                        totalFramesPerfomed,
                        computeBasicFitness()
                };
    }

    private DecimalFormat df = new DecimalFormat("0.00");

    public String toString()
    {
        return " ";
    }
}
