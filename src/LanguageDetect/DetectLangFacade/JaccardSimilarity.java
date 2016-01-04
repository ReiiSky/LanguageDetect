package LanguageDetect.DetectLangFacade;

import LanguageDetect.DetectLangFacade.Sample.Sample;
import LanguageDetect.DetectLangFacade.Subject.Subject;
import LanguageDetect.DetectLangFacade.WordList.Word;
import LanguageDetect.DetectLangFacade.WordList.WordList;

/**
 * Calculates the similarities of the lists.
 *
 * Created by MuratCan on 4.1.2016.
 */
public class JaccardSimilarity {
    private double result;

    public JaccardSimilarity(WordList sample, WordList subject) {
        double intersection = 0;
        for(Word word : subject.getList()){
            if(sample.getList().contains(word)) intersection++;//increments the intersection count.
        }
        this.result = (double) (intersection / ((double)(sample.getList().size()) // intersection/union
                + (double)(subject.getList().size())
                - intersection));
    }

    public Double getResult() { return new Double(result); }
    public void setResult(Double result) { this.result = result; }
}
