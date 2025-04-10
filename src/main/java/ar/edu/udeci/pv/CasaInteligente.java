package ar.edu.udeci.pv;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CasaInteligente {

    private static final Logger logger = LogManager.getLogger(CasaInteligente.class);

    public static void main(String[] args) {

        // Definir opciones
        Options options = new Options();

        options.addOption("el", "encender-luz", false, "Enciende la luz de la casa");
        options.addOption("al", "apagar-luz", false, "Apaga la luz de la casa");
        options.addOption("t", "temperatura", true, "Establece la temperatura deseada");
        options.addOption("m", "modo", true, "Establece el modo de funcionamiento [eco, normal, turbo]");
        options.addOption("h", "help", false, "Muestra la ayuda");

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("CasaInteligente", options);
                return;
            }

            if (cmd.hasOption("encender-luz")) {
                logger.info("🔆 La luz ha sido encendida.");
            }

            if (cmd.hasOption("apagar-luz")) {
                logger.info("💡 La luz ha sido apagada.");
            }

            if (cmd.hasOption("temperatura")) {
                String temp = cmd.getOptionValue("temperatura");
                logger.info("🌡️ Temperatura establecida en " + temp + "°C.");
            }

            if (cmd.hasOption("modo")) {
                String modo = cmd.getOptionValue("modo");
                switch (modo.toLowerCase()) {
                    case "eco":
                    case "normal":
                    case "turbo":
                        logger.info("⚙️ Modo de funcionamiento: " + modo);
                        break;
                    default:
                        logger.warn("🚫 Modo no reconocido: " + modo + ". Usar: eco, normal o turbo.");
                        break;
                }
            }

            if (!cmd.hasOption("encender-luz") && !cmd.hasOption("apagar-luz") &&
                    !cmd.hasOption("temperatura") && !cmd.hasOption("modo")) {
                logger.warn("⚠️ No se proporcionaron acciones. Usa --help para ver las opciones.");
            }

        } catch (ParseException e) {
            logger.error("Error al parsear los argumentos: " + e.getMessage());
        }
    }
}
