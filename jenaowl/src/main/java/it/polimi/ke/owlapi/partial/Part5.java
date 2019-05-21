package it.polimi.ke.owlapi.partial;

import org.semanticweb.owlapi.model.*;

import java.io.FileNotFoundException;

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


    }

}
