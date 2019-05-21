package it.polimi.ke.owlapi.complete.building;

import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.DLSyntaxDocumentFormat;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
 *
 * The Ontology should be consistent.
 *
 * Now Add an individual to the PhDStudent class (e.g. me)
 *
 * Is the ontology consistent?
 *
 * Did you forget to flush or create another reasoner?
 *
 *  **/
public class Part8 {

    public static IRI base = IRI.create("http://example.org#");

    public static void main(String[] args) throws OWLOntologyCreationException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLReasonerFactory factory = new ReasonerFactory();

        OWLOntology o = manager.loadOntologyFromOntologyDocument(Part8.class.getClassLoader().getResourceAsStream("part6.owl.xml"));

        OWLDataFactory dataFactory = o.getOWLOntologyManager().getOWLDataFactory();
        OWLClass student = dataFactory.getOWLClass(base + "Student");
        OWLClass teacher = dataFactory.getOWLClass(base + "Teacher");
        OWLClass demonstrator = dataFactory.getOWLClass(base + "PhDStudent");

        OWLDisjointClassesAxiom t_not_s = dataFactory.getOWLDisjointClassesAxiom(teacher, student);

        OWLSubClassOfAxiom ax = dataFactory.getOWLSubClassOfAxiom(demonstrator,
                dataFactory.getOWLObjectIntersectionOf(teacher, student)
        );

        o.add(t_not_s, ax);

        try {
            manager.saveOntology(o, new DLSyntaxDocumentFormat(), new FileOutputStream(new File("./part8a.dl")));
        } catch (OWLOntologyStorageException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        OWLReasoner reasoner = factory.createReasoner(o);

        if (reasoner.isConsistent())
            System.out.println("The ontology is consistent");
        else
            System.err.println("The ontology is NOT consistent");


        OWLNamedIndividual me = dataFactory.getOWLNamedIndividual(base + "10324137");

        OWLClassAssertionAxiom ax1 = dataFactory.getOWLClassAssertionAxiom(demonstrator, me);

        o.add(ax1);


        System.out.println("Flushed!");
        reasoner.flush();

        if (reasoner.isConsistent())
            System.out.println("The ontology is consistent");
        else
            System.err.println("The ontology is NOT consistent");


        OWLReasoner reasoner1 = factory.createReasoner(o);

        if (reasoner1.isConsistent())
            System.out.println("The ontology is consistent");
        else
            System.err.println("The ontology is NOT consistent");


        try {
            manager.saveOntology(o, new DLSyntaxDocumentFormat(), new FileOutputStream(new File("./part8b.dl")));
        } catch (OWLOntologyStorageException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
