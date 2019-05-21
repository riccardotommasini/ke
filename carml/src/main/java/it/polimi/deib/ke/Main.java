package it.polimi.deib.ke;

import com.taxonic.carml.engine.RmlMapper;
import com.taxonic.carml.logical_source_resolver.CsvResolver;
import com.taxonic.carml.logical_source_resolver.JsonPathResolver;
import com.taxonic.carml.logical_source_resolver.XPathResolver;
import com.taxonic.carml.model.TriplesMap;
import com.taxonic.carml.util.RmlMappingLoader;
import com.taxonic.carml.vocab.Rdf;
import org.eclipse.rdf4j.model.*;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.util.Statements;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.sail.memory.MemoryStore;

import java.io.InputStream;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        InputStream file = Main.class.getResourceAsStream("/mapping.ttl");
        Set<TriplesMap> mapping =
                RmlMappingLoader
                        .build()
                        .load(RDFFormat.TURTLE,
                                file);

        RmlMapper mapper =
                RmlMapper
                        .newBuilder()
                        // Add the resolvers to suit your need
                        .setLogicalSourceResolver(Rdf.Ql.JsonPath, new JsonPathResolver())
                        .setLogicalSourceResolver(Rdf.Ql.XPath, new XPathResolver())
                        .setLogicalSourceResolver(Rdf.Ql.Csv, new CsvResolver())
                        // optional:
                        // specify IRI unicode normalization form (default = NFC)
                        // see http://www.unicode.org/unicode/reports/tr15/tr15-23.html
                        .iriUnicodeNormalization(Normalizer.Form.NFKC)
                        // set file directory for sources in mapping
                        .fileResolver(Paths.get("/Users/riccardo/_Projects/ke/classproject/src/main/resources"))
                        // set classpath basepath for sources in mapping
                        .classPathResolver("/Users/riccardo/_Projects/ke/classproject/src/main/resources")
                        .build();

        Model result = mapper.map(mapping);

        ValueFactory factory = SimpleValueFactory.getInstance();

        IRI ke = factory.createIRI("http://polimi.it/deib/ke/data#Knowledge%20Engineering");
        IRI sameas = factory.createIRI("http://www.w3.org/2002/07/owl#sameAs");
        IRI knoenng = factory.createIRI("http://polimi.it/deib/ke/data#KE");
        Statement nameStatement = factory.createStatement(ke,sameas,knoenng);

        result.add(nameStatement);
        //result.forEach(System.out::println);

        Repository db = new SailRepository(new MemoryStore());
        db.init();

        RepositoryConnection conn = db.getConnection();
        conn.add(result);


        TupleQuery tupleQuery = conn.prepareTupleQuery("" +
                "PREFIX : <http://polimi.it/deib/ke/onto#> " +
                "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
                "SELECT ( count(*) AS ?cnt) ?c " +
                "WHERE {  ?s a foaf:Person ; " +
                "            foaf:firstName ?name ;" +
                "            :attends ?c . }" +
                "GROUP BY ?c ");

        TupleQueryResult evaluate = tupleQuery.evaluate();

        List<String> bindingNames = evaluate.getBindingNames();

        while (evaluate.hasNext()) {
            BindingSet next = evaluate.next();
            bindingNames.forEach(s -> System.out.println(next.getValue(s).stringValue()));
        }

    }


}
