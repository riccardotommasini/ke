package it.polimi.ke.jena.complete;

import org.apache.jena.graph.Graph;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.graph.Triple;
import org.apache.jena.sparql.graph.GraphFactory;

/**
 * Part12a: Managing Triples
 * <p>
 * Work at a very low level, they are basic block of Statements
 *
 * Graphs are sets of triples
 **/

public class Part11a {

    public static void main(String[] args) {

        String uri = "http://example.org#";

        Node me = NodeFactory.createURI(uri + 10324137);
        Node ke = NodeFactory.createURI(uri + "KnowledgeEngineering");
        Node teaches = NodeFactory.createURI(uri + "teaches");

        Triple triple = new Triple(me, teaches, ke);

        Graph g = GraphFactory.createGraphMem();

        g.add(triple);

        System.out.println(triple);
        System.out.println(g);

    }
}
