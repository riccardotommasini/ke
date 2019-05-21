package it.polimi.ke.owlapi.complete.building;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.DLSyntaxDocumentFormat;
import org.semanticweb.owlapi.formats.OWLXMLDocumentFormat;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Part 4b: Deleting an Axiom
 * <p>
 * The Ontology part4a.owl.xml contains an erroneous
 * subClassOf axiom asserting Woman subClassOf Man
 * <p>
 * Load the ontology
 * remove the erroneous axiom
 * add the correct ones, i.e.,
 * Woman and Man are Disjoint subClassOf Person
 **/
public class Part4b {

    public static IRI base = IRI.create("http://example.org#");

    public static void main(String[] args) throws OWLOntologyCreationException, FileNotFoundException, OWLOntologyStorageException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLOntology o = manager.loadOntologyFromOntologyDocument(Part4b.class.getClassLoader().getResourceAsStream("part4a.owl.xml"));

        OWLDataFactory factory = o.getOWLOntologyManager().getOWLDataFactory();

        OWLClass person = factory.getOWLClass(base + "Person");
        OWLClass woman = factory.getOWLClass(base + "Woman");
        OWLClass man = factory.getOWLClass(base + "Man");

        OWLSubClassOfAxiom w_sub_m = factory.getOWLSubClassOfAxiom(woman, man);

        OWLSubClassOfAxiom w_sub_p = factory.getOWLSubClassOfAxiom(woman, person);
        OWLSubClassOfAxiom m_sub_p = factory.getOWLSubClassOfAxiom(man, person);

        OWLDisjointClassesAxiom w_not_m = factory.getOWLDisjointClassesAxiom(man, woman);

        o.removeAxiom(w_sub_m);
        o.add(w_sub_p, m_sub_p, w_not_m);

        manager.saveOntology(o, new DLSyntaxDocumentFormat(), new FileOutputStream(new File("./part4b.dl")));
        manager.saveOntology(o, new OWLXMLDocumentFormat(), new FileOutputStream(new File("./part4b.owl.xml")));

    }

}
