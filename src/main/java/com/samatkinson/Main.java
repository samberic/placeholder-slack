package com.samatkinson;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        port(Integer.parseInt(System.getenv("PORT")));
        get("/cage", (req, res) -> "{\n" +
                "    \"text\": \"It's 80 degrees right now.\",\n" +
                "    \"attachments\": [\n" +
                "        {\n" +
                "            \"text\":\"Partly cloudy today and tomorrow\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
    }
}
