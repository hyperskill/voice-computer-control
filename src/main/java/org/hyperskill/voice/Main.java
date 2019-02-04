package org.hyperskill.voice;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        Configuration conf = new Configuration();
        conf.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
//        conf.setAcousticModelPath("resource:/edu/cmu/sphinx/models/ru-ru/ru-ru");
        conf.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
//        conf.setDictionaryPath("resource:/edu/cmu/sphinx/models/ru-ru/cmudict-ru-ru.dict");
        conf.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
//        conf.setLanguageModelPath("resource:/edu/cmu/sphinx/models/ru-ru/ru-ru.lm.bin");

        LiveSpeechRecognizer lsr = new LiveSpeechRecognizer(conf);
        lsr.startRecognition(true);
        SpeechResult speechResult = lsr.getResult();
        lsr.stopRecognition();
        System.out.println(speechResult.getHypothesis());
    }
}
