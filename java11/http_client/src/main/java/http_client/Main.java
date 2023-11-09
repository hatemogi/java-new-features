package http_client;

import java.io.*;
import java.net.*;
import java.net.http.*;
import java.nio.file.Paths;
import java.time.Duration;

public class Main {

    static void httpGet() throws IOException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/get"))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }

    static void httpPost() throws IOException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/post"))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("file.json")))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }


    static HttpClient httpClient() {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
        return client;
    }

    static HttpRequest getRequest() throws IOException {
        return HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/get"))
                .timeout(Duration.ofMinutes(1))
                .build();
    }


    static void synchronous(HttpClient client, HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    static void asynchronous(HttpClient client, HttpRequest request) throws IOException, InterruptedException {
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> { System.out.println(response.statusCode());
                    return response; } )
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        httpGet();
        httpPost();

        var client = httpClient();
        var request = getRequest();
        synchronous(client, request);
        asynchronous(client, request);
    }
}
