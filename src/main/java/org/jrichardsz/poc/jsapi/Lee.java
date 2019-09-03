package org.jrichardsz.poc.jsapi;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RM-RCM
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cmop
 */
import javax.speech.*;
import javax.speech.synthesis.*;
import java.util.*;

public class Lee {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(hablar("Hola!! cual es tu nombre?"));
		String nombre = sc.nextLine();
		System.out.println(hablar("Mucho gusto "+nombre+", En que te puedo apoyar?"));
		String tarea = sc.nextLine();
		hablar("Entendido "+ nombre+", dame un minuto");
		hablar("Completando tarea.........100% completada");
	}

	public static String hablar(String say) {
		try {
			SynthesizerModeDesc required = new SynthesizerModeDesc();
			required.setLocale(Locale.ROOT);
			Voice voice = new Voice(null, Voice.AGE_CHILD, Voice.AGE_CHILD, null);
			required.addVoice(voice);
			Synthesizer synth = Central.createSynthesizer(null);
			synth.allocate();
			synth.resume();
			synth.speakPlainText(say, null);
			synth.waitEngineState(Synthesizer.QUEUE_EMPTY);
			synth.deallocate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return say;
	}
}
