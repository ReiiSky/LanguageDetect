package LanguageDetect.DetectLangFacade.Sample;

import java.util.ArrayList;

/**
 * Created by MuratCan on 3.1.2016.
 */
public interface SampleDAO {
    ArrayList<Sample> getAllSamples();
    Sample getSample(String language);
    boolean addSample(Sample sample);
    boolean updateSample(Sample sample);
    boolean deleteSample(Sample sample);
}
