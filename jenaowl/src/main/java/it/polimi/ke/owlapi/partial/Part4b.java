package it.polimi.ke.owlapi.partial;

import org.semanticweb.owlapi.model.*;

import java.io.FileNotFoundException;

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


    }

}
