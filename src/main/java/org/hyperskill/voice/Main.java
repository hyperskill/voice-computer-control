package org.hyperskill.voice;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;
public class Main {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
        configuration.setUseGrammar(false);

        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
        System.out.println("Записывает");
        recognizer.startRecognition(true);

        SpeechResult result;
        result=recognizer.getResult();
        String word=result.getHypothesis();
        System.out.println("your word:");
        System.out.println(word);
        recognizer.stopRecognition();
    }
}
