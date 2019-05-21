package it.polimi.ke.owlapi.complete.load;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 *
 * OWL Ontology Manager is the central class to manager your ontologies.
 * It handles:
 *  - creation
 *  - loading, and
 *  - saving.
 *
 *  Moreover, it allows to interfact with your ontologies adding and removing
 *  annotations, imports, and axioms.
 *
 *
 * **/
public class CreateOntology {

    public static void main(String[] agrgs) throws OWLOntologyCreationException {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLOntology onto = manager.createOntology();

        System.out.println(onto);


    }
}
