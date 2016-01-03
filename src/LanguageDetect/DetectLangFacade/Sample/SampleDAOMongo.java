package LanguageDetect.DetectLangFacade.Sample;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

/**
 * Created by MuratCan on 3.1.2016.
 */
public class SampleDAOMongo implements SampleDAO {
    @Override
    public ArrayList<Sample> getAllSamples() {
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("langdetect");
        return null;
    }

    @Override
    public Sample getSample(String language) {
        return null;
    }

    @Override
    public boolean addSample(Sample sample) {
        return false;
    }

    @Override
    public boolean updateSample(Sample sample) {
        return false;
    }

    @Override
    public boolean deleteSample(Sample sample) {
        return false;
    }
}
