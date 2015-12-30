package com.samatkinson;

import java.util.Optional;
import java.util.Random;

import static java.lang.Integer.parseInt;
import static java.util.Optional.*;
import static spark.Spark.get;
import static spark.Spark.port;

public class Main {

    private static CageRequest cageRequest;

    public static void main(String[] args) {

        port(parseInt(ofNullable(System.getenv("PORT")).orElse("8080")));

        get("/cage", (req, res) -> {
            res.type("application/json");
            String params = req.queryParams("text");

            cageRequest = new CageRequest(new RandomSizeGenerator(), params);

            return "{" +
                    "\"response_type\": \"in_channel\"," +
                    "    \"text\": \"Here is a " + cageRequest.imageType() + " image of Nic Cage.\"," +
                    "    \"attachments\": [" +
                    "        {" +
                    "            \"title\": \"Nic Cage\",\n" +
                    "            \"image_url\": \"" + cageRequest.getFormattedUrl() + "\",\n" +
                    "            \"color\": \"#764FA5\"" +

                    "        }" +
                    "    ]" +
                    "}";
        });
    }

    private static class RandomSizeGenerator implements HeightWidthGenerator {
        Random r = new Random();

        @Override
        public int height() {
            return 300 + r.nextInt(100);
        }

        @Override
        public int width() {
            return 200 + r.nextInt(200);
        }
    }
}
