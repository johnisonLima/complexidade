package br.edu.ifba.constante;

public class Main {

    // Complexidade: O(1)
    // executa uma unica operação, independente do tamanho da entrada
    public static boolean isPar(int number) {
        return number % 2 == 0;
    }

    public static double toCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        if(isPar(9)) {
            System.out.println("O número é par.");
        } else {
            System.out.println("O número é ímpar.");
        }

        double fahrenheit = 100.0;
        double celsius = toCelsius(fahrenheit);
        System.out.println(fahrenheit + "°F é igual a " + celsius + "°C.");
    }
}