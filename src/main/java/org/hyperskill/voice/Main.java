package org.hyperskill.voice;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
        configuration.setGrammarPath("resource:/org/hyperskill/voice");
        configuration.setGrammarName("grammar");
        configuration.setUseGrammar(true);
        LocalDate now;
        LocalTime now1;
        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
        System.out.println("Записывает");
        recognizer.startRecognition(true);
        SpeechResult result;
        while((result = recognizer.getResult()) != null){
            String word=result.getHypothesis();
            System.out.println("you said: "+word);
            if(word.equals("show date"))
            {now = LocalDate.now();
            System.out.println(now);}
            if(word.equals("show time")){
                now1 = LocalTime.now();
                System.out.println(now1);
            }

        }

        recognizer.stopRecognition();
    }
}
