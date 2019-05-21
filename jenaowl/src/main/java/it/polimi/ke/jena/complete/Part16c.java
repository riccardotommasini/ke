package it.polimi.ke.jena.complete;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.FileNotFoundException;

/**
 * Part16a: Querying
 *
 * CONSTRUCT
 **/

public class Part16c {

    public static void main(String[] args) {

        String uri = "http://example.org#";

        Model g1 = ModelFactory.createDefaultModel().read("./src/main/resources/part12.rdf.xml");
        Model g2 = ModelFactory.createDefaultModel().read("./src/main/resources/part13.rdf.ttl");

        Dataset ds = DatasetFactory.create();

        ds.addNamedModel(uri + "g1", g1);
        ds.addNamedModel(uri + "g2", g2);

        ds.getDefaultModel().write(System.err);

        ds.setDefaultModel(ds.getUnionModel());

        String q1 = "PREFIX : <" + uri + ">" +
                "CONSTRUCT {?s a :Organization }" +
                "WHERE { " +
                "   GRAPH ?g { ?s a ?c   }" +
                "  FILTER (?c=:Institution || ?c=:University)" +
                "}";

        Query query = QueryFactory.create(q1);
        QueryExecution exec = QueryExecutionFactory.create(query, ds);

        Model model = exec.execConstruct();

        model.write(System.out);

    }
}
