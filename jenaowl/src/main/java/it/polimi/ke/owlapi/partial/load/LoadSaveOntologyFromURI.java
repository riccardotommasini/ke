package it.polimi.ke.owlapi.partial.load;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.io.IOException;

/**
 * An Ontology is usually located on the web, to be shared and reused.
 * <p>
 * OWL API offers through the OWLOntologyManager class, methods to load an ontology
 * directly from their remote location.
 * <p>
 * Moreover, using the same manager, we can save the donwloaded ontology locally.
 * <p>
 * Important:: Syntax Must be specified
 * <p>
 * - OWL/XML
 * - Functional
 * - Manchester
 * - Latex
 * - Turtle
 * - RDF/XML
 * - OBO
 * - DL
 * - KRSS
 **/
public class LoadSaveOntologyFromURI {

    private static final String uri = "https://protege.stanford.edu/ontologies/pizza/pizza.owl";

    public static void main(String[] args) throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {
    }
}
