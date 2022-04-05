package com.projetouninter;
import java.util.Random;

public class ComputadorB extends Computador{
    Random numeroAleatorio = new Random();
    // Classe para gerar valores aleatórios
    
    @Override
    public void jogar(String[][] mapa) {
          //percorrendo a matriz em posições aleatórias e marcando caso esteja vazio; 
        int x,y;
        while(true){
            x = numeroAleatorio.nextInt(3);
            y = numeroAleatorio.nextInt(3);
            if(mapa[x][y].equals(" ")){
                mapa[x][y] = "O";
                return;
            }
            
        }
    }

}
