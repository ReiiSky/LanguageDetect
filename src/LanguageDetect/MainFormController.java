package LanguageDetect;

import LanguageDetect.DetectLangFacade.Sample.Sample;
import LanguageDetect.DetectLangFacade.Sample.SampleDAOMongo;
import LanguageDetect.DetectLangFacade.Subject.Subject;
import LanguageDetect.DetectLangFacade.WordList.Word;
import LanguageDetect.DetectLangFacade.WordList.WordListFactory;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class MainFormController {
    public TextField linkTF;
    public TextArea contextTA;
    public Button getContextBtn;
    public Button checkBtn;
    public Label resultLabel;

    public void getContext(ActionEvent actionEvent) {
        try{
            Document doc = Jsoup.connect(linkTF.getText()).get();
            String  context = doc.select("div#mw-content-text").text();
            contextTA.setText(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void check(ActionEvent actionEvent) {
        SampleDAOMongo dao = new SampleDAOMongo();
        Sample sample = dao.getSample("türkçe");
        for(Word w : sample.getFullWord().getList()){
            contextTA.appendText(w.getString() + " , " + w.getCount() + "\n");
        }
    }
}
