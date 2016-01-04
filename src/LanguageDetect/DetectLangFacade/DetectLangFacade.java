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
    private HashMap<String, Double> fullwordResults;

    public DetectLangFacade(){}
    public DetectLangFacade(String context){
        this.samples = new SampleDAOMongo().getAllSamples();
        String specialChars = "";
        for(Sample s : samples){
            specialChars += s.getSpecialChars();
        }
        this.subject = new Subject(context, specialChars);
        this.fullwordResults = checkFullwords(this.samples, this.subject);
    }

    public ArrayList<Sample> getSamples() { return samples; }
    public void setSamples(ArrayList<Sample> samples) { this.samples = samples; }

    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }

    public HashMap<String, Double> getFullwordResults() { return fullwordResults; }
    public void setFullwordResults(HashMap<String, Double> fullwordResults) { this.fullwordResults = fullwordResults; }

    private HashMap<String, Double> checkFullwords(ArrayList<Sample> samples, Subject subject){
        HashMap<String, Double> map = new HashMap<>();
        for(Sample sample : samples){
            map.put(sample.getLanguage(),new JaccardSimilarity(sample.getFullword(), subject.getFullword()).getResult());
        }
        return map;
    }
}
