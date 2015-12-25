package com.samatkinson;

import java.util.Optional;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        String port = Optional.ofNullable(System.getenv("PORT")).orElse("8080");
        port(Integer.parseInt(port));
        get("/cage", "application/json", (req, res) -> {
            res.type("application/json");
            return "{" +
                    "" +
                    "    \"text\": \"Here is a calm image of Nic Cage.\"," +
                    "    \"attachments\": [" +
                    "        {" +
                    "\"fallback\": \"Required plain-text summary of the attachment.\"," +
                    "" +
                    "            \"color\": \"#36a64f\"," +
                    "" +
                    "            \"pretext\": \"Optional text that appears above the attachment block\"," +
                    "" +
                    "            \"author_name\": \"Bobby Tables\"," +
                    "            \"author_link\": \"http://flickr.com/bobby/\"," +
                    "            \"author_icon\": \"http://flickr.com/icons/bobby.jpg\"," +
                    "" +
                    "            \"title\": \"Slack API Documentation\"," +
                    "            \"title_link\": \"https://api.slack.com/\"," +
                    "" +
                    "            \"text\": \"Optional text that appears within the attachment\"," +
                    "" +
                    "            \"fields\": [" +
                    "                {" +
                    "                    \"title\": \"Priority\"," +
                    "                    \"value\": \"High\"," +
                    "                    \"short\": false" +
                    "                }" +
                    "            ]," +
                    "            \"image_url\": \"https://www.placecage.com/200/300.jpg\"" +
                    "            \"thumb_url\": \"http://example.com/path/to/thumb.png\""+
                    "        }" +
                    "    ]" +
                    "}";
        });
    }
}
