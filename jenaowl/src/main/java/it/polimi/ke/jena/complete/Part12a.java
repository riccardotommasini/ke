package it.polimi.ke.jena.complete;

import org.apache.jena.rdf.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Part12a: Resources
 * <p>
 * <p>
 * A resource is anything identifiable by a IRI.
 * <p>
 * Resources have properties, which are also identified by IRI.
 * I.E. properties are resouces too.
 * <p>
 * Literals, i.e., primitive types are not resources.
 * <p>
 * Note:
 * <p>
 * Each call to addProperty also add the triple to the model
 **/

public class Part12a {

    public static void main(String[] args) throws FileNotFoundException {

        String uri = "http://example.org#";

        Model model = ModelFactory.createDefaultModel();

        Resource me = model.createResource(uri + 10324137);

        Property p = model.createProperty(uri + "fullname");

        Resource name = model.createResource(uri + "RiccardoTommasini");

        Resource subject = me.addProperty(p, name);

        System.out.println(subject);

        StmtIterator stmtIterator = model.listStatements();

        while (stmtIterator.hasNext()) {

            System.err.println(stmtIterator.nextStatement());

        }

    }
}
