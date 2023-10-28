package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneControl {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void ChangeToHomePage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ChangeToEffortLogEditor(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EffortLogEditor.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ChangeToDefectLog(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("DefectLog.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ChangeToDefinitions(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Definitions.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ChangeToEffortDefectLog(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EffortDefectLog.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ChangeToPlanningPoker(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("PlanningPoker.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
