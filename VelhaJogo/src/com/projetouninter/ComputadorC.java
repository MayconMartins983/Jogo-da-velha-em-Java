package com.projetouninter;

import java.util.Random;

//Esse nivel possui dois modelos, um compara os lados horizontais e verticais da tabela, caso falhe o modelo irá trabalhar com valores aleatórios  
public class ComputadorC extends Computador{

    Random numeroAleatorio = new Random();
    @Override
    public void jogar(String[][] mapa) {
        // 
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(mapa[i][j].equals("X")){
                    //percorrendo os lados horizontais 
                    try{
                        if(mapa[i+1][j].equals(" ")){
                            mapa[i+1][j] = "O";
                            return;
                        }
                    }catch(Exception e){
                        
                    }
                    try{
                        if(mapa[i-1][j].equals(" ")){
                            mapa[i-1][j] = "O";
                            return;
                        }
                    }catch(Exception e){
                        
                    }
                    
                    //percorrendo os lados verticais 
                    try{
                        if(mapa[i][j+1].equals(" ")){
                            mapa[i][j+1] = "O";
                            return;
                        }
                    }catch(Exception e){
                        
                    }
                    try{
                        if(mapa[i][j-1].equals(" ")){
                            mapa[i][j-1] = "O";
                            return;
                        }
                    }catch(Exception e){
                        
                    }
                        
                     
                    
                }
            }
        }
       // modelo aleátorio  
        int x;
        while(true){
            x = numeroAleatorio.nextInt(3);
            for(int j = 0; j < 3; j++){
                if(mapa[x][j].equals(" ")){
                    mapa[x][j] = "O";
                    return;
                }
            }
        }
    }

}