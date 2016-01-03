package LanguageDetect;

import LanguageDetect.DetectLangFacade.Subject.Subject;
import LanguageDetect.DetectLangFacade.WordList.Word;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

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
        Subject newSubject = new Subject(contextTA.getText());
        contextTA.clear();
        for(Word w : newSubject.getFullWord().getList()){
            contextTA.appendText(w.getString() + "," + w.getCount() + "\n");
        }
    }
}
