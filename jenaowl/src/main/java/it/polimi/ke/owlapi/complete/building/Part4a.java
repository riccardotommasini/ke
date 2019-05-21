package it.polimi.ke.owlapi.complete.building;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.DLSyntaxDocumentFormat;
import org.semanticweb.owlapi.formats.OWLXMLDocumentFormat;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Part 4a: create the Ontology part4a.owl.xml which contains an erroneous
 * subClassOf axiom asserting Woman subClassOf Man
 **/
public class Part4a {

    public static IRI base = IRI.create("http://example.org#");

    public static void main(String[] args) throws OWLOntologyCreationException, FileNotFoundException, OWLOntologyStorageException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLOntology o = manager.createOntology(base);

        OWLDataFactory factory = o.getOWLOntologyManager().getOWLDataFactory();

        OWLClass woman = factory.getOWLClass(base + "Woman");
        OWLClass man = factory.getOWLClass(base + "Man");

        OWLSubClassOfAxiom w_sub_m = factory.getOWLSubClassOfAxiom(woman, man);

        o.add(w_sub_m);

        manager.saveOntology(o, new DLSyntaxDocumentFormat(), new FileOutputStream(new File("part4a.dl")));
        manager.saveOntology(o, new OWLXMLDocumentFormat(), new FileOutputStream(new File("part4a.owl.xml")));

    }

}
