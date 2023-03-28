package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;

public class Label {

    private int sommetCourant;
    private boolean marque;
    private int coutRealise;
    private Arc pere;


    public Label(int sc, boolean m, int cr, Arc p){
        this.sommetCourant = sc;
        this.marque = m;
        this.coutRealise = cr;
        this.pere = p;
    }
    


    public int getSommetCourant(){
        return this.sommetCourant;
    }
    public boolean getMarque(){
        return this.marque;
    }
    public int getCoutRealise(){
        return this.coutRealise;
    }
    public Arc getPere(){
        return this.pere;
    }
    public int getCost(){
        return this.coutRealise; //Pour l'instant, a modifier
    }

    
}
