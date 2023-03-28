package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;

public class Label {

    private Node sommetCourant;
    private boolean marque;
    private double coutRealise;
    private Arc pere;


    public Label(Node sc, boolean m, double cr, Arc p){
        this.sommetCourant = sc;
        this.marque = m;
        this.coutRealise = cr;
        this.pere = p;
    }
    


    public Node getSommetCourant(){
        return this.sommetCourant;
    }
    public boolean getMarque(){
        return this.marque;
    }
    public double getCoutRealise(){
        return this.coutRealise;
    }
    public Arc getPere(){
        return this.pere;
    }
    public double getCost(){
        return this.coutRealise; //Pour l'instant, a modifier
    }


    
    public void setMarque(boolean b){
        this.marque =b;
    }
    public void setCoutRealise(double d){
        this.coutRealise= d;
    }
    public void setPere(Arc a){
        this.pere=a;
    }
    /*public void setCost(double a){
        this.coutRealise; //Pour l'instant, a modifier
    }*/
    

    
}
