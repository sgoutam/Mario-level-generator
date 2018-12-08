package ch.idsia.ai.tasks;

import ch.idsia.ai.agents.Agent;
import ch.idsia.tools.EvaluationInfo;
import ch.idsia.tools.EvaluationOptions;
import ch.idsia.tools.Evaluator;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy
 * Date: Apr 8, 2009
 * Time: 11:26:43 AM
 * Package: ch.idsia.ai.tasks
 */
public class ProgressTask implements Task {

    private EvaluationOptions options;

    public ProgressTask(EvaluationOptions evaluationOptions) {
        setOptions(evaluationOptions);
    }

    public String evaluate(Agent controller) {
        double distanceTravelled = 0;
        String output=""; 
        options.setAgent(controller);
        Evaluator evaluator = new Evaluator(options);
        List<EvaluationInfo> results = evaluator.evaluate();
        for (EvaluationInfo result : results) {
            output= "Playable True";
            int timeTaken = result.timeSpentOnLevel;
            output = output+ " Time taken: " + timeTaken;
            int marioStatusOut = result.marioStatus;
            output = output+ " Mario Status: " + marioStatusOut;
            int actionsPerformed = result.totalActionsPerfomed;
            output = output + " Actions Done: " + actionsPerformed;
            int jumpsDone = result.totalJumpsDone;
            output = output + " Jumps Done: "  + jumpsDone;
            distanceTravelled += result.computeDistancePassed();
        }

        return output;
    }

    public void setOptions(EvaluationOptions options) {
        this.options = options;
    }

    public EvaluationOptions getOptions() {
        return options;
    }

}
