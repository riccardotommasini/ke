package it.polimi.ke.jena.complete;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Part12b: Dataset
 * <p>
 * Dataset are sets of
 * a default RDF Graph
 * n >=0 (Named) RDF Graph
 * <p>
 * Dataset are the structure to perform SPARQL query on
 * <p>
 * their specification can be added in the SPARQL query
 * using FROM and FROM Named Clauses
 **/

public class Part15 {

    public static void main(String[] args) throws FileNotFoundException {

        String uri = "http://example.org#";

        Model g1 = ModelFactory.createDefaultModel().read("./src/main/resources/part13.rdf.ttl");
        Model g2 = ModelFactory.createDefaultModel().read("./src/main/resources/part12.rdf.xml");

        Dataset ds = DatasetFactory.create();

        ds.addNamedModel(uri + "g1", g1);
        ds.addNamedModel(uri + "g2", g2);

        ds.getDefaultModel().write(System.err);

        ds.getNamedModel(uri + "g1").write(System.out);
        ds.getNamedModel(uri + "g1").write(System.out);

        ds.setDefaultModel(ds.getUnionModel());

        ds.getDefaultModel().write(System.out);


        RDFDataMgr.write(new FileOutputStream(new File("./src/main/resources/part15.rdf.trig")), ds, Lang.TRIG);
    }
}
