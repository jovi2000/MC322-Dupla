package view;

import controller.Montador;

public class AppMain {
    public static void main(String[] args) throws InterruptedException {
        Montador montador = new Montador();
        montador.montarJogo();
        String[] falas = {"brasao","Naquele dia….",
        		"brasao","A humanidade se lembrou…",
        		"brasao","Do terror de estar nas mãos deles…",
        		"brasao","Da humilhação de estar nas mãos deles",
        		"eren","Senhor Hannes, por acaso vc estava bebendo?!(soldados bebendo ao fundo)"
        		+ "\n O senhor não deveria estar vigiando o portão?",
        		"hannes","A gente tava aqui o dia todo sem fazer nada, então ficamos com sede",
        		"erern","Se acontecer alguma coisa?? vocês vão conseguir lutar??",
        		"hannes","Como assim??? Se acontecer alguma coisa?",
        		"eren","E se eles invadirem a cidade?",
        		"hannes","Não se preocupe. hahahahahah  Isso não ocorre ha mais de 100 anos",
        		"eren","Mas é perigoso se descuidar assim",
        		"hannes","As muralhas tem 50m de altura, não tem como eles invadirem",
        		"colossau","aghhhhhhhhhh",
        		"eren","Nn...não pode ser... a... aquela muralha tem 50m de altura",
        		"muralha","capummmm",
        		"hannes","Não",
        		"hannes","Não pode ser",
        		"brasao","Naquele dia a humanidade se lembrou do terror de estar nas mãos deles,"
        		+ " de estar preso…",
        		"brasao","Da Humilhação de estar na mãos deles"};
        montador.getGameView().start(falas);
    }
}
