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
                    "            \"fallback\": \"Network traffic (kb/s): How does this look? @slack-ops - Sent by Julie Dodd - https://datadog.com/path/to/event\",\n" +
                    "            \"title\": \"Network traffic (kb/s)\",\n" +
                    "            \"title_link\": \"https://datadog.com/path/to/event\",\n" +
                    "            \"text\": \"How does this look? @slack-ops - Sent by Julie Dodd\",\n" +
                    "            \"image_url\": \"https://datadoghq.com/snapshot/path/to/snapshot.png\",\n" +
                    "            \"color\": \"#764FA5\"" +

                    "        }" +
                    "    ]" +
                    "}";
        });
    }
}
