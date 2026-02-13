package br.edu.ifba.busca;

public class App {

    private static boolean encontrar(int numero, int[] vetor) {
        boolean encontrou = false;

        for(int i: vetor) {
            if(i == numero) {
                encontrou = true;

                break;
            }
        }

        return encontrou;

    }

    public static void main(String[] args) throws Exception {
        int[] vetor = new int[] {1, 2, 5, 10, 15, 20, 28, 30, 35, 40};

        // Melhor caso: O número está na primeira posição do vetor
        // Pior caso: O número está na última posição do vetor ou não existe

        int numero = 5;

        boolean encontrou = encontrar(numero, vetor);
            if (encontrou) {
                System.out.println("Encontrou o número " + numero + " no vetor");
            }
            else {
                System.out.println("Número " + numero + " não encontrado");
            }


    }
}
