package interfaz;

public class Index {
	private int indexPreorden = -1;
	private int indexPostOrden = -1;
	private String infoNodo = "";

	public Index(int preOrden, int postOrden, String infoNodo) {
		this.setIndexPreorden(preOrden);
		this.setIndexPostOrden(postOrden);
		this.setInfoNodo(infoNodo);
	}

	public int getIndexPostOrden() throws Exception {
		return indexPostOrden;
	}

	public void setIndexPostOrden(int indexPostOrden) {
		this.indexPostOrden = indexPostOrden;
	}

	public int getIndexPreorden() {
		return indexPreorden;
	}

	public void setIndexPreorden(int indexPreorden) {
		this.indexPreorden = indexPreorden;
	}

	public String getInfoNodo() {
		return infoNodo;
	}

	public void setInfoNodo(String infoNodo) {
		this.infoNodo = infoNodo;
	}

}
