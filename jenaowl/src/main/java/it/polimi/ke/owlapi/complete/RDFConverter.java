package it.polimi.ke.owlapi.complete;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.OWLXMLDocumentFormat;
import org.semanticweb.owlapi.formats.RDFXMLDocumentFormat;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class RDFConverter {

    public static void main(String[] args) throws OWLOntologyCreationException, FileNotFoundException, OWLOntologyStorageException {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology o = manager.loadOntologyFromOntologyDocument(RDFConverter.class.getClassLoader().getResourceAsStream("part6.owl.xml"));
        manager.saveOntology(o, new OWLXMLDocumentFormat(), new FileOutputStream(new File("./src/main/resources/part11.owl.xml")));
        manager.saveOntology(o, new RDFXMLDocumentFormat(), new FileOutputStream(new File("./src/main/resources/part11.rdf.xml")));

    }
}
