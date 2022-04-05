package com.projetouninter;


public class Jogador {
    // recebe da main x e y como parametro 
    public boolean jogar(String mapa[][], String horizontal, String vertical){
        //verifica se a posição está ocupada e caso negativo, marca com um X (padrão do Jogador player)
        try{
        	// tratamento de dados para evitar erros no programa 
            int x = Integer.parseInt(horizontal);
            int y = Integer.parseInt(vertical);
            if (mapa[x-1][y-1].equals(" ")){
                mapa[x-1][y-1] = "X";
                return true;
            }else{
                //exibir a mensagem de que aquela posição já foi jogada
                System.out.println("Essa posiçãoo ja foi ocupada, tente novamente:" );
                return false;
            } // tratamento de excessão para caso o usuário coloque um valor quebrado 
        }catch(Exception e){
            System.out.println("Valor tem que ser inteiro");  
            return false;
        }
                    
    }
}
