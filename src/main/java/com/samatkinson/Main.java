package com.samatkinson;

import java.util.Optional;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        String port = Optional.ofNullable(System.getenv("PORT")).orElse("8080");
        port(Integer.parseInt(port));
        get("/cage", (req, res) -> {
            res.type("application/json");
            return "{" +
                    "" +
                    "    \"text\": \"Here is a calm image of Nic Cage.\"," +
                    "    \"attachments\": [" +
                    "        {" +
                    "            \"image_url\": \"https://www.placecage.com/200/300\",\n" +
                    "            \"color\": \"#764FA5\"" +

                    "        }" +
                    "    ]" +
                    "}";
        });
    }
}
