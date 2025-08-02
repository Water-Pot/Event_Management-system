package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Modal extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a main scene with a button to show the modal
        VBox root = new VBox(10);
        Button showModalButton = new Button("Show Modal");

        showModalButton.setOnAction(e -> showModal(primaryStage));

        root.getChildren().add(showModalButton);

        Scene mainScene = new Scene(root, 800, 800);
        primaryStage.setTitle("JavaFX Modal Example");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    // Method to create and show the modal dialog
    private void showModal(Stage ownerStage) {
        // Create a new stage for the modal dialog
        Stage modalStage = new Stage();
        modalStage.initOwner(ownerStage);  // Set the owner of the modal to be the main window
        modalStage.initModality(Modality.WINDOW_MODAL);  // Make the window modal

        // Create a simple layout for the modal
        VBox modalRoot = new VBox(10);
        Button closeButton = new Button("Close Modal");

        closeButton.setOnAction(e -> modalStage.close());  // Close the modal on button click

        modalRoot.getChildren().add(closeButton);

        Scene modalScene = new Scene(modalRoot, 600, 600);
        modalStage.setTitle("Modal Dialog");
        modalStage.setScene(modalScene);
        modalStage.showAndWait();  // Show the modal and block interaction with the main window
    }

    public static void main(String[] args) {
        launch(args);
    }
}

