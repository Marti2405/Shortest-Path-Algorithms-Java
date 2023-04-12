package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;
import org.insa.graphs.model.Point;


public class LabelStar  extends Label {

    private Point destination;

   

    public LabelStar(Node sc, boolean m, double cr, Arc p, Point destination){
        super(sc,m,cr,p);
        this.destination = destination;
       
    }



  

    public double getTotalCost(){
        return this.coutRealise + this.sommetCourant.getPoint().distanceTo(this.destination);
    }

    @Override
    public int compareTo(Label lab){
        LabelStar lab2 = (LabelStar)lab;
        int result = 0;
        if (this.getTotalCost()<lab2.getTotalCost()){
            result = -1;
        }
        else if (this.getTotalCost()>lab2.getTotalCost()) {
            result = 1;
        }
        return result;
    }


  
}
