package it.polimi.ke.owlapi.complete.building;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

/**
 * Part 1: The Simplest Ontology
 * <p>
 * Create An Ontology Manager
 * <p>
 * Create an Empty Ontology Passing the base URI to the manager
 * <p>
 * Obtain the OWLDataFactory instance from the ontology manager
 * <p>
 * Create a new OWLClass, e.g. Person, using the OWLDataFactory
 * <p>
 * IMPORTANT: the axiom is not added to the ontology
 * <p>
 * Add the new class to the ontology, using one of the alternative ways.
 * <p>
 * - Direct Add
 * - Manager Add
 * - Apply Change
 **/
public class Part1 {

    public static IRI base = IRI.create("http://example.org#");

    public static void main(String[] args) throws OWLOntologyCreationException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLOntology o = manager.createOntology(base);

        OWLDataFactory factory = o.getOWLOntologyManager().getOWLDataFactory();

        OWLClass person = factory.getOWLClass(base + "Person");

        OWLDeclarationAxiom axiom = factory.getOWLDeclarationAxiom(person);

        o.add(axiom);

        System.out.println(o);

    }

    public static void addFromManager() throws OWLOntologyCreationException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLOntology o = manager.createOntology(base);

        OWLDataFactory factory = o.getOWLOntologyManager().getOWLDataFactory();

        OWLClass person = factory.getOWLClass(base + "Person");

        OWLDeclarationAxiom axiom = factory.getOWLDeclarationAxiom(person);

        o.add(axiom);

        manager.addAxiom(o, axiom);

        AddAxiom change = new AddAxiom(o, axiom);
        manager.applyChange(change);

        System.out.println(o);
    }

    public static void applyChange() throws OWLOntologyCreationException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLOntology o = manager.createOntology(base);

        OWLDataFactory factory = o.getOWLOntologyManager().getOWLDataFactory();

        OWLClass person = factory.getOWLClass(base + "Person");

        OWLDeclarationAxiom axiom = factory.getOWLDeclarationAxiom(person);

        o.add(axiom);

        AddAxiom change = new AddAxiom(o, axiom);
        manager.applyChange(change);

        System.out.println(o);
    }
}
