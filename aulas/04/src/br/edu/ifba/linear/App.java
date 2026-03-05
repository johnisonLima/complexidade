package br.edu.ifba.linear;


public class App {

    // Copleidade linear O(n), por que temos um loop que percorre o array de números uma única vez, realizando uma operação constante (soma) para cada elemento. Portanto, o tempo de execução cresce linearmente com o tamanho do array.
    private static int sonar(int[] numeros) {
        int suma = 0;

        for(int numero : numeros) {
            suma += numero;
        }
        return suma;
    }

    public static void main(String[] args) throws Exception {
        int numeros[] = new int[]{2, 3, 20, 12, 100};

        int resultado = sonar(numeros);
        System.out.println("A soma dos números é: " + resultado);
    }
}
