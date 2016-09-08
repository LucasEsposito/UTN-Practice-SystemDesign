package tpAnual;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.uqbar.geodds.Point;

import tpAnual.POIs.Poi;

public class Mapa {
	
	public List<Poi> pois = new ArrayList<Poi>();
	private Set<Terminal> terminales = new HashSet<Terminal>();
	
	private static Mapa instance = null;
	
	private Mapa(){
		//Para evitar que sea instanciada esta clase.
	}
	
	public static Mapa getInstance(){
		if(instance==null){
			instance = new Mapa();
		}
		return instance;
	}
	
	public static void resetSingleton(){
	    instance = null;
	}
	// Busqueda de texto libre de pois
	
	public void alta(Poi poi){
		pois.add(poi);
	}
	
	public void baja(Poi poi){
		pois.remove(poi);
	}
	
	// Cercania de poi
	
	public boolean estaCerca(Poi poi, Point unPunto) {
		return poi.estaCerca(unPunto);
	}
	
	private double distanciaEntrePois(Poi poi1, Poi poi2){
		return poi1.getUbicacion().distance(poi2.getUbicacion());
	}
	
	public boolean estaAMenosDe(Poi poi1, Poi poi2, double distancia){
		return distanciaEntrePois(poi1,poi2) < distancia;
	}
	
	// Manejo de lista de pois
	public List<Poi> pois(){
		return pois;
	}

	public int cantidadPois() {
		return pois.size();
	}
	
	// Setters y getters
	
	public void agregarTerminal(Terminal terminal){
		this.terminales.add(terminal);
	}
	public Set<Terminal> terminales(){
		return this.terminales;
	}
	
	public Poi findPoi(String nombre){
		Poi poiAModificar = pois.stream()
				.filter(poi->poi.getNombre().equals(nombre))
				.collect(Collectors.toList())
				.get(0);
		return poiAModificar;
	}

}
