package LanguageDetect;

import LanguageDetect.DetectLangFacade.DetectLangFacade;
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
        DetectLangFacade newFacade = new DetectLangFacade(contextTA.getText());
        contextTA.clear();
        //for(Word w : newFacade.getSamples().get(0).getFullword().getList() ){
          //  contextTA.appendText(w.getString() + " , " + w.getCount() + "\n");
        //}
        contextTA.appendText("size1 ," +newFacade.getSubject().getFullword().getList().size());
        contextTA.appendText("size2 ," +newFacade.getSamples().get(0).getFullword().getList().size() + "\n");
        //for(Word w : newFacade.getSubject().getFullword().getList()){
          //  contextTA.appendText(w.getString() + " , " + w.getCount() + "\n");
        //}
        contextTA.appendText(newFacade.getFullwordResults().toString());
    }
}
