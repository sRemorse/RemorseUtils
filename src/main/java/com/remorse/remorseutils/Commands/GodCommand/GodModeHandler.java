package com.remorse.remorseutils.Commands.GodCommand;

import java.util.ArrayList;

public class GodModeHandler {

    private static ArrayList<String> godPlayers;
    // Initialiser
    public GodModeHandler(){
        godPlayers = new ArrayList<String>();
    }

    public static ArrayList<String> getGodPlayers() {
        return godPlayers;
    }

    public static void addPlayer(String name){
        godPlayers.add(name);
    }

    public static void removePlayer(String name){
        godPlayers.remove(name);
    }

}
