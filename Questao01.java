// Desenvolva uma calculadora, no qual o usuário deve digitar o valor de um número do qual
// ele deseja submeter o cálculo e que possa escolher qual das operações básicas da matemática
// a calculadora deve realizar os cálculos. A calculadora também deve ter a opção de realizar
// todas as operações básicas, bem como realizar cálculos de potenciação, raiz quadrada e cúbica.

import java.util.Scanner;

public class Questao01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            float num1 = 0, num2 = 0;
            double resultado = 0;
            int opcao;
            char operacao;
        
            do{ // Recebe num1 e verifica se é float
                System.out.print("Digite um número: ");
                try{
                    num1 = Float.parseFloat(scanner.nextLine());
                    System.out.print("\n");
                    break;
                } catch (NumberFormatException e){
                    System.out.println("Valor inválido. Tente novamente\n");
                }
            } while(true);

            operacao = recebeOperacao();

            // Verifica caminho para operacao
            if(operacao == '2' || operacao == '3'){
                resultado = calculoRaiz(num1, operacao);
            } else{
                num2 = recebeNum2();
                resultado = calculoBasico(num1, num2, operacao);
            }

            while(true){
                do{
                    System.out.print("\nSelecione uma opção para o cálculo:\n" +
                    "[1] ➪ Continuar\n" +
                    "[2] ➪ Zerar\n" +
                    "[0] ➪ Encerrar\n" +
                    "Opção: ");
                    try{
                        opcao = Integer.parseInt(scanner.nextLine());
                        System.out.print("\n");
                        if(opcao < 0 || opcao > 2){
                            System.out.println("Valor inválido. Tente novamente");
                            continue;
                        }
                        break;
                    } catch(NumberFormatException e){
                        System.out.println("Valor inválido. Tente novamente");
                    }
                } while(true);

                if(opcao == 0){
                    System.exit(0);
                } else if(opcao == 2){
                    break;
                } else{
                    operacao = recebeOperacao();

                    if(operacao == '2' || operacao == '3'){
                        resultado = calculoRaiz(resultado, operacao);
                    } else{
                        num2 = recebeNum2();
                        resultado = calculoBasico(resultado, num2, operacao);
                    }
                } 
            }
            continue;
        }
    }

    public static char recebeOperacao() {
        Scanner op = new Scanner(System.in);
        char operacao;

        do{ // Recebe operacao, verifica se é char e se a opção é válida
            System.out.print("Digite o símbolo da operação\n" + 
            "[+] ➪ Soma\n" +
            "[-] ➪ Subtração\n" +
            "[*] ➪ Multiplicação\n" +
            "[/] ➪ Divisão\n" +
            "[&] ➪ Todas as operações básicas\n" +
            "[^] ➪ Potenciação\n" +
            "[2] ➪ Raiz Quadrada\n" +
            "[3] ➪ Raiz Cúbica\n" +
            "Escolha: ");

            operacao = op.next().charAt(0);
            op.nextLine();
            System.out.println("");

            if(operacao != '+' && operacao != '-' && operacao != '*' && operacao != '/' && operacao != '&' && operacao != '^' && operacao != '2' && operacao != '3'){
                System.out.println("Operação inválida. Tente novamente\n");
            }
        } while(operacao != '+' && operacao != '-' && operacao != '*' && operacao != '/' && operacao != '&' && operacao != '^' && operacao != '2' && operacao != '3');
    
        return operacao;
    }

    public static float recebeNum2() {
        Scanner number = new Scanner(System.in);
        float num2;

        do{ // Recebe num2 e verifica se é float
            System.out.print("Digite outro número: ");
            try{
                num2 = Float.parseFloat(number.nextLine());
                System.out.print("\n");
                break;
            } catch (NumberFormatException e){
                System.out.println("Valor inválido. Tente novamente\n");
            }
        } while(true);

        return num2;
    }

    public static double calculoBasico(double x, float num2, char operacao) {
        double resultado = 0;

        switch(operacao){
            case '+':
                resultado = x + num2;
                System.out.printf("A soma entre " + x + " e " + num2 + " é: %.1f\n", resultado);
                break;
            case '-':
                resultado = x - num2;
                System.out.printf("A subtração entre " + x + " e " + num2 + " é: %.1f\n", resultado);
                break;
            case '*':
                resultado = x * num2;
                System.out.printf("A multiplicação entre " + x + " e " + num2 + " é: %.1f\n", resultado);
                break;
            case '/':
                if(num2 == 0){
                    System.out.printf("Erro no cálculo\n");
                    System.exit(0);
                } else{
                    resultado = x / num2;
                    System.out.printf("A divisão entre " + x + " e " + num2 + " é: %.1f\n", resultado);
                    break;
                }
            case '&':
                resultado = x + num2;
                System.out.printf("A soma entre " + x + " e " + num2 + " é: %.1f\n", resultado);
                resultado = x - num2;
                System.out.printf("A subtração entre " + x + " e " + num2 + " é: %.1f\n", resultado);
                resultado = x * num2;
                System.out.printf("A multiplicação entre " + x + " e " + num2 + " é: %.1f\n", resultado);
                resultado = x / num2;
                System.out.printf("A divisão de " + x + " por " + num2 + " é: %.1f\n", resultado);
                break;
            case '^':
                resultado = Math.pow(x, num2);
                System.out.printf("A potenciação de " + x + " elevado a " + num2 + " é: %.1f\n", resultado);
                break;
        }
        return resultado;
    }

    public static double calculoRaiz(double x, char operacao){
        double resultado = 0;

        switch(operacao){
            case '2':
                resultado = Math.sqrt(x);
                System.out.printf("A raiz quadrada de " + x + " é: %.1f\n", resultado);
                break;
            case '3':
                resultado = Math.cbrt(x);
                System.out.printf("A raiz cúbica de " + x + " é: %.1f\n", resultado);
                break;
        }
        return resultado;
    }    
}
