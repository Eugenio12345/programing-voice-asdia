package org.myprogram.command.voice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.jrichardsz.poc.jsapi.Lee;

public class Acciones {

	
	public void elegirAccion(String programa) throws IOException {
		System.out.println("Imprimiendo accion:::::" + programa);
		Process p = null;
		switch (programa) {
		case "Facebook":
			System.out.println(Lee.hablar("Abriendo Facebook..."));
			p = Runtime.getRuntime().exec("cmd.exe /c start Chrome www.facebook.com");
			this.prepareCommand(p);
			break;
		case "Reproductor":
			System.out.println(Lee.hablar("Abriendo Windows Media Player..."));
			p = Runtime.getRuntime().exec("cmd.exe /c start wmplayer");
			this.prepareCommand(p);
			break;
		case "Chrome":
			System.out.println(Lee.hablar("Abriendo Chrome..."));
			p = Runtime.getRuntime().exec("cmd.exe /c start Chrome");
			this.prepareCommand(p);
			break;
		case "Abre por":
			System.out.println(Lee.hablar("Abriendo YouTube..."));
			p = Runtime.getRuntime().exec("cmd.exe /c Chrome start www.youtube.com");
			this.prepareCommand(p);
			break;
		case "Paint":
			System.out.println(Lee.hablar("Abriendo Paint Brush..."));
			// Se lanza el ejecutable.
			p = Runtime.getRuntime().exec("cmd.exe /c start pbrush");
			this.prepareCommand(p);
			break;
		default:
			Lee.hablar("No he recibido ninguna instruccion");
			break;
		}
	}
	
	public void prepareCommand(Process p) {
		try {
			// Se obtiene el stream de salida del programa
			InputStream is = p.getInputStream();
			/*
			 * Se prepara un bufferedReader para poder leer la salida más
			 * comodamente.
			 */
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			// Se lee la primera linea
			String aux = br.readLine();
			while (aux != null) {
				System.out.println(aux);
				aux = br.readLine();
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
	}
}
