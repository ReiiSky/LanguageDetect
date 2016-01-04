package LanguageDetect.DetectLangFacade;

import LanguageDetect.DetectLangFacade.Sample.Sample;
import LanguageDetect.DetectLangFacade.Sample.SampleDAOMongo;
import LanguageDetect.DetectLangFacade.Subject.Subject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by MuratCan on 3.1.2016.
 */
public class DetectLangFacade {
    private ArrayList<Sample> samples;
    private Subject subject;
    private HashMap<String, Float> fullwordResults;

    public DetectLangFacade(){}
    public DetectLangFacade(String context){
        this.samples = new SampleDAOMongo().getAllSamples();
        String specialChars = "";
        for(Sample s : samples){
            specialChars += s.getSpecialChars();
        }
        this.subject = new Subject(context, specialChars);

    }
}
