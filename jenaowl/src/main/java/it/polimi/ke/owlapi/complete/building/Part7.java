package it.polimi.ke.owlapi.complete.building;

import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

/**
 * Part 7: Reasoning with HermiT
 *
 *  Load the ontology of Part6
 *
 *  Get the instances of the student class
 *
 **/
public class Part7 {

    public static IRI base = IRI.create("http://example.org#");

    public static void main(String[] args) throws OWLOntologyCreationException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLReasonerFactory factory = new ReasonerFactory();

        OWLOntology o = manager.loadOntologyFromOntologyDocument(Part7.class.getClassLoader().getResourceAsStream("part6.owl.xml"));

        OWLClass student = o.getOWLOntologyManager().getOWLDataFactory().getOWLClass(base + "Student");

        o.logicalAxioms().forEach(System.err::println);

        OWLReasoner reasoner = factory.createReasoner(o);
        reasoner.precomputeInferences(InferenceType.CLASS_HIERARCHY);
        reasoner.getInstances(student).forEach(System.out::println);

    }

}
