package org.insa.graphs.algorithm.shortestpath;


import java.util.ArrayList;
import java.util.Collections;

import org.insa.graphs.algorithm.AbstractSolution.Status;
import org.insa.graphs.algorithm.utils.BinaryHeap;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;
import org.insa.graphs.model.Path;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    private ArrayList<Label> labelList = new ArrayList<Label>() ;
    Node current;


    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
        
        for (Node e : data.getGraph().getNodes()){
            Label lab = new Label(e, false, Double.MAX_VALUE, null);
            if (data.getOrigin() == e ){
                lab.setCoutRealise(0.0);
                lab.setMarque(true);
                current = e;
            }
            labelList.add(lab);
        }
    }
    //Mr.lebotlan vous l'avait "pas" dit -> corrigé :)
    private Label getLabelfromNode(Node e){
        return labelList.get(e.getId());
    }

    
    @Override
    protected ShortestPathSolution doRun() {
        final ShortestPathData data = getInputData();
        ShortestPathSolution solution = null;
        BinaryHeap<Label> heaplab = new BinaryHeap<Label>();

        
        
        
        while (current!=data.getDestination()){

            ///On regarde tous les successeurs et on met a jour leurs labels si ont trouve un chemin plus opti
            for (Arc arc : current.getSuccessors()){

                //si on a un chemin plus opti
                Label labDest = getLabelfromNode(arc.getDestination());
                Label labCurrent = getLabelfromNode(current);
                if (labDest.getCoutRealise()>labCurrent.getCoutRealise()+arc.getLength()){

                    //si on a vu ou pas deja vu le label
                    if (labDest.getVue()){
                        heaplab.remove(labDest);
                    }else {
                        labDest.setVue(true);
                    }
                    //on actualise le cout
                    labDest.setCoutRealise(labCurrent.getCoutRealise()+arc.getLength());
                    
                    //on actualise le pere
                    labDest.setPere(arc);

                    //on ajoute le successeur mis a jour
                    heaplab.insert(labDest);
                }
            }
            //Le tableau est mis à jour, on trouve maintenant le prochain sommet current avec un min des sommets qui sont pas marqués
            current = heaplab.deleteMin().getSommetCourant();
            getLabelfromNode(current).setMarque(true);
            notifyNodeReached(current);
            /*
            double min = Double.MAX_VALUE;
            Label labelCurrent = null;
            for (Label recherche : labelList){
                if (recherche.getMarque()==false){
                    if (min>recherche.getCoutRealise()){
                        min = recherche.getCoutRealise();
                        labelCurrent = recherche;
                    }
                }
            }

            //On a le label minimum pas marqué, maintenant on met a jour le noeud current auquel on se trouve
            current = labelCurrent.getSommetCourant();
            getLabelfromNode(current).setMarque(true);
            notifyNodeReached(current);
            */

        }


        
        //Construction de la solution, on part de la destination puis on remonte avec les peres dans les labels
        ArrayList<Arc> solutionArcList = new ArrayList<Arc>();
        Label currentLabel = getLabelfromNode(current);
        Label originLabel = getLabelfromNode(data.getOrigin());

        
        
        while (currentLabel!=originLabel){
            solutionArcList.add(currentLabel.getPere());
            currentLabel = getLabelfromNode(currentLabel.getPere().getOrigin());
        }

        Collections.reverse(solutionArcList);

        Path solutionPath = new Path(data.getGraph(), solutionArcList);

        solution = new ShortestPathSolution(data, Status.OPTIMAL ,solutionPath);


        return solution;
        
        
        
        
    }

}


