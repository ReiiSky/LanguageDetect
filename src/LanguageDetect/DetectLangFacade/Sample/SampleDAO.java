package LanguageDetect.DetectLangFacade.Sample;

import java.util.ArrayList;

/**
 * Data Access Object Pattern Interface for Sample.
 */
public interface SampleDAO {
    ArrayList<Sample> getAllSamples();
    Sample getSample(String language);
    boolean addSample(Sample sample);
    boolean updateSample(Sample sample);
    boolean deleteSample(String language);
}
