package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class Player {

    static final String VERSION = "Yolo";
    public static int betRequest(JsonElement request) {

    	JsonObject jsonRequest = request.getAsJsonObject();
    	JsonArray orbits = jsonRequest.getAsJsonArray("orbits");

    	System.out.println(orbits);


    	JsonArray players = jsonRequest.getAsJsonArray("players");
    	JsonElement monkey = players.get(2);
    	JsonArray cards = ((JsonObject)monkey).getAsJsonArray("hole_cards");

    	JsonObject c1 = (JsonObject)cards.get(0);
    	JsonObject c2 = (JsonObject)cards.get(1);

    	/*
    	if(c1.get("rank").equals(c2.get("rank"))){
    		return 1000;
    	}*/

    	System.out.println(cards);
    	System.out.println(c1.get("rank"));
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