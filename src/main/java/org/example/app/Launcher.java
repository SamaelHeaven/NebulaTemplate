package org.example.app;

public final class Launcher {
    public static void main(String[] args) {
        var broker = new TestBroker(null);
        for (var testModel : broker.findAll()) {
            System.out.println(testModel.id() + ": " + testModel.test());
        }
    }
}