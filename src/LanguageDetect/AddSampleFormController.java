package LanguageDetect;

import LanguageDetect.DetectLangFacade.DetectLangFacade;
import LanguageDetect.DetectLangFacade.Sample.Sample;
import LanguageDetect.DetectLangFacade.Sample.SampleDAOMongo;
import LanguageDetect.DetectLangFacade.WordList.WordListFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class AddSampleFormController {

    public TextField languageTF;
    public TextArea linksTA;
    public TextField specCharTF;
    public Button addBtn;

    public void addSamples(ActionEvent actionEvent) {
        String language = languageTF.getText();
        String specialChars = specCharTF.getText();
        String[] links = linksTA.getText().split("\\s+");
        SampleDAOMongo dao = new SampleDAOMongo();
        Sample sample = dao.getSample(language);
        if (sample == null) {
            try {
                Document doc = Jsoup.connect(links[0]).get();
                String context = doc.select("div#mw-content-text").text();
                sample = new Sample(null, language, specialChars,
                        new WordListFactory().create("Fullword", context, specialChars),
                        new WordListFactory().create("Trigram", context, specialChars));
                links[0] = null;
                for (String link : links) {
                    try {
                        if (link != null) {
                            Document udoc = Jsoup.connect(link).get();
                            String ucontext = udoc.select("div#mw-content-text").text();
                            sample.updateFullword(new WordListFactory().create("Fullword", ucontext, specialChars));
                            sample.updateTrigram(new WordListFactory().create("Trigram", ucontext, specialChars));
                        }
                    } catch (Exception e) {
                    }
                }
                dao.updateSample(sample);
            } catch (Exception e) {
            }
        } else {
            try {
                for (String link : links) {
                    try {
                        Document udoc = Jsoup.connect(link).get();
                        String ucontext = udoc.select("div#mw-content-text").text();
                        sample.updateFullword(new WordListFactory().create("Fullword", ucontext, specialChars));
                        sample.updateTrigram(new WordListFactory().create("Trigram", ucontext, specialChars));
                    } catch (Exception e) {
                    }
                }
                dao.updateSample(sample);
            } catch (Exception ignored) {
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Adding Operation");
        alert.setHeaderText("Done");
        alert.show();
    }
}
