import java.util.ArrayList;
import java.util.Collections;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair par = new Pair(elemento, prioridade);
		fila.add(par);
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		int max = 0;
		int j = 0;
		Pair val = new Pair(null, -1);
		for (int i = 0; i < fila.size(); i++) {
			if (this.fila.get(i).getPrioridade() > max) {
				max = this.fila.get(i).getPrioridade();
				val = this.fila.get(i);
				j = i;
			}
		}

		fila.remove(j);

		if (val.getElemento() == null) {
			throw new IllegalStateException();
		}

		return val.getElemento();
	}

}
