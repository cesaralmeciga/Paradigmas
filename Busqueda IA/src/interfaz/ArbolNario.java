package interfaz;

import java.util.ArrayList;
import java.util.Stack;

import interfaz.*;

public class ArbolNario {
	public Nodo raiz;
	Nodo nodoActual;
	private int contPostOrden = 0;
	private int contPreOrden = 0;
	private ArrayList indexNodos = new ArrayList();

	public ArbolNario() {
		raiz = null;
	}

	public void insertarHijo(String padre, String info) {
		Nodo aux = new Nodo(info);

		if (raiz == null) {
			raiz = aux;
			this.preorden();
			this.postorden();
			// System.out.println("Raiz insertada " + info);
		} else if (padre.equals("")) {
			System.out.println("Padre vacio");
		} else {
			this.insertarHijo(raiz, padre, info);
			this.preorden();
			this.postorden();
		}
	}

	private void insertarHijo(Nodo nodoActual, String padre, String theInfo) {
		if (nodoActual.getInfo().equals(padre)) {
			nodoActual.nodosHijos.add(new Nodo(theInfo));
			//System.out.println("Nodo insertado= " + theInfo);
		} else
			for (int i = 0; i < nodoActual.nodosHijos.size(); i++)
				this.insertarHijo((Nodo) nodoActual.nodosHijos.get(i), padre, theInfo);
	}

	public void preorden() {
		contPreOrden = 0;
		this.preorden(raiz);

	}

	private void preorden(Nodo nodoActual) {
		Nodo aux = null;
		contPreOrden++;
		nodoActual.setPreorden(contPreOrden);
		this.agregarEnIndex(nodoActual, true, false);
		// System.out.println("Preorden de " + nodoActual.getInfo() + "= " +
		// nodoActual.getPreorden());
		for (int i = 0; i < nodoActual.nodosHijos.size(); i++) {
			aux = (Nodo) nodoActual.nodosHijos.get(i);
			this.preorden(aux);
		}

	}

	public void postorden() {
		contPostOrden = 0;
		this.postorden(raiz);
	}

	private void postorden(Nodo nodoActual) {
		Nodo aux = null;
		for (int i = 0; i < nodoActual.nodosHijos.size(); i++) {
			aux = (Nodo) nodoActual.nodosHijos.get(i);
			this.postorden(aux);
		}
		contPostOrden++;
		nodoActual.setPostOrden(contPostOrden);
		this.agregarEnIndex(nodoActual, false, true);
		// System.out.println("Postorden de " + nodoActual.getInfo() + "= " +
		// nodoActual.getPostOrden());
	}

	private void agregarEnIndex(Nodo nodoActual, boolean esPreOrden, boolean esPostOrden) {
		Index indexTemp;
		boolean exist = false;

		for (int i = 0; i < indexNodos.size(); i++) {
			indexTemp = (Index) indexNodos.get(i);
			if (indexTemp.getInfoNodo().equals(nodoActual.getInfo())) {
				exist = true;
				if (esPreOrden)
					indexTemp.setIndexPreorden(nodoActual.getPreorden());
				if (esPostOrden)
					indexTemp.setIndexPostOrden(nodoActual.getPostOrden());
			}
		}
		if (!exist) {
			indexNodos.add(new Index(nodoActual.getPreorden(), nodoActual.getPostOrden(), nodoActual.getInfo()));
		}
	}

	public void imprimirIndexCompleto() throws Exception {
		Index index = null;
		System.out.println("num index " + indexNodos.size());
		for (int i = 0; i < indexNodos.size(); i++) {
			index = (Index) indexNodos.get(i);
			System.out.println("Nodo " + index.getInfoNodo() + " Preorden {" + index.getIndexPreorden()
					+ "} PostOrden {" + index.getIndexPostOrden() + "}");
		}
	}

	public void getIndex(String nodoInfo) throws Exception {
		Index index;
		boolean exist = false;

		for (int i = 0; i < indexNodos.size(); i++) {
			index = (Index) indexNodos.get(i);
			if (index.getInfoNodo().equals(nodoInfo)) {
				System.out.println("Nodo " + index.getInfoNodo() + " Preorden {" + index.getIndexPreorden()
						+ "} PostOrden {" + index.getIndexPostOrden() + "}");
				exist = true;
			}
		}
		if (!exist) {
			System.out.println("No se ha encontrado el nodo buscado");
		}
	}

	public void imprimirArbol(ArbolNario arbol) {
		this.imprimirNodo(arbol.raiz);
		
	}

	private void imprimirNodo(Nodo nodoActual) {
		Nodo aux = null;
		System.out.println("Nodo Papa: " + nodoActual.getInfo());
		for (int i = 0; i < nodoActual.nodosHijos.size(); i++) {
			aux = (Nodo) nodoActual.nodosHijos.get(i);
			System.out.println("Nodo Papa: " + nodoActual.getInfo() + " -- Nodo hijo: " + aux.getInfo());
			this.imprimirNodo(aux);
		}

	}
	
	public void BFS()
	{
		
	}
	
}