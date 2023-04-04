package org.insa.graphs.algorithm.shortestpath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

import javax.sound.midi.Patch;

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
        
        while (current!=data.getDestination()){

            ///On regarde tous les successeurs et on met a jour leurs labels si ont trouve un chemin plus opti
            for (Arc arc : current.getSuccessors()){
                //si on a un chemin plus opti
                Label labDest = getLabelfromNode(arc.getDestination());
                Label labCurrent = getLabelfromNode(current);
                if (labDest.getCoutRealise()>labCurrent.getCoutRealise()+arc.getLength()){
                    //on actualise le cout
                    labDest.setCoutRealise(labCurrent.getCoutRealise()+arc.getLength());
                    //on actualise le pere
                    labDest.setPere(arc);
                }
            }
            //Le tableau est mis à jour, on trouve maintenant le prochain sommet current avec un min des sommets qui sont pas marqués
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


        }

        //Construction de la solution, on part de la destination puis on remonte avec les peres dans les labels
        Stack<Arc> solutionArcList = new Stack<Arc>();
        Label currentLabel = getLabelfromNode(current);
        Label originLabel = getLabelfromNode(data.getOrigin());

        while (currentLabel!=originLabel){
            solutionArcList.push(currentLabel.getPere());
            currentLabel = getLabelfromNode(currentLabel.getPere().getOrigin());
        }

        Path solutionPath = new Path(data.getGraph(), solutionArcList);

        solution = new ShortestPathSolution(data, null,solutionPath);


        return solution;
    }

}
