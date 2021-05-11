package mc322.lab06;

public class Sala 
{
    /* Atributos */
    // Lista ligada de Componentes
	char celula;
	Sala()
	{
		celula = '-';
	}
	
	Sala(char celula)
	{
		this.celula = celula;
	}
	
	public char mostra()
	{
		return celula;
	}
}
