package it.polimi.ke.owlapi.complete.building;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

/**
 *  Part 2 (Cont'd): Adding a SubClassOf Axiom
 *
 *
 *  Create a new Class Woman
 *
 *  Assert Woman is subclass of Person
 *
 *  TryOut
 *
 *  Remove Woman and Person Declarations
 *  adding directly the SubClassOf axiom
 *
 *
 * **/
public class Part2 {

    public static IRI base = IRI.create("http://example.org#");

    public static void main(String[] args) throws OWLOntologyCreationException {


        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLOntology o = manager.createOntology(base);

        OWLDataFactory factory = o.getOWLOntologyManager().getOWLDataFactory();

        OWLClass person= factory.getOWLClass(base+"Person");
        OWLClass woman= factory.getOWLClass(base+"Woman");

        o.add(factory.getOWLDeclarationAxiom(person));
        o.add(factory.getOWLDeclarationAxiom(woman));
        o.add(factory.getOWLSubClassOfAxiom(woman, person));

        System.out.println(o);

    }

    public static void tryout() throws OWLOntologyCreationException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLOntology o = manager.createOntology(base);

        OWLDataFactory factory = o.getOWLOntologyManager().getOWLDataFactory();

        OWLClass person= factory.getOWLClass(base+"Person");
        OWLClass woman= factory.getOWLClass(base+"Woman");

        o.add(factory.getOWLSubClassOfAxiom(woman, person));

        System.out.println(o);

    }
}
