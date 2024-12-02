package com.example.L6;

import com.example.L6.view.PersonOverviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.L6.model.Person;
import javafx.stage.Modality;
import com.example.L6.view.PersonEditDialogController;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private final ObservableList<Person> personData = FXCollections.observableArrayList();

    public MainApp() {
        // зразок  данних
        personData.add(new Person("John", "Smith"));
        personData.add(new Person("Emily", "Johnson"));
        personData.add(new Person("Michael", "Brown"));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Lab6");

        initRootLayout();
        showPersonOverview();
    }


    public void initRootLayout() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/com/example/L6/RootLayout.fxml"));
        try {
            rootLayout = fxmlLoader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading RootLayout.fxml", e);
        }
    }

    public void showPersonOverview() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/com/example/L6/PersonOverview.fxml"));
        try {
            AnchorPane personOverview = fxmlLoader.load();
            rootLayout.setCenter(personOverview);
            PersonOverviewController controller=fxmlLoader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading PersonOverview.fxml", e);
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public boolean showPersonEditDialog(Person person) {
        try{
            FXMLLoader loader=new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("/com/example/L6/PersonEditDialog.fxml"));
            AnchorPane page= (AnchorPane)loader.load();
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene=new Scene(page);
            dialogStage.setScene(scene);
            PersonEditDialogController controller=loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);
            dialogStage.showAndWait();
            return controller.isOkClicked();
        }catch(IOException e) {e.printStackTrace(); return false;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
