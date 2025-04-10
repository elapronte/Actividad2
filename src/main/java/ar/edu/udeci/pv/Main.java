package ar.edu.udeci.pv;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        PrintWriter out;
        try {
            out = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("No se pudo establecer UTF-8 como codificación de salida", e);
        }

        Options options = new Options();

        Option nameOption = new Option("n", "name", true, "Tu nombre");
        nameOption.setRequired(false);
        options.addOption(nameOption);

        Option fileOption = new Option("f", "file", true, "Ruta al archivo de entrada");
        fileOption.setRequired(false);
        options.addOption(fileOption);

        Option verboseOption = new Option("v", "verbose", false, "Modo verboso");
        verboseOption.setRequired(false);
        options.addOption(verboseOption);

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            String name = cmd.getOptionValue("name", "Mundo");
            String filePath = cmd.getOptionValue("file");
            boolean isVerbose = cmd.hasOption("verbose");

            if (isVerbose) {
                logger.info("Modo verboso activado");
            }

            logger.info("Iniciando aplicación");
            logger.debug("Argumentos recibidos: name=" + name + ", file=" + filePath + ", verbose=" + isVerbose);

            out.println("Hola, " + name + "!");
            if (filePath != null) {
                out.println("Archivo especificado: " + filePath);
            }

            logger.info("Aplicación finalizada correctamente");

        } catch (ParseException e) {
            logger.error("Error al parsear argumentos: " + e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar Actividad2.jar", options);
        }
    }
}
