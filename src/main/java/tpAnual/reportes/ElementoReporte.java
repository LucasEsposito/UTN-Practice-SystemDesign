package tpAnual.reportes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import tpAnual.Terminal;
import tpAnual.util.bd.mysql.LocalDateConverter;

@Entity
public class ElementoReporte {
	@Id @GeneratedValue @Column (name="cod_elemento")
	private long numeroElemento;
	@Convert(converter = LocalDateConverter.class)
	private LocalDate fecha;
	private Integer cantidadBusquedas=0;
	@OneToOne
	private Terminal terminal;
	private Integer cantidadPoisEncontrados=0;
	@ElementCollection @Cascade({CascadeType.ALL})
	private List<Integer> busquedasParciales = new ArrayList<Integer>();
	
	
	private ElementoReporte(){}
	
	public boolean esDeLaFecha(LocalDate fecha){
		return this.fecha.toString().equals(fecha.toString());
	}
	
	public boolean esDeLaTerminal(Terminal terminal){
		return this.terminal.equals(terminal);
	}
	
	// Factory methods
	public static ElementoReporte crearConFecha(LocalDate fecha){
		ElementoReporte elemento = new ElementoReporte();
		elemento.setFecha(fecha);
		return elemento;
	}
	
	
	public static ElementoReporte crearConTerminal(Terminal terminal){
		ElementoReporte elemento = new ElementoReporte();
		elemento.setTerminal(terminal);
		return elemento;
	}
	
	/*--------Setters----------*/
	
	public void setFecha(LocalDate fecha){
		this.fecha = fecha;
	}
	
	public void setTerminal(Terminal terminal){
		this.terminal = terminal;
	}
	public void registrarBusqueda(){
		cantidadBusquedas++;
	}
	
	public void agregarBusquedasParciales(int cantidadEncontrada){
		busquedasParciales.add(cantidadEncontrada);
	}
	
	
	/*--------Getters----------*/
	
	public LocalDate getfecha(){
		return fecha;
	}
	
	public Integer getCantidadBusquedas(){
		return cantidadBusquedas;
	}
	
	public Terminal getTerminal(){
		return terminal;
	}
	
	public Integer getCantidadPois(){
		return cantidadPoisEncontrados;
	}
	
	public List<Integer> getBusquedasParciales(){
		return busquedasParciales;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Integer getCantidadPoisEncontrados() {
		return cantidadPoisEncontrados;
	}

	public long getNumeroElemento() {
		return numeroElemento;
	}

	public void setNumeroElemento(long numeroElemento) {
		this.numeroElemento = numeroElemento;
	}

	public void setCantidadBusquedas(Integer cantidadBusquedas) {
		this.cantidadBusquedas = cantidadBusquedas;
	}

	public void setCantidadPoisEncontrados(Integer cantidadPoisEncontrados) {
		this.cantidadPoisEncontrados = cantidadPoisEncontrados;
	}

	public void setBusquedasParciales(List<Integer> busquedasParciales) {
		this.busquedasParciales = busquedasParciales;
	}
}