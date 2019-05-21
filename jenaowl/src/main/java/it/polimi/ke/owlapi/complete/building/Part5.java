package it.polimi.ke.owlapi.complete.building;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.DLSyntaxDocumentFormat;
import org.semanticweb.owlapi.formats.OWLXMLDocumentFormat;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Part 5: Complex Assertion
 *
 * Student ≡ Person ⊓ (∃ attends.Course) ⊓ (∃ isEnrolledIn.University)
 *
 * Create an Named Individual with your own PersonCode and make it a Person
 * Create an Named Indivudal "polimi" and make it a University
 *
 * assert that you are enrolled in polimi.
 *
 *
 **/
public class Part5 {

    public static IRI base = IRI.create("http://example.org#");

    public static void main(String[] args) throws OWLOntologyCreationException, FileNotFoundException, OWLOntologyStorageException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLOntology o = manager.createOntology(base);

        OWLDataFactory factory = o.getOWLOntologyManager().getOWLDataFactory();

        OWLClass person = factory.getOWLClass(base + "Person");
        OWLClass student = factory.getOWLClass(base + "Student");
        OWLClass course = factory.getOWLClass(base + "Course");
        OWLClass univ = factory.getOWLClass(base + "University");

        OWLObjectProperty isEnrolledIn = factory.getOWLObjectProperty(base + "isEnrolledIn");
        OWLObjectProperty attends = factory.getOWLObjectProperty(base + "attends");


        OWLEquivalentClassesAxiom axiom = factory.getOWLEquivalentClassesAxiom(student,
                factory.getOWLObjectIntersectionOf(
                        person,
                        factory.getOWLObjectSomeValuesFrom(isEnrolledIn, univ),
                        factory.getOWLObjectSomeValuesFrom(attends, course)
                )
        );

        o.add(axiom);

        manager.saveOntology(o, new DLSyntaxDocumentFormat(), new FileOutputStream(new File("./part5.dl")));
        manager.saveOntology(o, new OWLXMLDocumentFormat(), new FileOutputStream(new File("./part5.owl.xml")));

    }

}
