package org.insa.graphs.algorithm.packageswitch;

import org.insa.graphs.algorithm.AbstractSolution;
import org.insa.graphs.algorithm.AbstractInputData.Mode;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Path;

public class PackageSwitchSolution extends AbstractSolution {

    private final Path path1;
    private final Path path2;


    /**
     * Create a new shortest-path solutions.
     * 
     * @param data Original input data for this solution.
     * @param status Status of the solution (FEASIBLE / OPTIMAL).
     * @param path Path corresponding to the solution.
     */

    protected PackageSwitchSolution(PackageSwitchData data, Status status) {
        super(data, status);
        this.path1 = null;
        this.path2 = null;
    }

    
    

    @Override
    public PackageSwitchData getInputData() {
        return (PackageSwitchData) super.getInputData();
    }

    /**
     * @return The path 1 of this solution, if any.
     */
    public Path getPath1() {
        return path1;
    }

    /**
     * @return The path 1 of this solution, if any.
     */
    public Path getPath2() {
        return path2;
    }

    @Override
    public String toString() {
        String info = null;
        if (!isFeasible()) {
            info = String.format("No path found from node #%d to node #%d and node #%d to node #%d",
                    getInputData().getOrigin1().getId(), getInputData().getDestination1().getId(),getInputData().getOrigin2().getId(), getInputData().getDestination2().getId());
        }
        else {
            double cost = 0;

            //Path1
            for (Arc arc: getPath1().getArcs()) {
                cost += getInputData().getCost(arc);
            }
            info = String.format("Found a path from node #%d to node #%d",
                    getInputData().getOrigin1().getId(), getInputData().getDestination1().getId());
            if (getInputData().getMode() == Mode.LENGTH) {
                info = String.format("%s, %.4f kilometers", info, cost / 1000.0);
            }
            else {
                info = String.format("%s, %.4f minutes", info, cost / 60.0);
            }


            //Path2
            for (Arc arc: getPath2().getArcs()) {
                cost += getInputData().getCost(arc);
            }
            info = String.format("Found a path from node #%d to node #%d",
                    getInputData().getOrigin2().getId(), getInputData().getDestination2().getId());
            if (getInputData().getMode() == Mode.LENGTH) {
                info = String.format("%s, %.4f kilometers", info, cost / 1000.0);
            }
            else {
                info = String.format("%s, %.4f minutes", info, cost / 60.0);
            }
        }
        info += " in " + getSolvingTime().getSeconds() + " seconds.";
        return info;
    }


}
