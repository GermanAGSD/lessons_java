package org.example;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class ApacheCamel {
    public static void apachecamel_message() throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                // HTTP endpoint (POST на /api/message)
                from("undertow:http://0.0.0.0:8080/api/message")
                        .log("Получен HTTP-запрос: ${body}")
                        .process(exchange -> {
                            String body = exchange.getIn().getBody(String.class);
                            String response = "Сервер получил: " + body;
                            exchange.getMessage().setBody(response);
                            System.out.println(response);
                            switch (body){
                                case "Hello World":
                                    System.out.println("Hello World");
                                    break;
                                case "Hello Camel":
                                    System.out.println("Hello Camel");
                                    break;
                                case "Privet Vitalik":
                                    for (int i = 0; i < 5; i++) {
                                        System.out.println("Privet Vitalik");
                                    }
                                    System.out.println("Privet Vitalik");
                            }
                        });

            }
        });

        context.start();
        System.out.println("Сервер запущен на http://localhost:8080/api/message");
        Thread.sleep(300_000); // 5 минут работы
        context.stop();
    }
}
