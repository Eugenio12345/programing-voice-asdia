package org.myprogram.command.voice;

import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.Recognizer;
import javax.speech.recognition.Result;
import javax.speech.recognition.ResultAdapter;
import javax.speech.recognition.ResultEvent;
import javax.speech.recognition.ResultToken;
import javax.speech.recognition.RuleGrammar;

public class ReconocedorVoz extends ResultAdapter  {
	static Recognizer oreja;
	String palabra;
	private Acciones acciones;
	ViewAsdia reconocedor;

	public void iniciarRec() {
		try {
			// Se configura al reconocedor para que entienda el idioma inglés
			oreja = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
			oreja.allocate();
			FileReader grammar1 = new FileReader("Programas.txt"); // ruta donde
			RuleGrammar rg = oreja.loadJSGF(grammar1);// Establece la forma en
			rg.setEnabled(true); // accesa al archivo

			oreja.addResultListener(new ReconocedorVoz());
			oreja.commitChanges();
			oreja.requestFocus();
			oreja.resume();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return;
	}

	public void resultAccepted(ResultEvent re) {
		Result res = (Result) (re.getSource());
		ResultToken tokens[] = res.getBestTokens();
		acciones = new Acciones();
		try {
			for (int i = 0; i < tokens.length; i++) {
				palabra = tokens[i].getSpokenText();
				this.acciones.elegirAccion(palabra);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}