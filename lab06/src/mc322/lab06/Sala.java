package mc322.lab06;

import java.util.LinkedList;

public class Sala {
    /* Atributos */
	public LinkedList<Componentes> lista_sala; // Lista ligada de Componentes
	public boolean visivel; // Se o heroi já passou pela sala, visivel = true, caso contrário, visivel = false

	/* Métodos */
	Sala() {
		this.lista_sala = new LinkedList<Componentes>();
		this.visivel = false;
	}

	public boolean disponibilidadeSala(Componentes componente) {
		/* Caso os componentes não sejam nem fedor nem brisa, é necessário verificar os componentes da lista */
		if (componente.simbolo != 'f' && componente.simbolo != 'b' && componente.simbolo != 'P') {
			for (int i = 0; i < lista_sala.size(); i++) {
				/* Se um dos componentes não for nem fedor nem brisa, a inserção é inválida */
				if (lista_sala.get(i).simbolo != 'f' && lista_sala.get(i).simbolo != 'b') {
					return false;
				}
			}
			return true;
		}
		/* A inserção de fedor, brisa e heroi é sempre válida */
		else {
			return true;
		}
	}

	public boolean adicionaComponente(Componentes componente) {
		/* Se a sala está disponível para receber o componente, ele é adicionado */
		if (disponibilidadeSala(componente)) {
			lista_sala.add(componente);
			/* As salas que o heroi passa ficam visíveis */
			if (componente.simbolo == 'P') {
				visivel = true;
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public void removeComponente(char simbolo_solicitado) {
		for (int i = 0; i < lista_sala.size(); i++) {
			if(lista_sala.get(i).simbolo == simbolo_solicitado) {
				lista_sala.remove(i);
				break;
			}
		}
	}
	
	public int verificaComponentes(char simbolo_solicitado) {
		for (int i = 0; i < lista_sala.size(); i++) {
			if (lista_sala.get(i).simbolo == simbolo_solicitado) {
				return i;
			}
		}
		return -1;
	}
}
