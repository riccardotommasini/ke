package it.polimi.ke.owlapi.complete.load;

import it.polimi.ke.owlapi.complete.building.Part9;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

/**
 *  Iterating the Ontology
 * <p>
 * Load the Pizza Ontology and get All the entities containing "P"
 **/
public class IteratingTheOntology {

    public static void main(String[] args) throws OWLOntologyCreationException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLOntology o = manager.loadOntologyFromOntologyDocument(Part9.class.getClassLoader().getResourceAsStream("pizza.owl.xml"));

        o.signature().filter(e -> (!e.isBuiltIn() && e.getIRI().getFragment().startsWith("P"))).forEach(System.out::println);

    }

}
