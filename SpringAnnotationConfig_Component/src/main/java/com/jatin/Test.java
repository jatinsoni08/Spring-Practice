package com.jatin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {

        // Spring container create kiya (empty state me)
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext();

        // scan method -> base package ko scan karta hai
        // yeh package ke andar jitni bhi @Component classes hongi unko detect karega
        ac.scan("com.jatin");

        // refresh method -> Spring container ko start karta hai
        // aur saare beans ko initialize karta hai
        ac.refresh();

        // getBean method -> Spring container se object fetch karta hai
        // "hob" bean name hai jo @Component("hob") se bana hai
        HandlerInfo ob =
                (HandlerInfo) ac.getBean("hob", HandlerInfo.class);

        // object print kar rahe hain
        System.out.println(ob);
    }
}