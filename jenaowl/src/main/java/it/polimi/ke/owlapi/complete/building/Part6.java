package it.polimi.ke.owlapi.complete.building;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.DLSyntaxDocumentFormat;
import org.semanticweb.owlapi.formats.OWLXMLDocumentFormat;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Part 6 (cont'd): Named Individuals
 * <p>
 * Starting from the ontology of Part 5
 * <p>
 * Create a Named Individual with your own PersonCode and make it a Person
 * Create a Named Individual "polimi" and make it a University
 * Create a Named Individual "ke" and make it a Course
 * <p>
 * <p>
 * <p>
 * assert that you are enrolled in polimi and are attending ke.
 * <p>
 * TryOut
 * <p>
 * create another student and make him attending a course, without specifying which one.
 **/
public class Part6 {

    public static IRI base = IRI.create("http://example.org#");

    public static void main(String[] args) throws OWLOntologyCreationException, FileNotFoundException, OWLOntologyStorageException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLOntology o = manager.loadOntologyFromOntologyDocument(Part6.class.getClassLoader().getResourceAsStream("part5.owl.xml"));

        OWLDataFactory factory = o.getOWLOntologyManager().getOWLDataFactory();

        OWLClass person = factory.getOWLClass(base + "Person");
        OWLClass univ = factory.getOWLClass(base + "University");
        OWLClass course = factory.getOWLClass(base + "Course");

        OWLObjectProperty isEnrolledIn = factory.getOWLObjectProperty(base + "isEnrolledIn");
        OWLObjectProperty attends = factory.getOWLObjectProperty(base + "attends");

        OWLNamedIndividual me = factory.getOWLNamedIndividual("10324137");
        OWLNamedIndividual polimi = factory.getOWLNamedIndividual("polimi");
        OWLNamedIndividual ke = factory.getOWLNamedIndividual("ke");

        OWLClassAssertionAxiom ax1 = factory.getOWLClassAssertionAxiom(person, me);
        OWLClassAssertionAxiom ax2 = factory.getOWLClassAssertionAxiom(univ, polimi);
        OWLClassAssertionAxiom ax3 = factory.getOWLClassAssertionAxiom(course, ke);
        OWLObjectPropertyAssertionAxiom ax4 = factory.getOWLObjectPropertyAssertionAxiom(isEnrolledIn, me, polimi);
        OWLObjectPropertyAssertionAxiom ax5 = factory.getOWLObjectPropertyAssertionAxiom(attends, me, ke);

        o.add(ax1, ax2, ax3, ax4, ax5);

        manager.saveOntology(o, new DLSyntaxDocumentFormat(), new FileOutputStream(new File("./part6.dl")));
        manager.saveOntology(o, new OWLXMLDocumentFormat(), new FileOutputStream(new File("./part6.owl.xml")));


        OWLNamedIndividual marvin = factory.getOWLNamedIndividual("42424242");

        OWLObjectPropertyAssertionAxiom ax6 = factory.getOWLObjectPropertyAssertionAxiom(
                attends, marvin, factory.getOWLAnonymousIndividual());

        o.add(ax6);

        manager.saveOntology(o, new DLSyntaxDocumentFormat(), new FileOutputStream(new File("./part6b.dl")));
        manager.saveOntology(o, new OWLXMLDocumentFormat(), new FileOutputStream(new File("./part6b.owl.xml")));


    }

}
