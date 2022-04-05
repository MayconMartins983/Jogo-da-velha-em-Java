package com.projetouninter; 
import java.util.Scanner;

public class Main {
    
    
    public static void main(String[] args) {
        
        //Instanciando os objetos necessários do jogo da velha; 
        Scanner teclado = new Scanner(System.in); // classe Scanner
      
        Jogador player = new Jogador(); // classe Jogador
        ComputadorA maquina1 = new ComputadorA(); // classe herdada de Computador
        ComputadorB maquina2 = new ComputadorB(); // classe herdada de Computador
        ComputadorB maquina3 = new ComputadorB(); // classe herdada de Computador
        
        // Loop do menu 
        while(true){
            Tabuleiro tabVelha = new Tabuleiro(); // instanciando o tabuleiro
            int nivel = menu(); //função que exibe o menu e niveis de dificuldade do game
            boolean vitoriaJogador; 
            
            //Loop do jogo 
            
            do{
                // O loop encerra-se se as jogadas chegarem a 9 jogadas
                if(tabVelha.quantidadeJogadas == 9){
                    break;
                }
                String x,y; // variaveis entrada de dados posicão x e y da matriz
                x = y = "";  
                tabVelha.imprimirTabuleiro(); // imprime o tabuleiro para o usuário 
                
                //loop de tratamento de dados - permite que o usuário digite apenas o necessário
                do{
                    System.out.print("Insira a linha que deseja jogar: "); 
                    x = teclado.next();
                    System.out.print("Insira a coluna que deseja jogar: "); 
                    y  = teclado.next();
                }
                
                while(!(player.jogar(tabVelha.matrizDoTabuleiro, x, y)));
                tabVelha.quantidadeJogadas++;   //incrementando numero de jogadas
                
                // verificando jogadas e se há algum ganhador 
                vitoriaJogador = tabVelha.verificarVitoria();
                if(!(vitoriaJogador)){
                    //condição que faz a jogada de acordo com a classe selecionada
                    switch(nivel){
                    case 1:
                        maquina1.jogar(tabVelha.matrizDoTabuleiro);
                        break;
                    case 2:
                        maquina2.jogar(tabVelha.matrizDoTabuleiro);
                        break;
                    case 3:
                        maquina3.jogar(tabVelha.matrizDoTabuleiro);
                        break;
                    }
                    tabVelha.quantidadeJogadas++;    //incrementando numero de jogadas
                }
                
             // o loop se encerrara caso ouver empate o vitoria;    
            }while(!(tabVelha.verificarVitoria())); 
            
            
            tabVelha.imprimirTabuleiro();
            System.out.println(tabVelha.statusJogo());
            System.out.println("Digite algo alatorio e pressione enter para reiniciar o game");
            teclado.next();
            
            
        }
        
        
        
        
        
        
    // função menu     
    }
    public static int menu(){
        Scanner teclado = new Scanner(System.in);
        int nivel = 0;
        // condição que retorna valor de acordo com os dados de entrada do teclado 
        while(true){
            try{
                System.out.print("\nSelecione um nível de dificuldade para jogar: 1,2,3: ");
                nivel = Integer.parseInt(teclado.next());
                switch(nivel){
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                    default: // caso não digite 1,2,3 a mensagem de erro é retornada ao usuário
                        System.out.println("Nivel inválido, tente novamente!" );
                }
             // tratando entrada de dados === não permite digitar outro tipo a não ser numeros inteiros   
            }catch(Exception e){
                    System.out.println("Por favor, Digite apenas numeros inteiros");
            }
        }
    }
    
    
}



