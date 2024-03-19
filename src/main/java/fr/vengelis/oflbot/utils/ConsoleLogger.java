/**
 * Created by Vengelis_.
 * Date: 10/17/2022
 * Time: 2:16 AM
 * Project: Lunatrix
 */

package fr.vengelis.oflbot.utils;

import java.util.ArrayList;
import java.util.logging.Level;

public class ConsoleLogger {

    private static Integer barLengh = 126;

    private static String getLevelString(Level level) {
        if (Level.SEVERE.equals(level)) {
            return "ERROR ";
        } else if (Level.WARNING.equals(level)) {
            return "WARNING";
        } else if (Level.INFO.equals(level)) {
            return "";
        } else if (Level.CONFIG.equals(level)) {
            return "CONFIG ";
        } else if (Level.FINE.equals(level)) {
            return "";
        } else if (Level.FINER.equals(level)) {
            return "";
        } else if (Level.FINEST.equals(level)) {
            return "";
        }
        return "";
    }

    public static void printSeparator(Level level) {
        StringBuilder spaceBar = new StringBuilder("-");
        for(int i = 0; i <= barLengh-1; i++) {
            spaceBar.append("-");
        }
        System.out.println("|" + ConsoleLogger.getLevelString(level) +  "| > " + "#" + spaceBar +"#");
    }

    public static void printLine(Level level, String message) {
        if(!level.equals(Level.FINEST)) System.out.println("|" + ConsoleLogger.getLevelString(level) +  "| > " + message);
    }

    public static void printLines(Level level, String[] messages) {
        for(String message : messages) {
            System.out.println("|" + ConsoleLogger.getLevelString(level) +  "| > " + message);
        }
    }

    public static void printLineBox(Level level, String message) {
        StringBuilder spaceBar = new StringBuilder("=");
        StringBuilder spaceBarSpace = new StringBuilder(" ");
        for(int i = 0; i <= barLengh-1; i++) {
            spaceBar.append("=");
            spaceBarSpace.append(" ");
        }
        System.out.println("|" + ConsoleLogger.getLevelString(level) +  "| > " + "#" + spaceBar +"#");
        if(message.trim().toCharArray().clone().length < barLengh - 4) {
            StringBuilder spacePhrase = new StringBuilder();
            for(int i = 0; i < (barLengh  - message.toCharArray().clone().length) / 2; i++) {
                spacePhrase.append(" ");
            }
            System.out.println("|" + ConsoleLogger.getLevelString(level) +  "| > " + "| " + spacePhrase + message + spacePhrase + "|");
        } else {
            ArrayList<String> lines = new ArrayList<>();
            StringBuilder line = new StringBuilder();
            int i = 0;
            for(char c: message.trim().toCharArray().clone()) {
                i++;
                line.append(c);
                if(i == barLengh - 4) {
                    i = 0;
                    lines.add(line.toString());
                    line = new StringBuilder();
                }
            }
            for(String linePhrase: lines) {
                StringBuilder spacePhrase = new StringBuilder();
                for(int j = 0; j < (barLengh - linePhrase.toCharArray().clone().length) / 2; j++) {
                    spacePhrase.append(" ");
                }
                System.out.println("|" + ConsoleLogger.getLevelString(level) +  "| > " + "| " + spacePhrase + linePhrase + spacePhrase + "|");
            }
        }
        System.out.println("|" + ConsoleLogger.getLevelString(level) +  "| > " + "#" + spaceBar +"#");
    }

    public static void printLinesBox(Level level, String[] message) {
        StringBuilder spaceBar = new StringBuilder("=");
        StringBuilder spaceBarSpace = new StringBuilder(" ");
        for(int i = 0; i <= barLengh-1; i++) {
            spaceBar.append("=");
            spaceBarSpace.append(" ");
        }
        System.out.println("|" + ConsoleLogger.getLevelString(level) +  "| > " + "#" + spaceBar +"#");

        for(String mess : message) {
            if(mess.trim().toCharArray().clone().length < barLengh - 4) {
                StringBuilder spacePhrase = new StringBuilder();
                for(int i = 0; i < (barLengh  - mess.toCharArray().clone().length) / 2; i++) {
                    spacePhrase.append(" ");
                }
                System.out.println("|" + ConsoleLogger.getLevelString(level) +  "| > " + "| " + spacePhrase + mess + spacePhrase + "|");
            } else {
                ArrayList<String> lines = new ArrayList<>();
                StringBuilder line = new StringBuilder();
                int i = 0;
                for(char c: mess.trim().toCharArray().clone()) {
                    i++;
                    line.append(c);
                    if(i == barLengh - 4) {
                        i = 0;
                        lines.add(line.toString());
                        line = new StringBuilder();
                    }
                }
                for(String linePhrase: lines) {
                    StringBuilder spacePhrase = new StringBuilder();
                    for(int j = 0; j < (barLengh - linePhrase.toCharArray().clone().length) / 2; j++) {
                        spacePhrase.append(" ");
                    }
                    System.out.println("|" + ConsoleLogger.getLevelString(level) +  "| > " + "| " + spacePhrase + linePhrase + spacePhrase + "|");
                }
            }
        }


        System.out.println("|" + ConsoleLogger.getLevelString(level) +  "| > " + "#" + spaceBar +"#");
    }

}
