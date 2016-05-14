package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class Player {

    static final String VERSION = "Yolo";
    static int i = 0;
    public static int betRequest(JsonElement request) {
    	if(i < 1){
    		i++;
    		return 0;
    	}
    	
    	JsonObject jsonRequest = request.getAsJsonObject();
    	JsonArray players = jsonRequest.getAsJsonArray("players");
    	JsonElement monkey = players.get(2);
    	JsonElement cards = ((JsonObject)monkey).getAsJsonArray("hole_cards");

    	System.out.println(i);
    	System.out.println(cards);
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
