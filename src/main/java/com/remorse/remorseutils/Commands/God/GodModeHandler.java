package com.remorse.remorseutils.Commands.God;

import java.util.ArrayList;

public class GodModeHandler {

    private static ArrayList<String> godPlayers;
    // Initializer
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
