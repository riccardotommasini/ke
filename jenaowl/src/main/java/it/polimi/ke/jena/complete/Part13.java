package it.polimi.ke.jena.complete;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

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

        model.write(new FileOutputStream(new File("./src/main/resources/part13.rdf.ttl")), "TTL");
        model.write(new FileOutputStream(new File("./src/main/resources/part13.rdf.jsonld")), "JSON-LD");
        model.write(new FileOutputStream(new File("./src/main/resources/part13.rdf.n3")), "N-Triples");

    }
}
