package it.polimi.ke.owlapi.partial;

import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

/**
 * Part 8: Checking Concistency with HermiT
 * <p>
 * Load the ontology of Part6
 * <p>
 * Add the classes Teacher, and PhDStudent
 * <p>
 * Assert Teacher and Student as Disjoint Classes
 * <p>
 * Make PhDStudent subclass of the intersection between Student and Teacher
 * <p>
 * <p>
 * Is the ontology consistent?
 * <p>
 * The Ontology should be consistent.
 * <p>
 * Now Add an individual to the PhDStudent class (e.g. me)
 * <p>
 * Is the ontology consistent?
 * <p>
 * Did you forget to flush or create another reasoner?
 **/
public class Part8 {

    public static IRI base = IRI.create("http://example.org#");

    public static void main(String[] args) throws OWLOntologyCreationException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLReasonerFactory factory = new ReasonerFactory();

        //TODO

        OWLReasoner reasoner=null;

        if (reasoner.isConsistent())
            System.out.println("The ontology is consistent");
        else
            System.err.println("The ontology is NOT consistent");

        System.err.println("The ontology is NOT consistent");


    }

}
