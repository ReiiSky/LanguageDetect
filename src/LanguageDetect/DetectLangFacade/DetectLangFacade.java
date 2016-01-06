package LanguageDetect.DetectLangFacade;

import LanguageDetect.DetectLangFacade.Sample.Sample;
import LanguageDetect.DetectLangFacade.Sample.SampleDAOMongo;
import LanguageDetect.DetectLangFacade.Subject.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A facade that determines given text's language.
 * All inner work is done in this facade so the user
 * doesn't have to know about the process.
 *
 * Created by MuratCan on 3.1.2016.
 */
public class DetectLangFacade {
    private ArrayList<Sample> samples;
    private Subject subject;
    private HashMap<String, Double> fullwordResults;
    private HashMap<String, Double> trigramResults;
    private String result;

    public DetectLangFacade(){}
    public DetectLangFacade(String context){
        this.samples = new SampleDAOMongo().getAllSamples();
        String specialChars = "";
        for(Sample s : samples){ // gets all samples special chars and puts them together
            specialChars += s.getSpecialChars();
        }
        this.subject = new Subject(context, specialChars); //creates the subject
        this.trigramResults = checkTrigram(this.samples, this.subject);//set of results according to trigram list.
        this.fullwordResults = checkFullwords(this.samples, this.subject); //set of results according to fullword list.
        if(subject.getFullword().getList().size() < 25) this.result = getFinalResult(trigramResults);
        else this.result = getFinalResult(fullwordResults);
         // final result.
    }

    public ArrayList<Sample> getSamples() { return samples; }
    public void setSamples(ArrayList<Sample> samples) { this.samples = samples; }

    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }

    public HashMap<String, Double> getFullwordResults() { return fullwordResults; }
    public void setFullwordResults(HashMap<String, Double> fullwordResults) { this.fullwordResults = fullwordResults; }

    public HashMap<String, Double> getTrigramResults() { return trigramResults; }
    public void setTrigramResults(HashMap<String, Double> trigramResults) { this.trigramResults = trigramResults; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    /**
     * calculates the subject's fullword list similarity to each sample's fullword similarity.
     * @param samples
     * @param subject
     * @return
     */
    private HashMap<String, Double> checkFullwords(ArrayList<Sample> samples, Subject subject){
        HashMap<String, Double> map = new HashMap<>();
        for(Sample sample : samples){
            map.put(sample.getLanguage(),new JaccardSimilarity(sample.getFullword(), subject.getFullword()).getResult());
        }
        return map;
    }
    /**
     * Calculates the subject's trigram list similarity to each sample's trigram similarity.
     * @param samples
     * @param subject
     * @return
     */
    private HashMap<String, Double> checkTrigram(ArrayList<Sample> samples, Subject subject){
        HashMap<String, Double> map = new HashMap<>();
        for(Sample sample : samples){
            map.put(sample.getLanguage(),new JaccardSimilarity(sample.getTrigram(), subject.getTrigram()).getResult());
        }
        return map;
    }

    /**
     * Determines the final result
     * @param results
     * @return
     */
    private String getFinalResult(HashMap<String, Double> results){
        String resultString = "";
        Double resultDouble = new Double(0);
        for(Map.Entry<String, Double> entry : results.entrySet()) {
            if(entry.getValue() > resultDouble) {
                resultDouble = entry.getValue();
                resultString = entry.getKey();
            }
        }
        return resultString;
    }
}
