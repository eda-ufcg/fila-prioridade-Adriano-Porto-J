public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;
	private int n;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
		this.n = capacidade;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		if (isFull()) throw IllegalStateException();
		Pair par = new Pair(elemento, prioridade);

		if (isEmpty()) {
			this.fila[++this.last] = par;
			this.head++;
			return;
		}

		fila[++last % n] = par;

		int i = last;

		while (i != head) {
			if (fila[i-1].getPrioridade() < fila[i].getPrioridade()) {
				Pair aux = fila[i-1];
				fila[i-1] = fila[i];
				fila[i] = aux;
			} else {
				break;
			}
			i--;
		}
	}

	private boolean isEmpty() {
		return last == -1 && head == -1;
	}

	private boolean isFull() {
		return last + 1 == last;
	}

	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e last
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		Pair r = fila[last];
		last++;
		return r.getElemento();
	}

}
