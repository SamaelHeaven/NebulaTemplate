package org.example.app;

import org.samaelheaven.nebula.core.Application;
import org.samaelheaven.nebula.core.Kernel;
import org.samaelheaven.nebula.network.Request;
import org.samaelheaven.nebula.network.Response;

import java.nio.charset.StandardCharsets;

public final class WebApplication extends Application {
    public static void main(String[] args) {
        Kernel.launch(new WebApplication());
    }

    @Override
    public void handleRequest(Request request, Response response) {
        response.getHeaders().set("Content-Type", "text/html");
        response.setBody("""
                <html>
                    <head>
                        <title>Hello World</title>
                        <meta charset="UTF-8">
                    </head>
                    <body>
                        <h1>Hello World</h1>
                    </body>
                </html>
                """.getBytes(StandardCharsets.UTF_8));
    }
}