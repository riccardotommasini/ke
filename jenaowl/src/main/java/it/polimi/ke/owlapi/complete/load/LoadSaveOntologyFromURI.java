package it.polimi.ke.owlapi.complete.load;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.DLSyntaxDocumentFormat;
import org.semanticweb.owlapi.formats.FunctionalSyntaxDocumentFormat;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.io.FileOutputStream;
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
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology o = manager.loadOntology(IRI.create(uri));

        System.out.println(o);

        File funct = new File("./pizza.fun.owl");

        manager.saveOntology(o, new FunctionalSyntaxDocumentFormat(), new FileOutputStream(funct));

        File dl = new File("./pizza.dl");

        manager.saveOntology(o, new DLSyntaxDocumentFormat(), new FileOutputStream(dl));
    }
}
