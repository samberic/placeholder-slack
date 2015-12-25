package com.samatkinson;

import java.util.Optional;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        String port = Optional.ofNullable(System.getenv("PORT")).orElse("8080");
        port(Integer.parseInt(port));
        get("/cage", "application/json", (req, res) -> {
            res.type("application/json");
            return "{\n" +
                    "    \"attachments\": [\n" +
                    "        {\n" +
                    "            \"image_url\": \"https://www.placecage.com/200/300.jpg\"" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
        });
    }
}