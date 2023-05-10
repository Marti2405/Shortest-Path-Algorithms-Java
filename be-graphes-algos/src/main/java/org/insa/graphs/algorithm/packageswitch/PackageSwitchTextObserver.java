package org.insa.graphs.algorithm.packageswitch;

import java.io.PrintStream;

import org.insa.graphs.model.Node;

public class PackageSwitchTextObserver implements PackageSwitchObserver {


    private final PrintStream stream;

    public PackageSwitchTextObserver(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void notifyOriginProcessed(Node node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void notifyNodeReached(Node node) {
        stream.println("Node " + node.getId() + " reached.");
    }

    @Override
    public void notifyNodeMarked(Node node) {
        stream.println("Node " + node.getId() + " marked.");
    }

    @Override
    public void notifyDestinationReached(Node node) {
        // TODO Auto-generated method stub

    }

}
