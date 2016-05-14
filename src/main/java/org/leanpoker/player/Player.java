package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Player {

	static final String VERSION = "Yolo";

	public static int betRequest(JsonElement request) {

		JsonObject jsonRequest = request.getAsJsonObject();

		// Round or Subgame
		int orbits = jsonRequest.get("orbits").getAsInt();

		System.out.println("Orbits " + orbits);

		/*
		 * JsonArray orbits = jsonRequest.getAsJsonArray("orbits");
		 * 
		 * System.out.println(orbits);
		 */

		JsonArray players = jsonRequest.getAsJsonArray("players");
		JsonElement monkey = players.get(2);
		JsonArray cards = ((JsonObject) monkey).getAsJsonArray("hole_cards");
		int money = ((JsonObject) monkey).get("stack").getAsInt();
		
		int currentBuyIn = jsonRequest.get("current_buy_in").getAsInt();

		JsonObject c1 = (JsonObject) cards.get(0);
		JsonObject c2 = (JsonObject) cards.get(1);

		if (c1.get("rank").equals(c2.get("rank"))) {
			System.out.println("Hurray weve got a pair");
			return money;
		}

		JsonArray communityCards = jsonRequest.getAsJsonArray("community_cards");
		
		for (JsonElement jsonElement : communityCards) {
			String rank = jsonElement.getAsJsonObject().get("rank").getAsString();
			String suit = jsonElement.getAsJsonObject().get("suit").getAsString();
			


			if (rank.equals(c1.get("rank"))) {
				if (rank.equals(c2.get("rank"))) {
					return money;
				}
				return currentBuyIn;
			}
			if (rank.equals(c2.get("rank"))) {
				return currentBuyIn;
			}
			
		}

		if (!c1.get("rank").equals(c2.get("rank")) && !c1.get("suit").equals(c2.get("suit"))) {
			return currentBuyIn > 100 ? currentBuyIn :0;
		}
		/*
		 * JsonObject c1 = (JsonObject)cards.get(0); JsonObject c2 =
		 * (JsonObject)cards.get(1);
		 * 
		 * 
		 * System.out.println(cards); System.out.println(c1.get("rank")); /*
		 * JsonObject jsonRequest = (JsonObject) request; JsonArray players =
		 * jsonRequest.getJsonArray("players"); JsonObject us =
		 * players.getJsonObject(2); System.out.println(us);
		 */

		int randomNum = 500 + (int) (Math.random() * ((1000 - 500) + 1));
		
		return randomNum;
	}

	public static void showdown(JsonElement game) {
	}
}