package org.insa.graphs.algorithm.packageswitch;

import org.insa.graphs.algorithm.AbstractInputData;
import org.insa.graphs.algorithm.ArcInspector;
import org.insa.graphs.model.Graph;
import org.insa.graphs.model.Node;

public class PackageSwitchData extends AbstractInputData {

    private final Node origin1, destination1, origin2, destination2;

    public PackageSwitchData(Graph graph, Node origin1, Node destination1, Node origin2, Node destination2, ArcInspector arcFilter) {
        super(graph, arcFilter);
        this.origin1 = origin1;
        this.destination1 = destination1;
        this.origin2 = origin2;
        this.destination2 = destination2;
    }



    /**
     * @return Origin node for the path 1.
     */
    public Node getOrigin1() {
        return origin1;
    }

    /**
     * @return Destination node for the path 1.
     */
    public Node getDestination1() {
        return destination1;
    }

    /**
     * @return Origin node for the path 2.
     */
    public Node getOrigin2() {
        return origin2;
    }

    /**
     * @return Destination node for the path 2.
     */
    public Node getDestination2() {
        return destination2;
    }


    @Override
    public String toString() {
        return "Shortest-path crossing from #" + origin1.getId() + " to #" + destination1.getId() + " ["
                + this.arcInspector.toString().toLowerCase() + "]" +
                "and from #" + origin2.getId() + " to #" + destination2.getId() + " ["
                + this.arcInspector.toString().toLowerCase() + "]";
    }

}
