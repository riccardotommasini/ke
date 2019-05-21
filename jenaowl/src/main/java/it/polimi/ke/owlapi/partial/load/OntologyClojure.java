package it.polimi.ke.owlapi.partial.load;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

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
public class OntologyClojure {

    private static final String uri = "http://www.w3.org/TR/owl-guide/wine.rdf";
    private static final IRI food_uri = IRI.create("http://www.w3.org/TR/2003/PR-owl-guide-20031209/food");
    private static final IRI wine_uri = IRI.create("http://www.w3.org/TR/2003/PR-owl-guide-20031209/wine");

    public static void main(String[] args) throws OWLOntologyCreationException {


    }
}
