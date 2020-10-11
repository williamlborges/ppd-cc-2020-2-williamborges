package br.edu.iftm._1corrida;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);
    static int corredores;
    static List<Integer> velocidades = new ArrayList<>();
    static List<String> nomes = new ArrayList<>();
        
        
    public static void main(String[] args) {
    	Random random = new Random();
    	
        System.out.println("CORRIDA DOS DESTEMIDOS\n\tOnde os fracos não têm vez!!!\nNúmero de participantes: ");
        corredores = input.nextInt();
        input.nextLine();
        
        for (int corredor = 1; corredor <= corredores; corredor++){
            System.out.println("Informe o nome do " + corredor + "° corredor.");
            nomes.add(input.nextLine());
            
            // Fiz essa alteração para receber um random ao invés de escolher a velocidade
            // para dar mais emoção xD
            int vel = 1 + random.nextInt(100);
            System.out.println("O corredor " + nomes.get(corredor - 1)+ " possui velocidade " + vel);
            velocidades.add(vel);
            
            //System.out.println("Informe a velocidade do " + corredor + "° corredor.");
            //velocidades.add(input.nextInt());
            //input.nextLine();
        }
        
        System.out.println("\nPressione [ENTER] para iniciar a corrida.");
        input.nextLine();
        
        Thread race[] = new Thread[nomes.size()];
        for (int index = 0; index < nomes.size(); index++) {
            Corrida corrida = new Corrida(nomes.get(index), velocidades.get(index));
            race[index] = new Thread(corrida);
            race[index].start();
        }	
        
        for (int i = 0; i < nomes.size(); i++) {
        	try {
				race[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        
        System.out.println("Corrida finalizada!");
    }
}          

