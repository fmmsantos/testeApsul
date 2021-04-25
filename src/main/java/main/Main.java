package main;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.Gson;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.reflect.TypeToken;
import model.UsoElevador;
import service.ElevadorServiceImpl;



public class Main {
	public static void main(String[] args) throws Throwable{
	
		InputStream json = Main.class.getResourceAsStream("/input.json");
				
		String j = org.apache.commons.io.IOUtils.toString(json);
		
		Type tipoLista = new TypeToken<List<UsoElevador>>() {}.getType();
		List<UsoElevador> lista = new Gson().fromJson(j, tipoLista);
		
		/*for (UsoElevador uso : lista) {
		System.out.println(uso.getAndar());
		System.out.println(uso.getElevador());
		System.out.println(uso.getTurno());
		}
		*/
		System.out.println(lista.size());
	
	ElevadorServiceImpl elevador = new ElevadorServiceImpl();
	System.out.println("Elevador menos Utilizado: " + elevador.andarMenosUtilizado());

	}
}
