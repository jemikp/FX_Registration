package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextField email;
    public TextField mobile;
    public RadioButton male;
    public RadioButton female;
    public CheckBox english;
    public CheckBox hindi;
    public CheckBox gujarati;


    @FXML
    private TextField fname;
    @FXML
    private TextField mname;
    @FXML
    private TextField lname;
    private Label output;
    //private TextField empty = new TextField("Items should not be empty");

    @FXML
    private ComboBox<String> day;
    ObservableList<String> list = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14");

    @FXML
    private ComboBox<String> month;
    ObservableList<String> list1 = FXCollections.observableArrayList("","January","Febuary","March","April","May","June","July","August","September","October","November","December");

    @FXML
    private ComboBox<String> year;
    ObservableList<String > list2 = FXCollections.observableArrayList("1998","1999","2000","2001","2002");
    ToggleGroup gender = new ToggleGroup();
    //Group languages = new Group(english,hindi,gujarati);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        day.setItems(list);
        month.setItems(list1);
        year.setItems(list2);


        male.setToggleGroup(gender);
        female.setToggleGroup(gender);




    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
       //String fname1 = fname.getText();
        //String mname1 = mname.getText();

        if (fname.getText().isEmpty()){
            //output.setText("Jemik");
            showAlert(Alert.AlertType.ERROR,"Please enter your first name");
        }
        else if (mname.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,"Please enter your middle name");
        }
        else if (lname.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,"Please enter your last name");
        }
        else if (email.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,"Please enter your email address");
        }
        else if (mobile.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,"Please enter your mobile number");
        }
        else if(gender.getSelectedToggle() == null){
            showAlert(Alert.AlertType.ERROR,"Please select gender");
        }
        else if (!english.isSelected() && !hindi.isSelected() && !gujarati.isSelected()){
            showAlert(Alert.AlertType.ERROR,"Please select language");
        }
        else if ((day.getSelectionModel().getSelectedItem() == null)){
            showAlert(Alert.AlertType.ERROR,"Please select birth day");
        }
        else if (month.getSelectionModel().getSelectedItem() == null){
            showAlert(Alert.AlertType.ERROR,"Please enter birth month");
        }
        else if (year.getSelectionModel().getSelectedItem() == null){
            showAlert(Alert.AlertType.ERROR,"Please enter birth year");
        }else {

            System.out.println("SUCCESS");

            Stage stage = new Stage();

            Parent root = FXMLLoader.load(getClass().getResource("sample1.fxml"));
            stage.setTitle("Account");
            stage.setScene(new Scene(root, 600, 600));
            stage.show();
        }

    }

    private void showAlert(Alert.AlertType alertType,String message){
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.show();
    }
}
