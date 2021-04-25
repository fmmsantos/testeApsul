package service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import main.Main;
import model.UsoElevador;


public class ElevadorServiceImpl implements IElevadorService {
	
	public List<UsoElevador> buscarUsoElevador() throws IOException {
		InputStream json = Main.class.getResourceAsStream("/input.json");
		
		String j = org.apache.commons.io.IOUtils.toString(json);
		
		Type tipoLista = new TypeToken<List<UsoElevador>>() {}.getType();
		List<UsoElevador> lista = new Gson().fromJson(j, tipoLista);
		return lista;
		
	}

	public List<Integer> andarMenosUtilizado() {
		InputStream json = Main.class.getResourceAsStream("/input.json");
		
		String j = null;
		try {
			j = org.apache.commons.io.IOUtils.toString(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Type tipoLista = new TypeToken<List<UsoElevador>>() {}.getType();
		List<UsoElevador> lista = new Gson().fromJson(j, tipoLista);
							
			Integer andar0=0;
			Integer andar1=0; 
			Integer andar2=0;
			Integer andar3=0;
			Integer andar4=0;
			Integer andar5=0;
			Integer andar6=0;
			Integer andar7=0;
			Integer andar8=0;
			Integer andar9=0;
			Integer andar10=0;
			Integer andar11=0;
			Integer andar12=0;
			Integer andar13=0;
			Integer andar14=0;
			Integer andar15=0;
			Integer andar16=0;
			for(UsoElevador uso : lista) {				
				if(uso.getAndar().equals(0)) andar0++;
				else if(uso.getAndar().equals(0)) andar0++;
				else if(uso.getAndar().equals(1)) andar1++;
				else if(uso.getAndar().equals(2)) andar2++;
				else if(uso.getAndar().equals(3)) andar3++;
				else if(uso.getAndar().equals(4)) andar4++;
				else if(uso.getAndar().equals(5)) andar5++;
				else if(uso.getAndar().equals(6)) andar6++;
				else if(uso.getAndar().equals(7)) andar7++;
				else if(uso.getAndar().equals(8)) andar8++;
				else if(uso.getAndar().equals(9)) andar9++;
				else if(uso.getAndar().equals(10)) andar10++;
				else if(uso.getAndar().equals(11)) andar11++;
				else if(uso.getAndar().equals(12)) andar12++;
				else if(uso.getAndar().equals(13)) andar13++;
				else if(uso.getAndar().equals(14)) andar14++;
				else if(uso.getAndar().equals(15)) andar15++;
				else if(uso.getAndar().equals(16)) andar16++;

			}
			Integer somaArray[] = { andar0, andar1,andar2,andar3,andar4,andar5,andar6,andar7,andar8,andar9,andar10,andar11,andar12,
					andar13,andar14,andar15,andar16};			
			Arrays.sort(somaArray);
			Integer menor = 0;
			List<Integer> valores = Arrays.asList(somaArray);
			List<Integer> menoresValores = new ArrayList<Integer>();
			for(Integer resultado :valores) {
				if (resultado < menor ) {
					menoresValores.add(resultado);
				}
			}
			

		return menoresValores;
	}

	public List<Character> elevadorMaisFrequentado() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Character> elevadorMenosFrequentado() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
		// TODO Auto-generated method stub
		return null;
	}

	public float percentualDeUsoElevadorA() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float percentualDeUsoElevadorB() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float percentualDeUsoElevadorC() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float percentualDeUsoElevadorD() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float percentualDeUsoElevadorE() {
		// TODO Auto-generated method stub
		return 0;
	}

}
