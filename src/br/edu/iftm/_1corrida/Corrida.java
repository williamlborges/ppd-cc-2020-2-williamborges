package br.edu.iftm._1corrida;

public class Corrida extends Thread {
	private final String nome;
    private final int velocidade;

    public Corrida (String nome, int velocidade){
        this.nome = nome;
        this.velocidade = velocidade;
        //start();
    }

    @Override
    public void run() {
        for (int loop = 1; loop <= 10; loop++) {
            try {
            	if (loop == 10) {
            		System.out.println(this.nome + " terminou.");
            	}else {
            		System.out.println("O corredor " + this.nome + " avançou " + loop + " passo(s)");
            		sleep(this.velocidade * 20);
            	}
                
                
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
