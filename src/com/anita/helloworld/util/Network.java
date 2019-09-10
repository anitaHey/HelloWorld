package com.anita.helloworld.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Network {
    private static final String SERVER_URL = "192.168.1.103";
    private static final String SERVER_PORT = "8080";

    private void get(String name) throws Exception {
        URL url = new URL(String.format(
                    "http://%s:%d/%s", SERVER_URL, SERVER_PORT, name));

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();

        String line;
        while((line = reader.readLine()) != null){
            response.append(line);
        }

        System.out.println(response.toString());
        reader.close();
    }

    private void post(String name, String content) throws Exception {
        URL url = new URL(String.format(
                "http://%s:%d/%s", SERVER_URL, SERVER_PORT, name));

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream output = new DataOutputStream(
                connection.getOutputStream());
        output.writeBytes(content);
        output.flush();
        output.close();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();

        String line;
        while((line = reader.readLine()) != null){
            response.append(line);
        }

        System.out.println(response.toString());
        reader.close();
    }
}
