public class NodoArbol{
	private Object dato;
	private NodoArbol izquierda, derecha;
	public NodoArbol(Object o, NodoArbol izquierda, NodoArbol derecha){
		dato = o;
		this.izquierda = izquierda;
		this.derecha = derecha;
	}
    public Object getDato() {
        return dato;
    }
    public void setDato(Object dato) {
        this.dato = dato;
    }
    public NodoArbol getIzquierda() {
        return izquierda;
    }
    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }
    public NodoArbol getDerecha() {
        return derecha;
    }
    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }
}