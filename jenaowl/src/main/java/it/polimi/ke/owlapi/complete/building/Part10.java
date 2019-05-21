package it.polimi.ke.owlapi.complete.building;


import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.DLSyntaxDocumentFormat;
import org.semanticweb.owlapi.formats.OWLXMLDocumentFormat;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Part10: Annotations
 *
 * Annotations can be used to attach metadata to ontologies.
 * <p>
 * Annotations do not have any effect on the logical structure of
 * the ontology, but provide a way to enrich the ontology with meta-data.
 **/
public class Part10 {
    public static IRI base = IRI.create("http://example.org#");

    public static void main(String[] args) throws OWLOntologyCreationException, FileNotFoundException, OWLOntologyStorageException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLDataFactory factory = manager.getOWLDataFactory();
        OWLOntology o = manager.loadOntologyFromOntologyDocument(Part8.class.getClassLoader().getResourceAsStream("part6.owl.xml"));

        OWLClass student = factory.getOWLClass(base + "Student");
        OWLObjectProperty attends = factory.getOWLObjectProperty(base + "attends");


        OWLAnnotation comment1 = factory.getOWLAnnotation(factory.getRDFSComment(), factory.
                getOWLLiteral("Class representing Students in the University.", "en"));

        OWLAnnotationAssertionAxiom a1 = factory.getOWLAnnotationAssertionAxiom(student.getIRI(), comment1);

        OWLAnnotation comment2 = factory.getOWLAnnotation(factory.getRDFSComment(), factory.
                getOWLLiteral("Property asserting the participation in a course.", "en"));

        OWLAnnotationAssertionAxiom a2 = factory.getOWLAnnotationAssertionAxiom(attends.getIRI(), comment2);

        o.add(a1, a2);

        manager.saveOntology(o, new DLSyntaxDocumentFormat(), new FileOutputStream(new File("./part10.dl")));
        manager.saveOntology(o, new OWLXMLDocumentFormat(), new FileOutputStream(new File("./part10.owl.xml")));

    }
}
