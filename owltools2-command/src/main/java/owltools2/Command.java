package owltools2;

import org.apache.commons.cli.Options;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * A simple interface for all OWLTools2 commands.
 *
 * @author <a href="mailto:james@overton.ca">James A. Overton</a>
 */
public interface Command {
    /**
     * Name of the command.
     *
     * @return name
     */
    String getName();

    /**
     * Brief description of the command.
     *
     * @return description
     */
    String getDescription();

    /**
     * Command-line usage for the command.
     *
     * @return usage
     */
    String getUsage();

    /**
     * Command-line options for the command.
     *
     * @return options
     */
    Options getOptions();

    /**
     * All commands can be call from the Java command line with an
     * array of strings as arguments.
     *
     * @param args strings to use as arguments
     */
    void main(String[] args);

    /**
     * All commands offer an execute method that can be chained from
     * previous commands.
     *
     * @param inputOntology the ontology from the previous command, or null
     * @param args the command-line arguments
     * @return the updated ontology, or a new ontology, or null
     * @throws Exception on any problem
     */
    OWLOntology execute(OWLOntology inputOntology, String[] args)
            throws Exception;
}
