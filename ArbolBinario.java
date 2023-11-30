public class ArbolBinario{
	private NodoArbol raiz; //Donde empieza el árbol
	public ArbolBinario() {
	}
	//Metodos
	public boolean buscarBool(Object o){
		//Recorremos por todo el Árbol
		NodoArbol aux = raiz;  //Inicio por la raiz
		while(aux != null){ //Recorro mientras busco
			if((int) aux.getDato() == (int) o){
				return true;
			}
			else{
				if((int) aux.getDato() < (int) o){
					aux = aux.getDerecha();	
				}
				else{
					aux = aux.getIzquierda();
				}	
			}
		}
		return false;
	}
	public Object buscarObject(Object o){
		//Recorremos por todo el Árbol
		NodoArbol aux = raiz, ant = null;  //Inicio por la raiz
		while(aux != null && aux.getDato() != o){ //Recorro mientras busco
			ant = aux;
			if((int) aux.getDato() < (int) o){
				aux = aux.getDerecha();	
			}
			else{
				aux = aux.getIzquierda();
			}	
		}
		return ant;
	}
	public boolean agregar(Object o){
		if(o == null){
			return false;
		}
		NodoArbol temp = (NodoArbol) buscarObject(o);
		if(temp == null){  //No hay nada, creamos
			raiz = new NodoArbol(o, null, null);
		}
		else{
			if((int) temp.getDato() == (int) o){
				return false;
			}
			else{
				if((int) temp.getDato() > (int) o){ //Insertar por la izquierda
					temp.setIzquierda(new NodoArbol(o, null, null));
				}
				else{
					temp.setDerecha(new NodoArbol(o, null, null));	
				}
				return true;
			}
		}
		return false;  //Si todo falla
	}
	private void ayudanteInorden(NodoArbol r){
		//Obtenemos r
		if(r != null){
			ayudanteInorden(r.getIzquierda());
			System.out.print(" " + r.getDato());
			ayudanteInorden(r.getDerecha());
		}
	}
	public void inorden(){  //Sin recibir nada
		ayudanteInorden(raiz);  //Ya podemos trabajar con ella
	}
	private void ayudantePreorden(NodoArbol r){
		//Obtenemos r
		if(r != null){
			System.out.print(" " + r.getDato());
			ayudantePreorden(r.getIzquierda());
			ayudantePreorden(r.getDerecha());
		}
	}
	public void preorden(){  //Sin recibir nada
		ayudantePreorden(raiz);  //Ya podemos trabajar con ella
	}
	private void ayudantePostorden(NodoArbol r){
		//Obtenemos r
		if(r != null){
			ayudantePostorden(r.getIzquierda());
			ayudantePostorden(r.getDerecha());
			System.out.print(" " + r.getDato());
		}
	}
	public void postorden(){  //Sin recibir nada
		ayudantePostorden(raiz);  //Ya podemos trabajar con ella
	}
	private int ayudanteContarHojas(NodoArbol r) {
		if (r == null) {
			return 0;
		}
		if (r.getIzquierda() == null && r.getDerecha() == null) {
			return 1;
		}
		return ayudanteContarHojas(r.getIzquierda()) + ayudanteContarHojas(r.getDerecha());
	}
	public int contarHojas() {
		return ayudanteContarHojas(raiz);
	}	
    private int contarNodos(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        return contarNodos(nodo.getIzquierda()) + contarNodos(nodo.getDerecha()) + 1;
    }
	public int contarNodos() {
        return contarNodos(raiz);
    }
	public int contarPadres(){
		return contarNodos() - contarHojas();
	}
	public boolean agregarRecursiva(Object o, NodoArbol n){
		if((int) n.getDato() > (int) o){  //Izquierda
			if(n.getIzquierda() == null){  //No hay nada
				n.setIzquierda(new NodoArbol(o, null, null));
				return true;
			}
			else{
				return agregarRecursiva(o, n.getIzquierda());
			}
		}
		else{  //Derecha
			if(n.getDerecha() == null){  //No hay nada
				n.setDerecha(new NodoArbol(o, null, null));
				return true;
			}
			else{
				return agregarRecursiva(o, n.getDerecha());
			}
		}
	}
	public boolean agregarRecursiva(Object o){
		if(o == null || buscarBool(o)){  //Objeto no válido o Ya existe el dato
			return false;
		}
		else{
			if(raiz == null){  //Árbol vacío 
				raiz = new NodoArbol(o, null, null);
				return true;
			}
			else{  //Agregar a árbol con datos
				return agregarRecursiva(o, raiz);
			}
		}
	}
	private NodoArbol borrarNodo(NodoArbol n){
		//En estos primeros casos no se necesita una busqueda
		if(n.getIzquierda() == null){  //Si no hay nada a la izquierda
			return n.getDerecha();
		}
		if(n.getDerecha() == null){  //Si no hay nada a la derecha
			return n.getIzquierda();
		}
		//Si tiene dos Hijos, se debe buscar el más cercano
		NodoArbol aux = n.getDerecha();  //Aquí puede ser incluso Izquierdo
		NodoArbol ant = null;
		//Buscamos el más cercano al Nodo, buscando por Izquierda
		while(aux.getIzquierda() != null){  
			ant = aux;
			aux = aux.getIzquierda();
		}
		n.setDato(aux.getDato());  //Cambia el dato al más cercano
		if(ant != null){
			//ant cambia su valor al único hijo de aux (Der), ya que no hay mas Izq
			ant.setIzquierda(aux.getDerecha());  
		}
		else{  //Este se ejecuta para la raíz, ya que ant == null
			//Cambia la derecha por que ya no hay izquierdas
			n.setDerecha(aux.getDerecha()); 
		}
		return n;  
	}
	public boolean eliminar(Object o){
		//Recorremos el Árbol
		NodoArbol aux = raiz;
		NodoArbol ant = null;
		//Recorrer hasta llegar al dato o buscar
		while(aux != null){
			if((int)aux.getDato() == (int)o){
				break;  //Sale de la busqueda
			}
			else{  //Sigue buscando
				ant = aux;
				if((int)aux.getDato() > (int)o){
					aux = aux.getIzquierda();
				}
				else{
					aux = aux.getDerecha();
				}
			}
		}
		if(aux == null){  //Si no haya nada retorna false, no está el dato
			return false;
		}
		if(aux == raiz){  //Eliminar la raiz
			raiz = borrarNodo(aux);
		}
		else{
			if(ant.getIzquierda() == aux){  //Si el dato esta en la izquierda
				ant.setIzquierda(borrarNodo(aux));  //Cambiamos el Nodo
			}
			else{  //Si el dato esta en la derecha
				ant.setDerecha(borrarNodo(aux));  //Cambiamos el Nodo
			}
		}
		return true;
	}
	public void eliminarTodo(){
		raiz = null;
	}
	public boolean buscarNodo(Object o){
		return buscarNodo(o, raiz);
	}
	private boolean buscarNodo(Object o, NodoArbol aux){
		if(aux == null){
			return false;  //null
		}
		if(aux.getDato().equals(o)){
			return true;  //aux
		}
		if((int)aux.getDato() > (int)o){
			return buscarNodo(o, aux.getIzquierda());
		}
		else{
			return buscarNodo(o, aux.getDerecha());
		}
	}
	public Object eliminarRecursivo(Object o) {
		// Dato no válido, árbol no existente, o el elemento no se encuentra en el árbol
		if (o == null || raiz == null || !buscarBool(o)) {
			return null;
		}
		//Actualiza todo el Arbol
		raiz = eliminarRecursivo(o, raiz);
		return o;
	}
	private NodoArbol eliminarRecursivo(Object o, NodoArbol aux) {  // Función auxiliar para la eliminación recursiva de un nodo
		if (aux == null) {
			return null;
		}
		// Si el elemento a eliminar está en la raíz del subárbol actual
		if (aux.getDato().equals(o)) {
			// Llama a la función para borrar el nodo y ajusta el subárbol
			return borrarNodoRecursivo(aux);
		}
		// Verificar y eliminar en la rama derecha o izquierda
		if ((int) aux.getDato() < (int) o) {
			aux.setDerecha(eliminarRecursivo(o, aux.getDerecha()));  // Si el elemento es mayor, busca en la rama derecha
		} else {
			aux.setIzquierda(eliminarRecursivo(o, aux.getIzquierda()));  // Si el elemento es mayor, busca en la rama derecha		
		}
		return aux;
	}
	private NodoArbol findMinimum(NodoArbol nodo) {  //// Encuentra el nodo con el valor mínimo en un subárbol
		if (nodo == null) {
			return null;
		}
		// Itera hacia la izquierda hasta encontrar el nodo más pequeño
		while (nodo.getIzquierda() != null) {
			nodo = nodo.getIzquierda();
		}
		return nodo;
	 }
	private NodoArbol borrarNodoRecursivo(NodoArbol n) {  // Borra recursivamente un nodo del árbol y ajusta la estructura
		if (n == null) {
			return null;
		}
		// Caso: No hay nada a la izquierda
		if (n.getIzquierda() == null) {
			return n.getDerecha();
		}
		// Caso: No hay nada a la derecha
		if (n.getDerecha() == null) {
			return n.getIzquierda();
		}
		// Caso: Tiene dos hijos
		NodoArbol sucesor = findMinimum(n.getDerecha());  //Busca el sucesor en orden (valor mínimo en rama derecha)
		n.setDato(sucesor.getDato());  // // Actualiza el valor del nodo actual con el valor del sucesor
		n.setDerecha(eliminarRecursivo(sucesor.getDato(), n.getDerecha()));  //// Elimina recursivamente el sucesor en la rama derecha
		return n;
	}
}