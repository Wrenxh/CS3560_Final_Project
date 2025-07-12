package FinalProject;

import java.sql.Date;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class lmsGUI extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		Student Elias = new Student("Elias", "1234 street", "CS");
		Student jeff = new Student("jeff", "4321 street", "Civil Engineering");
		Student todd = new Student("todd", "3241 street", "Sociology");
		Student Mads = new Student("mads", "3411 street", "Business");
		
		Staff stf = new Staff("Mary");
		
		Date pub = new Date(0); 
        Date start = new Date(System.currentTimeMillis());
        long e = System.currentTimeMillis()+ 100000000;
        Date end = new Date(e);
		
		Loan l1 = new Loan(start, end, "Elias");
		
		stf.addLoan2Stud(l1, Elias);
		
		ArrayList<String> studName = new ArrayList<>();
		studName.add(Elias.getName());
		studName.add(jeff.getName());
		studName.add(todd.getName());
		studName.add(Mads.getName());

		ArrayList<String> hasLoan = new ArrayList<>();
		hasLoan.add(Elias.hasLoan());
		hasLoan.add(jeff.hasLoan());
		hasLoan.add(todd.hasLoan());
		hasLoan.add(Mads.hasLoan());

		ObservableList<String> strList = FXCollections.observableArrayList(studName);

		ListView<String> listView = new ListView<>();
		listView.setPrefSize(500, 500);
		listView.getItems().setAll(strList);
		
		Label selectedNameLabel = new Label("Select a Name");
		
		Button getButton = new Button("Get the Selection");
		
		getButton.setOnAction((ActionEvent event) -> {
			int selectedIndex = listView.getSelectionModel().getSelectedIndex();
			if (selectedIndex >= 0) {
				String bio = hasLoan.get(selectedIndex);
				selectedNameLabel.setText(bio);
			} else {
				selectedNameLabel.setText("No student selected");
			}
		});
		
		VBox vbox = new VBox(10, listView, selectedNameLabel, getButton);
		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CPP Library Management System Loan Query");
		primaryStage.show();
	}
}
