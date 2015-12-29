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

    public String getFormattedUrl(String params) {
        if (!commandMap.containsKey(params)) {
            params = "calm";
        }
        return String.format(formatUrl, commandMap.get(params));
    }
}
