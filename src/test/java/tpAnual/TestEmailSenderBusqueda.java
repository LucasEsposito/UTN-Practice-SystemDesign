package tpAnual;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import tpAnual.acciones.com.EmailSender;

public class TestEmailSenderBusqueda extends TestBuscador{
	private EmailSender sender;
	private Terminal terminal;
	@Before
	public void init(){
		super.init();
		sender = Mockito.mock(EmailSender.class);
		terminal = new Terminal(1);
		terminal.desactivarRegistros();
		terminal.setSender(sender);
	}
	
	@Test
	public void testearMailPorDemora(){
		mapa.buscar("colectivo",terminal);
		Mockito.verify(sender).enviarMensajePorDemora(Mockito.anyLong()); //uso anyLong porque la demora no es determinable antes de ejecutar el metodo.
	}
	
	@Test
	public void testMailsDesactivados(){
		terminal.desactivarMails();
		mapa.buscar("colectivo",terminal);
		Mockito.verifyNoMoreInteractions(sender);
	}
}
