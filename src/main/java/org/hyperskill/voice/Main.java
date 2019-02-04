package org.hyperskill.voice;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        conf.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        conf.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
        conf.setGrammarPath("grammar");
        conf.setGrammarName("fff");
        conf.setUseGrammar(true);


        LiveSpeechRecognizer lsr = new LiveSpeechRecognizer(conf);
        lsr.startRecognition(false);
        SpeechResult speechResult;

        while ((speechResult = lsr.getResult()) != null){
            String hyp = speechResult.getHypothesis();
            if (hyp.equals("hello") ||
                    hyp.equals("hi") ||
                    hyp.equals("salute")) {
                System.out.println("Hello, creator");
            }
            if(hyp.contains("show")){
                LocalDateTime ldt = LocalDateTime.now();
                if(hyp.contains("date")){
                    System.out.format("initial date is %s", ldt.format(DateTimeFormatter.ISO_LOCAL_DATE));
                }
                if(hyp.contains("time")){
                    System.out.format("initial date is %s", ldt.format(DateTimeFormatter.ISO_LOCAL_TIME));
                }
            }
        }
        lsr.stopRecognition();

    }
}
