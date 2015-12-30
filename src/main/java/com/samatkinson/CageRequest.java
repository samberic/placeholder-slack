package com.samatkinson;

import java.util.HashMap;
import java.util.Map;

public class CageRequest {
    static Map<String, String> commandMap = new HashMap<String, String>() {{
        put("calm", "");
        put("gray", "/g");
        put("crazy", "/c");
        put("gif", "/gif");
    }};
    static String formatUrl = "https://www.placecage.com%s/%d/%d";
    private HeightWidthGenerator heightWidthGenerator;
    private String params;

    public CageRequest(HeightWidthGenerator heightWidthGenerator, String params) {
        this.heightWidthGenerator = heightWidthGenerator;
        this.params = params;
        if (!commandMap.containsKey(params)) {
            System.out.println("Text did not match a mood. Text was: " + params);
            this.params = "calm";
        }
    }

    public String getFormattedUrl() {
        return String.format(formatUrl, commandMap.get(params), heightWidthGenerator.width(), heightWidthGenerator.height());
    }

    public String imageType() {
        return params;
    }
}
