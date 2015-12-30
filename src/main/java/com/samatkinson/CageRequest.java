package com.samatkinson;

import java.util.HashMap;
import java.util.Map;

public class CageRequest {
    private final Map<String, String> commandMap = new HashMap<String, String>() {{
        put("calm", "");
        put("gray", "/g");
        put("crazy", "/c");
        put("gif", "/gif");
    }};

    private final String formatUrl = "https://www.placecage.com%s/%d/%d";
    private final HeightWidthGenerator heightWidthGenerator;
    private final String params;

    public CageRequest(HeightWidthGenerator heightWidthGenerator, String params) {
        this.heightWidthGenerator = heightWidthGenerator;

        if (!commandMap.containsKey(params)) {
            System.out.println("Text did not match a mood. Text was: " + params);
            params = "calm";
        }

        this.params = params;

    }

    public String getFormattedUrl() {
        return String.format(formatUrl, commandMap.get(params), heightWidthGenerator.width(), heightWidthGenerator.height());
    }

    public String imageType() {
        return params;
    }
}
