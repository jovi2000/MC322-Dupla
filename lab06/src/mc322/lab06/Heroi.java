package mc322.lab06;

public class Heroi extends Componentes {
    /* Atributos */
    private int flecha;
    private boolean equipada;

    public Heroi(int linha, int coluna, char simbolo, Caverna caverna) {
        super(linha, coluna, simbolo, caverna);
    	this.flecha = 1;
    	this.equipada = false;
    }
    
    int controle_heroi(String comando)
    {
    	int pontos = 0;
    	switch(comando)
    	{
    		case "k"://equipa flecha
    			if (flecha != 0)
    			{
    				equipada = true;
    				flecha--;
    				pontos -= 100;
    			}
    			else System.out.print("Acabaram as flechas!!! :(");
    		case "c":// captura ouro
    		case "w":// p/ cima
    		case "d":// p/ baixo
    		case "a":// p/ esquerda
    		case "s":// p/ direita 
    		case "q":// sai caverna 
    			
    		
    	}
    	return pontos;
    }
}
