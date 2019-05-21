package it.polimi.ke.owlapi.complete;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class IceBreaker {

    public static void main(String[] args){
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        System.out.println(manager.ontologies().count());
    }
}
