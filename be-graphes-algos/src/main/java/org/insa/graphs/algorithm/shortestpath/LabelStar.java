package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;
import org.insa.graphs.model.Point;

public class LabelStar extends Label {

    

    public LabelStar(Node sc, boolean m, double cr, Arc p){
        super(sc,m,cr,p);
        
    }

    public double getTotalCost(LabelStar origine){
        return this.coutRealise + this.sommetCourant.getPoint().distanceTo(origine.getSommetCourant().getPoint());
    }

    
    public int compareTo(LabelStar lab, LabelStar origine){
        int result = 0;
        if (this.getTotalCost(origine)<lab.getTotalCost(origine)){
            result = -1;
        }
        else if (this.getTotalCost(origine)>lab.getTotalCost(origine)) {
            result = 1;
        }
        return result;
    }


  
}
