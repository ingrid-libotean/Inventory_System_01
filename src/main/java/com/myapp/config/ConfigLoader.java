package com.myapp.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class ConfigLoader {

    private static AppConfig config;

    public static AppConfig getConfig() {
        if (config == null) {
            loadConfig();
        }
        return config;
    }

    private static void loadConfig() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = ConfigLoader.class.getResourceAsStream("/config.json");
            config = mapper.readValue(is, AppConfig.class);
        } catch (Exception e) {
            throw new RuntimeException("Could not load config.json", e);
        }
    }
}
