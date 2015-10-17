package org.leanpoker.player;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.jsonconverter.JsonConverter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest {

    private String testJson = "{\n"
            + "  \"small_blind\": 10,\n"
            + "  \"current_buy_in\": 320,\n"
            + "  \"pot\": 400,\n"
            + "  \"minimum_raise\": 240,\n"
            + "  \"dealer\": 1,\n"
            + "  \"orbits\": 7,\n"
            + "  \"in_action\": 1,\n"
            + "  \"players\": [\n"
            + "    {\n"
            + "      \"id\": 0,\n"
            + "      \"name\": \"Albert\",\n"
            + "      \"status\": \"active\",\n"
            + "      \"version\": \"Default random player\",\n"
            + "      \"stack\": 1010,\n"
            + "      \"bet\": 320\n"
            + "    },\n"
            + "    {\n"
            + "      \"id\": 1,\n"
            + "      \"name\": \"Bob\",\n"
            + "      \"status\": \"active\",\n"
            + "      \"version\": \"Default random player\",\n"
            + "      \"stack\": 1590,\n"
            + "      \"bet\": 80,\n"
            + "      \"hole_cards\": [\n"
            + "        {\n"
            + "          \"rank\": \"6\",\n"
            + "          \"suit\": \"hearts\"\n"
            + "        },\n"
            + "        {\n"
            + "          \"rank\": \"K\",\n"
            + "          \"suit\": \"spades\"\n"
            + "        }\n"
            + "      ]\n"
            + "    },\n"
            + "    {\n"
            + "      \"id\": 2,\n"
            + "      \"name\": \"Chuck\",\n"
            + "      \"status\": \"out\",\n"
            + "      \"version\": \"Default random player\",\n"
            + "      \"stack\": 0,\n"
            + "      \"bet\": 0\n"
            + "    }\n"
            + "  ],\n"
            + "  \"community_cards\": [\n"
            + "    {\n"
            + "      \"rank\": \"4\",\n"
            + "      \"suit\": \"spades\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"rank\": \"A\",\n"
            + "      \"suit\": \"hearts\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"rank\": \"6\",\n"
            + "      \"suit\": \"clubs\"\n"
            + "    }\n"
            + "  ]\n"
            + "}";

    @Test
    public void testBetRequest() throws Exception {
        final GameState gameState = new JsonConverter<>(GameState.class).fromJson(testJson);
        assertEquals(240, Player.betRequest(gameState));
    }
}
