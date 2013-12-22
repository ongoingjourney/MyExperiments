package com.san;

public class FirstLambda {
    interface HelloWorld {
        String sayHelloWorld(String message);
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = (String message) -> {
            return "hello " + message;
        };
        System.out.println(helloWorld.sayHelloWorld("lambda"));
    }
}
