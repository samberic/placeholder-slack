package com.samatkinson;

import java.util.HashMap;
import java.util.Map;

public class UrlFormatter {
    static Map<String, String> commandMap = new HashMap<String, String>() {{
        put("calm", "");
        put("gray", "/g");
        put("crazy", "/c");
        put("gif", "/gif");
    }};
    static String formatUrl = "https://www.placecage.com%s/200/300";
    private String params;

    public UrlFormatter(String params) {
        this.params = params;
        if (!commandMap.containsKey(params)) {
            System.out.println("Text did not match a mood. Text was: " + params);
            this.params = "calm";
        }
    }

    public String getFormattedUrl() {
        return String.format(formatUrl, commandMap.get(params));
    }

    public String imageType() {
        return params;
    }
}
