package LanguageDetect;

import LanguageDetect.DetectLangFacade.DetectLangFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class MainFormController {
    public TextField linkTF;
    public TextArea contextTA;
    public Button getContextBtn;
    public Button checkBtn;
    public Label resultLabel;
    public Button addSampleBtn;

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
        contextTA.appendText(newFacade.getFullwordResults().toString() + "\n");
        contextTA.appendText(newFacade.getTrigramResults().toString());
    }

    public void addSampleBtn(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddSample.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Add Samples");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
