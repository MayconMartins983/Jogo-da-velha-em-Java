package com.projetouninter;


public class ComputadorA extends Computador{
    @Override
    public void jogar(String mapa[][]){
        // O loop percorre o a matriz atrás de espaço vazio, caso seja vazio a String "O" é colocada no lugar. 
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(mapa[i][j].equals(" ")){
                    mapa[i][j] = "O";
                    return;
                }
            }
        }
    }

    
}
