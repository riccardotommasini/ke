package it.polimi.ke.jena.complete;

import org.apache.jena.graph.Graph;
import org.apache.jena.graph.Triple;
import org.apache.jena.rdf.model.*;

/**
 * Part12a: Statements
 *
 * Statements represent RDF Facts <Subject, Predicate, Object>
 *
 *
 * A Model is a set of statements.
 *
 * Statement and Model build on the Triple and Graph interfaces.
 *
 * Statements are created through the a model instance, but
 * "createStatement" does NOT add the triple to the model
 *
 * They must be added explicitly
 *
 * Models can be iterated
 *
 **/

public class Part11b {

    public static void main(String[] args) {

        String uri = "http://example.org#";

        Model model = ModelFactory.createDefaultModel();

        Resource me = model.createResource(uri + 10324137);
        Resource ke = model.createResource(uri + "KnowledgeEngineering");
        Property teaches = model.createProperty(uri + "teaches");

        Statement statement = model.createStatement(me, teaches, ke);

        model.add(statement);

        Triple triple = statement.asTriple();

        Graph graph = model.getGraph();

        System.out.println(graph.contains(triple));

        StmtIterator stmtIterator = model.listStatements();

        while (stmtIterator.hasNext()) {

            System.out.println(stmtIterator.nextStatement());

        }

    }
}
