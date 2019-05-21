package it.polimi.ke.jena.complete;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.FileNotFoundException;

/**
 * Part16a: Querying
 *
 * ASK
 **/

public class Part16b {

    public static void main(String[] args) throws FileNotFoundException {

        String uri = "http://example.org#";

        Model g1 = ModelFactory.createDefaultModel().read("./src/main/resources/part13.rdf.ttl");
        Model g2 = ModelFactory.createDefaultModel().read("./src/main/resources/part12.rdf.xml");

        Dataset ds = DatasetFactory.create();

        ds.addNamedModel(uri + "g1", g1);
        ds.addNamedModel(uri + "g2", g2);

        ds.getDefaultModel().write(System.err);

        ds.setDefaultModel(ds.getUnionModel());

        String q1 = "ASK WHERE { ?s a <http://example.org#Person> }";

        Query query = QueryFactory.create(q1);
        QueryExecution exec = QueryExecutionFactory.create(query, ds);

        System.out.println(exec.execAsk());


    }
}
