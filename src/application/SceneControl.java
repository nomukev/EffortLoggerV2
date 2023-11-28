package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.*;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceneControl implements Initializable{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//custom variables
	List<EffortLog> logs = new ArrayList<EffortLog>();
	//ObservableList<EffortLog> observeLogs = FXCollections.observableArrayList(logs);
	
	//Variables in the program (fx:id)
	@FXML
	private Label homeErrorText;
	@FXML
	private Label elErrorText;
	@FXML
	private ChoiceBox elEditorChoices = new ChoiceBox();// = new ChoiceBox<EffortLog>(FXCollections.observableArrayList(logs));
	@FXML
	private TextField elEditLogName;
	@FXML
	private TextField elEditEffortValue;
	@FXML
	private Label ppErrorText;
	@FXML
	private Label ppAverageText;
	
	//Methods below handle switching between scenes
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
	
	
	//method creates a new EffortLog and adds it to the ArrayList
	//TODO: change so future variables (date, defects, etc.) can be placed in new logs
	//also TODO: change this so it correctly updates the array and choicebox
	public void createEffortLog() {
		EffortLog e = new EffortLog();
		logs.add(e);
		elEditorChoices.getItems().addAll(logs);
		//elEditorChoices = new ChoiceBox<EffortLog>(FXCollections.observableArrayList(logs));
		//elEditorChoices.setItems((ObservableList<EffortLog>) logs);
	}
	
	//made by Kevin Nomura
	//saves edits made to an Effort Log's name and effort value
	//checked for validity with a scanner
	public void saveEditsToEffortLog(ActionEvent event) {
		//check Edit Name field
		String editedName = elEditLogName.getText();
		//checks if new name is proper length (1-20 characters)
		if (editedName.length() < 1 || editedName.length() > 20) {
			elErrorText.setText("ERROR: invalid name length (must be 1-20 characters)");
			return;
		} else {
			System.out.println("name check success!");
		}
		
		//check Edit Effort Value field
		String editedEffortValue = elEditEffortValue.getText();
		Scanner intChecker = new Scanner(editedEffortValue);
		//checks if new effort value is an int
		if (intChecker.hasNextInt()) {
			int newEffortVal = intChecker.nextInt();
			//checks if new effort value is between 1-10
			if (newEffortVal < 1 || newEffortVal > 10) {
				elErrorText.setText("ERROR: invalid effort value (must be number 1-10)");
				intChecker.close();
				return;
			//if both tests pass, save name and effort value
			} else {
				System.out.println("value check success!");
				System.out.println("both checks passed, saving values");
			}
		} else {
			elErrorText.setText("ERROR: effort value must be an integer between 1-10");
			intChecker.close();
			return;
		}
		intChecker.close();
	}

	//TODO: fix this method so it correctly adds our logs arraylist
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		/*List<EffortLog> list = new ArrayList<EffortLog>();
		EffortLog e = new EffortLog();
		list.add(e);*/ //ignore these, just made for testing
		ObservableList obList = FXCollections.observableArrayList(logs);
		elEditorChoices.getItems().clear();
		elEditorChoices.setItems(obList);
		
	}
	
	//Kevin Nomura, Planning Poker prototype
	//calculate the weighted average of given logs
	//BASE CASE
	public void avg1() {
		logs.clear();
		EffortLog el1 = new EffortLog(7, 1);
		EffortLog el2 = new EffortLog(5, 2);
		EffortLog el3 = new EffortLog(2, 3);
		logs.add(el1);
		logs.add(el2);
		logs.add(el3);
		ppAverageText.setText("" + calculateAverage(logs));
	}
	
	//EDGE CASE
	public void avg2() {
		logs.clear();
		EffortLog el1 = new EffortLog(5, 4);
		logs.add(el1);
		ppAverageText.setText("" + calculateAverage(logs));
	}
	
	//ERROR CASE
	public void avg3() {
		logs.clear();
		ppAverageText.setText("" + calculateAverage(logs));
	}
	
	//CALCULATION METHOD
	public int calculateAverage(List<EffortLog> calcLogs) {
		if (calcLogs.size() == 0) {
			ppErrorText.setText("ERROR: No logs given to calculate");
			return 0;
		} else {
			int effortSum = 0;
			int weightSum = 0;
			for (int i = 0; i < calcLogs.size(); i++) {
				effortSum += (calcLogs.get(i).getWeight() * calcLogs.get(i).getEffortValue());
				weightSum += calcLogs.get(i).getWeight();
			}
			double average = (double) effortSum / (double) weightSum;
			System.out.println(average);
			if (average%1 >= 0.5) {
				return (int) (average + 1);
			} else {
				return (int) average;
			}
		}
	}
}
