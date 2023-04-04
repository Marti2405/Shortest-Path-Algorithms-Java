package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;

public class Label implements Comparable<Label>{

    protected Node sommetCourant;
    protected boolean marque;
    protected double coutRealise;
    protected Arc pere;
    protected boolean vue;


    public Label(Node sc, boolean m, double cr, Arc p){
        this.sommetCourant = sc;
        this.marque = m;
        this.coutRealise = cr;
        this.pere = p;
        this.vue = false;
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
    public boolean getVue(){
        return this.vue;
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
    public void setVue(boolean b){
        this.vue = b;
    }


    public int compareTo(Label lab){
        int result = 0;
        if (this.coutRealise<lab.coutRealise){
            result = -1;
        }
        else if (this.coutRealise>lab.coutRealise) {
            result = 1;
        }
        return result;
    }

    
}
