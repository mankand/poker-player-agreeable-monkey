package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
    	
    	JsonObject jsonRequest = request.getAsJsonObject();
    	JsonArray players = jsonRequest.getAsJsonArray("player");
    	System.out.println(players);
    /*
      JsonObject jsonRequest = (JsonObject) request;
      JsonArray players = jsonRequest.getJsonArray("players");
      JsonObject us = players.getJsonObject(2);
      System.out.println(us);*/

      return 1000;
    }

    public static void showdown(JsonElement game) {
    }
}
