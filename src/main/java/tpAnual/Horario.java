package tpAnual;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Horario  {
	private DayOfWeek diaDesde;
	private DayOfWeek diaHasta;
	private LocalTime desde;
	private LocalTime hasta;
	
	//esta entre el diaDesde y el diaHasta
	private boolean cumpleRango(DayOfWeek dia, LocalTime hora)
	{
		return (dia.getValue() >= diaDesde.getValue()) && 
				(dia.getValue() <= diaHasta.getValue());
	}
	
	private boolean cumpleDia(DayOfWeek dia){
		return diaDesde.equals(dia);
	}
	
	//estaDentro del horario especificado
	private boolean estaEnHorario(LocalTime hora){
		return (hora.isAfter(desde) && hora.isBefore(hasta));
	}
	
	public boolean estaEnFranjaHoraria(DayOfWeek dia, LocalTime hora){
		 return (cumpleDia(dia) || cumpleRango(dia,hora)) && estaEnHorario(hora);
	}
	
	//se usa si es un rango de dias
	Horario(DayOfWeek inicio,DayOfWeek fin, String desde, String hasta){
		this.diaHasta = fin;
		this.diaDesde = inicio;
		this.desde= LocalTime.parse(desde);
		this.hasta= LocalTime.parse(hasta); 
	}
	
	//se usa por si es un unico dia
	Horario(DayOfWeek inicio, String desde, String hasta){   
		this.diaDesde = inicio;
		this.diaHasta = inicio;
		this.desde= LocalTime.parse(desde);
		this.hasta= LocalTime.parse(hasta);
	}
}
