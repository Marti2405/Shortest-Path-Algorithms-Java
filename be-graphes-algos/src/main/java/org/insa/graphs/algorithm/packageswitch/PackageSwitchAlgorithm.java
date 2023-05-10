package org.insa.graphs.algorithm.packageswitch;


import org.insa.graphs.algorithm.AbstractAlgorithm;
import org.insa.graphs.model.Point;

public abstract class PackageSwitchAlgorithm extends AbstractAlgorithm<PackageSwitchObserver> {

    /**
     * Create a new PackageSwitchAlgorithm with the given data.
     * 
     * @param data
     */
    public PackageSwitchAlgorithm(PackageSwitchData data) {
        super(data);
        System.out.println("Checkpoint 50 ---------------\n");
        Point destination1 = data.getDestination1().getPoint();
        Point destination2 = data.getDestination2().getPoint();
        Point origin1 = data.getOrigin1().getPoint();
        Point origin2 = data.getOrigin2().getPoint();
        System.out.println("Checkpoint 51 ---------------\n");
        System.out.println(destination1);
        System.out.println(destination2);
        System.out.println(origin1);
        System.out.println(origin2);
    }

    @Override
    public PackageSwitchSolution run() {
        return (PackageSwitchSolution) super.run();
    }

    @Override
    protected abstract PackageSwitchSolution doRun();

    @Override
    public PackageSwitchData getInputData() {
        return (PackageSwitchData) super.getInputData();
    }

}
