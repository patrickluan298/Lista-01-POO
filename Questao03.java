// Escreva um programa que receba o nome e sobrenome do usuário, verifique se o sobrenome é “Wayne”, se for,
// imprima na tela “Acesso liberado, Sr. Wayne”. Caso o sobrenome seja “Kent” o programa deve imprimir a mensagem
// “Sai daí, mané!”. Se o nome for Diana, ele deve imprimir a mensagem “Bem-vinda, Princesa de Themyscira”. Por
// fim, se nem um nome ou sobrenome se encaixar nas hipóteses anteriores, o programa deve imprimir “Cai fora!”.

import java.util.Scanner;

public class Questao03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeCompleto, nome, sobrenome, primeiraLetra, restante;

        System.out.print("Digite seu nome completo: ");
        nomeCompleto = scanner.nextLine();

        // Separa o nomeCompleto em nome e sobrenome
        nome = nomeCompleto.split(" ")[0];
        sobrenome = nomeCompleto.split(" ")[1];

        primeiraLetra = nome.substring(0, 1).toUpperCase();
        restante = nome.substring(1);
        nome = primeiraLetra + restante;

        primeiraLetra = sobrenome.substring(0, 1).toUpperCase();
        restante = sobrenome.substring(1);
        sobrenome = primeiraLetra + restante;

        if(nome.equals("Diana")){
            System.out.println("Bem-vinda, Princesa de Themyscira");
        }
        else if(sobrenome.equals("Wayne")){
            System.out.println("Acesso liberado, Sr. Wayne");
        }
        else if(sobrenome.equals("Kent")){
            System.out.println("Sai daí, mané!");
        } else{
            System.out.println("Cai fora!");
        }
    }
}
