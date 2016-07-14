package tpAnual.batch.procesos;

import java.util.Set;

import tpAnual.Terminal;

public class ActivarMails implements AccionTerminal{
	
	public void realizarAccion(Set<Terminal> terminales){
		terminales.forEach(terminal -> terminal.activarMails());
	}
	
}