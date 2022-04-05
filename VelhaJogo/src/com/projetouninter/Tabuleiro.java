package com.projetouninter;


public class Tabuleiro {

    public String matrizDoTabuleiro[][] = new String[3][3];    //matriz do tabuleiro
    public int quantidadeJogadas; // salva a quantidade de jogadas
    private String marca; //salva (X ou O) de quem venceu 
    
    public Tabuleiro(){
        this.quantidadeJogadas = 0;
        iniciarPosicoes();
        this.marca = "";
    }
    
    private void iniciarPosicoes(){ //inicio das posições com string vazia 
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.matrizDoTabuleiro[i][j] = " ";
            }
        }
    } //  função que faz com que a tela seja atualizada 
    private void atualizaTela(){
        for(int i = 0; i < 30; i++){
            System.out.println();
        }
        // imprimindo tela de boas vindas para o usuário
        System.out.println("==================================");
        System.out.println("  BEM VINDO AO JOGO DA VELHA");
        System.out.println("    X - PLAYER | O - CPU\n");
        System.out.println("===================================");
        
    }
    public void imprimirTabuleiro(){
       atualizaTela(); // chamando o atualizador de tela
       
       // imprimindo as marcações do tabuleiro 
       for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(this.matrizDoTabuleiro[i][j]);
                if(j<2){
                    System.out.print("|");
                }
                
            }
            if(i<2){
                System.out.println("\n-|-|-");
            }
        }
        System.out.println("\n");
    }
    public boolean verificarVitoria(){
        //Verificar possibilidade de vitoria por numeros de jogadas
        if(quantidadeJogadas < 5){
            return false;
        }
        // verificando possibilidade de vitorias = horizontal, vertical e diagonal, são 8 possibilidades de vitoria
        //Verificar vitoria diagonal 1 
        if(matrizDoTabuleiro[0][0].equals(matrizDoTabuleiro[1][1]) && matrizDoTabuleiro[1][1].equals(matrizDoTabuleiro[2][2]) && !(matrizDoTabuleiro[1][1].equals(" "))){
            this.marca = matrizDoTabuleiro[0][0];
            return true;
        } //Verificar vitoria diagonal 2 
        if(matrizDoTabuleiro[2][0].equals(matrizDoTabuleiro[1][1]) && matrizDoTabuleiro[1][1].equals(matrizDoTabuleiro[0][2]) && !(matrizDoTabuleiro[1][1].equals(" "))){
            this.marca = matrizDoTabuleiro[2][0];
            return true;
            
        }
        //loop para verificar todas as possibilidades de vitoria verticais e horizontais
        for(int i = 0; i < 3; i++){
            //Verificar vitoria VERTICAL
            if(matrizDoTabuleiro[i][0].equals(matrizDoTabuleiro[i][1]) && matrizDoTabuleiro[i][1].equals(matrizDoTabuleiro[i][2]) && !(matrizDoTabuleiro[i][1].equals(" "))){
                this.marca = matrizDoTabuleiro[i][0];
                return true;
            }
            
            // Verificar vitoria horizontal
            if(matrizDoTabuleiro[0][i].equals(matrizDoTabuleiro[1][i]) && matrizDoTabuleiro[1][i].equals(matrizDoTabuleiro[2][i]) && !(matrizDoTabuleiro[1][i].equals(" "))){
                this.marca = matrizDoTabuleiro[0][i];
                return true;
            }
            
        }
        return false;
    }
    
    public String statusJogo(){
        //mostrando status atual da partida
        boolean statusVitoria = verificarVitoria(); 
        // condicão que retorna qual o vencedor ou empate na jogada 
        if(statusVitoria == false && quantidadeJogadas == 9){
            return "EMPATE";
        }else if(statusVitoria == false){
            return "INACABADO";
        }else{
            if(this.marca == "X"){
                return "Você venceu";
            }else{
                return "Computador/ maquina venceu";
            }
        }
    }
    
}
