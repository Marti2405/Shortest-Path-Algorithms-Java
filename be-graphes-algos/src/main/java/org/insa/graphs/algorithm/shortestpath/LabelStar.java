package org.insa.graphs.algorithm.shortestpath;


import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;



public class LabelStar  extends Label {

    private double heuristique;
    
   

    public LabelStar(Node sc, boolean m, double cr, Arc p, double heuristique){
        super(sc,m,cr,p);

        this.heuristique = heuristique;
       
    }



  

    public double getTotalCost(){

        return this.coutRealise + this.heuristique;
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
