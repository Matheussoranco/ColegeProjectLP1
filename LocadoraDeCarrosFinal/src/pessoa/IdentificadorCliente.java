package pessoa;

public abstract class IdentificadorCliente {
	
	public static String getCliente(Cliente c) {
		return c.getClass().getSimpleName();
	}

}
