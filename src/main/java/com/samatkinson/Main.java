package com.samatkinson;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        get("/cage", (req, res) -> {
            return "{" +
                    "    \"attachments\": [" +
                    "        {" +
                    "            \"fallback\": \"Required plain-text summary of the attachment.\"," +
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
                    "" +
                    "            \"image_url\": \"https://www.placecage.com/g/140/100\"," +
                    "            \"thumb_url\": \"https://www.placecage.com/g/140/100\"" +
                    "        }" +
                    "    ]" +
                    "}";
        });
    }
}
