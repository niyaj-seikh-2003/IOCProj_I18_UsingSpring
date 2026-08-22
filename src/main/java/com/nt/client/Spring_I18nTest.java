//Client App
package com.nt.client;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;

public class Spring_I18nTest {

    public static void main(String[] args) {

        // create IOC container
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // read language code and country code from the end user
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter language code: ");
        String lang = sc.next();

        System.out.print("Enter country code: ");
        String country = sc.next();

        // prepare Locale object having language code + country code
        Locale locale = new Locale(lang, country);   // deprecated in Java 19
        // Locale locale = Locale.of(lang, country); // alternative

        // read the message from the Locale specific properties file
        String msg1 = ctx.getMessage("welcome.msg", new Object[]{"raja"}, locale);
        String msg2 = ctx.getMessage("goodbye.msg", new Object[]{}, locale);
        String msg3 = ctx.getMessage("application.title", new Object[]{}, locale);
        String msg4 = ctx.getMessage("wish.message", new Object[]{}, locale);

        // display the messages
        System.out.println(msg1 + "....." + msg2 + "....." + msg3 + "....." + msg4);

        // close the container
        ctx.close();
    }
}