package br.edu.ifba.nobreaks.servidor;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {

    private static final String BASE_URI = "http://localhost:8080/api";

    private static HttpServer iniciarServidor() {
        ResourceConfig config = new ResourceConfig().packages("br.edu.ifba.nobreaks.servidor");

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
        return server;
    }
    public static void main(String[] args) throws IOException {
        HttpServer server = iniciarServidor();
        System.out.println("Servidor iniciado em: " + BASE_URI);
        System.in.read();
        server.shutdownNow();
    }
}