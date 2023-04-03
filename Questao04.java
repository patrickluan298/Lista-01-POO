// Escreva um programa que receba um número digitado pelo usuário. Se o número for par, ele deve exibir na
// tela o cálculo da raiz cúbica. Se o número for ímpar, ele deve exibir na tela o cálculo da raiz quadrada.

import java.util.Scanner;

public class Questao04 {
    public static void main(String[] args) {
        Scanner calcula = new Scanner(System.in);
        float num = 0;
        double resultado = 0;

        do{ // Recebe num e verifica se é float
            System.out.print("Digite um número: ");
            try{
                num = Float.parseFloat(calcula.nextLine());
                break;
            } catch (NumberFormatException e){
                System.out.println("Valor inválido. Tente novamente\n");
            }
        } while(true);

        if(num % 2 == 0){ // Verifica se é par ou ímpar
            resultado = Math.cbrt(num);
            System.out.printf("A raiz cúbica de " + num + " é: %.1f\n", resultado);
        } else{
            resultado = Math.sqrt(num);
            System.out.printf("A raiz quadrada de " + num + " é: %.1f\n", resultado);
        }
    }
}
