package tpAnual.acciones.emailSenderBusqueda;

/**
 * Interface para usar mockito.
 */
public interface IEmailSenderBusqueda {
	
	public void enviarMensajePorDemora(Long limite);

	public void setMailReceptor(String mailReceptor);
}
