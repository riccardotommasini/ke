package it.polimi.ke.owlapi.complete.load;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.DLSyntaxDocumentFormat;
import org.semanticweb.owlapi.formats.FunctionalSyntaxDocumentFormat;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    private static final IRI food_uri=IRI.create("http://www.w3.org/TR/2003/PR-owl-guide-20031209/food");
    private static final IRI wine_uri=IRI.create("http://www.w3.org/TR/2003/PR-owl-guide-20031209/wine");

    public static void main(String[] args) throws OWLOntologyCreationException {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLOntology o = manager.loadOntology(IRI.create(uri));

        System.out.println("Axioms " + o.getAxiomCount() + "Format " + manager.getOntologyFormat(o));

        OWLOntology food_ontology = manager.getOntology(food_uri);
        OWLOntology wine_ontology = manager.getOntology(wine_uri);

    }
}
