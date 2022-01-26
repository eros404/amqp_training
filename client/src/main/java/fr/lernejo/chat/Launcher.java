package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        RabbitTemplate template = new AnnotationConfigApplicationContext(Launcher.class).getBean(RabbitTemplate.class);
        System.out.println("Input a message, we will sent it for you (q for quit)");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        while (!response.equals("q")) {
            template.convertAndSend("", "chat_messages", response);
            System.out.println("Message sent. Input a message, we will sent it for you (q for quit)");
            response = scanner.nextLine();
        }
        System.out.println("Bye");
    }
}
