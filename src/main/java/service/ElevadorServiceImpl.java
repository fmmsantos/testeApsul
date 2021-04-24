package service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
		try {
			List<UsoElevador> lista = buscarUsoElevador();								
			System.out.println(lista.size());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for ()

		return null;
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
