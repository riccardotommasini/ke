package it.polimi.ke.jena.partial;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Part12b: Reading and Converting
 *
 * Many RDF Serializations
 *
 * Turtle: TTL
 * JSON-LD
 * Notation 3: N-Triples
 *
 **/

public class Part13 {

    public static void main(String[] args) throws FileNotFoundException {

        Model model = ModelFactory.createDefaultModel().read("./src/main/resources/part11.rdf.xml");

    }
}
