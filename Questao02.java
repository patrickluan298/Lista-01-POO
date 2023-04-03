// Crie um conversor de temperaturas em Java, no qual o usuário digita um valor e a escala da
// temperatura do valor digitado. Após, o programa deve imprimir a temperatura digitada nas
// escalas: Celsius, Kelvin, Fahrenheit.

import java.util.Scanner;

public class Questao02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float temperatura = 0;
        char escalaTermometrica;

        do{
            System.out.print("Informe uma temperatura: ");
            try{
                temperatura = Float.parseFloat(scanner.nextLine());
                System.out.print("\n");
                break;
            } catch (NumberFormatException e){
                System.out.println("Valor inválido. Tente novamente\n");
            }
        } while(true);

        do{
            System.out.print("Informe a escala desta temperatura\n" + 
            "[C] ➪ Celsius\n" +
            "[K] ➪ Kelvin\n" +
            "[F] ➪ Fahrenheit\n" +
            "Escolha: ");

            escalaTermometrica = scanner.next().charAt(0);
            scanner.nextLine();

            escalaTermometrica = Character.toUpperCase(escalaTermometrica);

            if(escalaTermometrica != 'C' && escalaTermometrica != 'K' && escalaTermometrica != 'F'){
                System.out.println("Escala inválida. Tente novamente\n");
            }
        } while(escalaTermometrica != 'C' && escalaTermometrica != 'K' && escalaTermometrica != 'F');

        conersao(temperatura, escalaTermometrica);
    }

    public static void conersao(float temperatura, char escalaTermometrica){
        double C, K, F;
        System.out.println("\nConverções da escala para:");

        switch(escalaTermometrica){
            case 'C':
                C = temperatura;
                System.out.printf("Celsius: %.1f°C\n", C);

                K = C + 273.15;
                System.out.printf("Kelvin: %.1fK\n", K);

                F = C * 1.8 + 32;
                System.out.printf("Fahrenheit: %.1f°F\n", F);
                break;
            case 'K':
                K = temperatura;
                System.out.printf("Kelvin: %.1fK\n", K);

                C = K - 273.15;
                System.out.printf("Celsius: %.1f°C\n", C);

                F = K * 1.8 - 459.67;
                System.out.printf("Fahrenheit: %.1f°F\n", F);
                break;
            case 'F':
                F = temperatura;
                System.out.printf("Fahrenheit: %.1f°F\n", F);

                C = (F - 32) / 1.8;
                System.out.printf("Celsius: %.1f°C\n", C);

                K = (F + 459.67) * 5/9;
                System.out.printf("Kelvin: %.1fK\n", K);
                break;
        }
    }
}
