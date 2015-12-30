package com.samatkinson;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static spark.Spark.*;

public class Main {

    private static UrlFormatter urlFormatter;

    public static void main(String[] args) {
        String port = Optional.ofNullable(System.getenv("PORT")).orElse("8080");
        port(Integer.parseInt(port));
        get("/cage", (req, res) -> {
            res.type("application/json");
            String params = req.queryParams("text");

            urlFormatter = new UrlFormatter(params);
            String formattedUrl = urlFormatter.getFormattedUrl();

            return "{" +
                    "\"response_type\": \"in_channel\"," +
                    "    \"text\": \"Here is a " + urlFormatter.imageType() + " image of Nic Cage.\"," +
                    "    \"attachments\": [" +
                    "        {" +
                    "            \"title\": \"Nic Cage\",\n" +
                    "            \"image_url\": \"" + formattedUrl + "\",\n" +
                    "            \"color\": \"#764FA5\"" +

                    "        }" +
                    "    ]" +
                    "}";
        });
    }

}
