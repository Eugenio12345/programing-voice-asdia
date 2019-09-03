package org.myprogram.command.voice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.speech.recognition.Recognizer;
import javax.speech.recognition.Result;
import javax.speech.recognition.ResultAdapter;
import javax.speech.recognition.ResultEvent;
import javax.speech.recognition.ResultToken;

import org.jrichardsz.poc.jsapi.Lee;

public class Programas extends ResultAdapter {
	static Recognizer oreja;
	String Programa;

	public void resultAccepted(ResultEvent e) {
		Result res = (Result) (e.getSource());
		ResultToken tokens[] = res.getBestTokens();
		String Frase[] = new String[1];
		Frase[0] = "";

		for (int i = 0; i < tokens.length; i++) {
			Programa = tokens[i].getSpokenText();
			Frase[0] += Programa + " ";
			System.out.print(Programa + " ");
		}
		System.out.println();
        try {
			this.elegirAccion(Programa);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}


	public void elegirAccion(String programa) throws IOException {
		Process p = null;
		switch (programa) {
		case "Facebook":
			System.out.println(Lee.hablar("Abriendo Facebook..."));
			p = Runtime.getRuntime().exec("cmd.exe /c start Chrome www.facebook.com");
			this.prepareCommand(p);
			break;
		case "Reproductor":
			System.out.println("Abriendo Windows Media Player...");
			p = Runtime.getRuntime().exec("cmd.exe /c start wmplayer");
			this.prepareCommand(p);
			break;
		case "Chrome":
			System.out.println("Abriendo Chrome...");
			p = Runtime.getRuntime().exec("cmd.exe /c start Chrome");
			this.prepareCommand(p);
			break;
		case "Paint":
			System.out.println("Abriendo Paint Brush...");
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