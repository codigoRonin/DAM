/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.fxwebserviceexample;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringJoiner;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author arturo
 */
public class ServiceUtils {

    // Get charset encoding (UTF-8, ISO,...)

    public static String getCharset(String contentType) {
        for (String param : contentType.replace(" ", "").split(";")) {
            if (param.startsWith("charset=")) {
                return param.split("=", 2)[1];
            }
        }

        return null; // Probably binary content
    }

    public static String getResponse(String url, String data, String method) {
        BufferedReader bufInput = null;
        StringJoiner result = new StringJoiner("\n");
        try {
            URL urlConn = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlConn.openConnection();
            conn.setReadTimeout(20000 /*milliseconds*/);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod(method);

            conn.setRequestProperty("Host", "localhost");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Origin", "http://localhost");
            conn.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
            conn.setRequestProperty("Accept-Language", "es-ES,es;q=0.8");
            conn.setRequestProperty("Accept-Charset", "UTF-8"); 
            conn.setRequestProperty("User-Agent", "Java");
            
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");

            if (data != null) {
                conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                conn.setDoOutput(true);
                //Send request
                DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
                wr.write(data.getBytes());
                wr.flush();
                wr.close();
            }

            String charset = getCharset(conn.getHeaderField("Content-Type"));

            if (charset != null) {
                InputStream input = conn.getInputStream();
                if ("gzip".equals(conn.getContentEncoding())) {
                    input = new GZIPInputStream(input);
                }

                bufInput = new BufferedReader(
                        new InputStreamReader(input));

                String line;
                while((line = bufInput.readLine()) != null) {
			result.add(line);
		}
            }
        } catch (IOException e) {
        } finally {
            if (bufInput != null) {
                try {
                    bufInput.close();
                } catch (IOException e) {
                }
            }
        }

        return result.toString();
    }
}
