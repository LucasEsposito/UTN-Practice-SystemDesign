package tpAnual;

import java.util.HashSet;
import java.util.Set;
import org.junit.*;

public class TestBuscador {
	private Set<String> tags = new HashSet<String>();
	private Colectivo tipo = new Colectivo();
	private Poi poi = new Poi(tipo, "107", tags);
	private Poi poi2 = new Poi(tipo, "108", tags);
	private Mapa mapa = new Mapa();
	
	@Before
	public void init(){
		poi.agregarTag("107");
		poi.agregarTag("colectivo");
		mapa.agregarPoi(poi);
		
		poi2.agregarTag("108");
		poi2.agregarTag("colectivo");
		mapa.agregarPoi(poi2);
	}
	
	@Test
	public void buscaEsUnColecEnVezDeColectivoYSonDos(){
		Assert.assertEquals(2,mapa.buscarPoi("es un colec").size());
	}
	
	@Test
	public void busca10EnVezDe107y108YEncuentraDos(){
		Assert.assertEquals(2,mapa.buscarPoi("10").size());
	}
	
	@Test
	public void siNoContienenTagNoEncuentra(){
		Assert.assertEquals(0,mapa.buscarPoi("colectivos").size());
	}
}
