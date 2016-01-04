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
    public Label resultLabel;
    public Button addSampleBtn;
    public Button checkBtn;

    /**
     * Gets context from link and sets it as the contexTA's text
     */
    public void getContext(ActionEvent actionEvent) {
        try{
            Document doc = Jsoup.connect(linkTF.getText()).get();
            String  context = doc.select("div#mw-content-text").text();
            contextTA.setText(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * When checkBtn is clicked, this method creates a new
     * DetectLangFacade so the client doesn't have to know
     * about inner works. Facade calculates the probability
     * and determines the context's language.
     */
    public void check(ActionEvent actionEvent) {
        DetectLangFacade newFacade = new DetectLangFacade(contextTA.getText());
        resultLabel.setText(newFacade.getResult());
    }

    /**
     *Opens AddSample form.
     */
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
