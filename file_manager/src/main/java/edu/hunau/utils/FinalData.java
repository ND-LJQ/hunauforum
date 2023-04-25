package edu.hunau.utils;

import org.springframework.beans.factory.annotation.Value;

public class FinalData {

    @Value("${server.port}")
    private static String port;

    public static final String FILE_SERVER_PATH = "http://localhost:"+port;
}
