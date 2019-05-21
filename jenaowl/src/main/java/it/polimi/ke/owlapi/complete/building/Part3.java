package it.polimi.ke.owlapi.complete.building;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.DLSyntaxDocumentFormat;
import org.semanticweb.owlapi.formats.OWLXMLDocumentFormat;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 * Part 3 (Cont'd): Existential Restriction
 * <p>
 * Create a new Class Woman
 * <p>
 * Assert Woman is subclass of Person
 * <p>
 * TryOut
 * <p>
 * Remove Woman and Person Declarations
 * adding directly the SubClassOf axiom
 **/


public class Part3 {
    public static IRI base = IRI.create("http://example.org#");

    public static void main(String[] args) throws OWLOntologyCreationException, FileNotFoundException, OWLOntologyStorageException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLOntology o = manager.createOntology(base);

        OWLDataFactory factory = o.getOWLOntologyManager().getOWLDataFactory();

        OWLClass person = factory.getOWLClass(base + "Person");
        OWLClass parent = factory.getOWLClass(base + "Parent");

        OWLObjectProperty hasChild = factory.getOWLObjectProperty(base + "hasChild");

        OWLSubClassOfAxiom ax = factory.getOWLSubClassOfAxiom(
                parent,
                factory.getOWLObjectSomeValuesFrom(hasChild, person)
        );

        o.add(ax);

        o.logicalAxioms().forEach(System.out::println);

        manager.saveOntology(o, new DLSyntaxDocumentFormat(), new FileOutputStream(new File("./part3.dl")));
        manager.saveOntology(o, new OWLXMLDocumentFormat(), new FileOutputStream(new File("./part3.owl.xml")));

    }


    public static void main2(String[] args) throws OWLOntologyCreationException, FileNotFoundException, OWLOntologyStorageException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLOntology o = manager.createOntology(base);

        OWLDataFactory factory = o.getOWLOntologyManager().getOWLDataFactory();

        OWLClass A = factory.getOWLClass(base + "A");
        OWLClass B = factory.getOWLClass(base + "B");
        OWLClass C = factory.getOWLClass(base + "C");

        OWLObjectProperty P = factory.getOWLObjectProperty(base + "P");
        OWLObjectProperty Q = factory.getOWLObjectProperty(base + "Q");

        OWLSubClassOfAxiom ax = factory.getOWLSubClassOfAxiom(
                factory.getOWLObjectSomeValuesFrom(P, A),
                factory.getOWLObjectSomeValuesFrom(Q, B)
        );

        o.add(ax);

        o.logicalAxioms().forEach(System.out::println);

        manager.saveOntology(o, new DLSyntaxDocumentFormat(), new FileOutputStream(new File("./part3b.dl")));

    }

}
