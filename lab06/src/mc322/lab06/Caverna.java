package mc322.lab06;

public class Caverna {
    /* Atributos */
    private Sala[][] matriz_caverna = new Sala[5][5];
    /* Métodos */
    Caverna()
    {
		for (int x = 0; x < 5; x++)
		{
			for (int y = 0; y < 5; y++)
			{
				matriz_caverna[x][y] = new Sala();
			}
		}
		for (int x = 0; x < 5; x++) { matriz_caverna[x][0] = new Sala((char) ('1' + x));}
		for (int y = 0; y < 5; y++) { matriz_caverna[4][y] = new Sala((char) ('0' + y));}
		matriz_caverna[4][0] = new Sala(' ');
	}
    
    void mostra()
	{
		for (int x = 0; x < 5; x++)
		{
			for (int y = 0; y < 5; y++)
			{
				System.out.print(matriz_caverna[x][y].mostra() + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
    

}
