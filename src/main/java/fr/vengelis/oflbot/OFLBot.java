package fr.vengelis.oflbot;

import fr.vengelis.oflbot.utils.ConsoleLogger;

import java.util.logging.Level;

public class OFLBot {

    public static void main(String[] args) {
        ConsoleLogger.printLine(Level.INFO, "#------------------------------------------------------------------------------------#");
        ConsoleLogger.printLine(Level.INFO, "|   ___    _       _____   ____            _                                         |");
        ConsoleLogger.printLine(Level.INFO, "|  / _ \\  | |     |  ___| | __ )    ___   | |_                                       |");
        ConsoleLogger.printLine(Level.INFO, "| | | | | | |     | |_    |  _ \\   / _ \\  | __|                                      |");
        ConsoleLogger.printLine(Level.INFO, "| | |_| | | |___  |  _|   | |_) | | (_) | | |_                                       |");
        ConsoleLogger.printLine(Level.INFO, "|  \\___/  |_____| |_|     |____/   \\___/   \\__|                                      |");
        ConsoleLogger.printLine(Level.INFO, "|                                                                                    |");
        ConsoleLogger.printLine(Level.INFO, "|                                                         By Vengelis_               |");
        ConsoleLogger.printLine(Level.INFO, "#------------------------------------------------------------------------------------#");
        OFLBotApp app = new OFLBotApp();
    }

}
