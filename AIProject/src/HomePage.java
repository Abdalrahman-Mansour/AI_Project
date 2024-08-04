import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomePage implements Initializable {

	@FXML
	private ToggleButton startCities;

	@FXML
	private ToggleGroup startOrGoals;

	@FXML
	private ToggleButton GoalCities;

	@FXML
	private ComboBox<String> algorithmTypes;

	@FXML
	private ProgressBar progress;

	@FXML
	private Button search;

	@FXML
	private Label bethlehemLabel;

	@FXML
	private RadioButton bethlehemRadio;

	@FXML
	private Label ramallahLabel;

	@FXML
	private RadioButton ramallahRadio;

	@FXML
	private Label jeninLabel;

	@FXML
	private RadioButton jeninRadio;

	@FXML
	private Label jerusalemLabel;

	@FXML
	private RadioButton jerusalemRadio;

	@FXML
	private Label nablusLabel;

	@FXML
	private RadioButton nablusRadio;

	@FXML
	private Label hebronLabel;

	@FXML
	private RadioButton hebronRadio;

	@FXML
	private Label tulkarmLabel;

	@FXML
	private RadioButton tulkarmRadio;

	@FXML
	private Label qalqilyaLabel;

	@FXML
	private RadioButton qalqilyaRadio;

	@FXML
	private Label nazarethLabel;

	@FXML
	private RadioButton nazarethRadio;

	@FXML
	private Label salfitLabel;

	@FXML
	private RadioButton salfitRadio;

	@FXML
	private Label duraLabel;

	@FXML
	private RadioButton duraRadio;

	@FXML
	private Label ramlehLabel;

	@FXML
	private RadioButton ramlehRadio;

	@FXML
	private Label haifaLabel;

	@FXML
	private RadioButton haifaRadio;

	@FXML
	private Label yafaLabel;

	@FXML
	private RadioButton yafaRadio;

	@FXML
	private Label akaLabel;

	@FXML
	private RadioButton akaRadio;

	@FXML
	private Label halhoulLabel;

	@FXML
	private RadioButton halhoulRadio;

	@FXML
	private Label sabastiaLabel;

	@FXML
	private RadioButton sabastiaRadio;

	@FXML
	private Label tubasLabel;

	@FXML
	private RadioButton tubasRadio;

	@FXML
	private Label safadLabel;

	@FXML
	private RadioButton safadRadio;

	@FXML
	private Label jerichoLabel;

	@FXML
	private RadioButton jerichoRadio;

	@FXML
	private Button save;

	@FXML
	private Button clear;

	static ArrayList<RadioButton> RadioButtonsList = new ArrayList<RadioButton>();
	static ArrayList<Label> LabelsList = new ArrayList<Label>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		RadioButtonsList.clear();
		LabelsList.clear();
		save.setVisible(false);
		ObservableList<String> algorithmsList = FXCollections.observableArrayList("Breadth First Search",
				"Depth First Search", "Iterative Deepening", "Greedy Search", "A Star Search", "Uniform Cost Search",
				"Optimal for All Goals");
		algorithmTypes.setItems(algorithmsList);
		ObservableList<RadioButton> radioList = FXCollections.observableArrayList(akaRadio, bethlehemRadio, duraRadio,
				haifaRadio, halhoulRadio, hebronRadio, jeninRadio, jerichoRadio, jerusalemRadio, nablusRadio,
				nazarethRadio, qalqilyaRadio, ramallahRadio, ramlehRadio, sabastiaRadio, safadRadio, salfitRadio,
				tubasRadio, tulkarmRadio, yafaRadio);
		RadioButtonsList.addAll(radioList);
		ObservableList<Label> labelList = FXCollections.observableArrayList(akaLabel, bethlehemLabel, duraLabel,
				haifaLabel, halhoulLabel, hebronLabel, jeninLabel, jerichoLabel, jerusalemLabel, nablusLabel,
				nazarethLabel, qalqilyaLabel, ramallahLabel, ramlehLabel, sabastiaLabel, safadLabel, salfitLabel,
				tubasLabel, tulkarmLabel, yafaLabel);
		RadioButtonsList.addAll(radioList);
		LabelsList.addAll(labelList);
	}

	@FXML
	void save(ActionEvent event) {
		if (startCities.isSelected())
			for (RadioButton r : RadioButtonsList) {
				if (r.isSelected()) {
					LabelsList.get(RadioButtonsList.indexOf(r))
							.setStyle("-fx-text-fill:red; -fx-effect:dropshadow(gaussian , white, 5,0.8, 0.3, 0.0) ;");
				}
				r.setSelected(false);
			}

		if (GoalCities.isSelected())
			for (RadioButton r : RadioButtonsList) {
				if (r.isSelected()) {
					LabelsList.get(RadioButtonsList.indexOf(r)).setStyle(
							"-fx-text-fill: #30A9DE; -fx-effect:dropshadow(gaussian , white, 5,0.8, 0.3, 0.0) ;");
				}
				r.setSelected(false);
			}
		progress(event);
	}

	@FXML
	void change(ActionEvent event) {
		for (RadioButton r : RadioButtonsList)
			r.setSelected(false);
		save.setVisible(false);
	}

	@FXML
	void selectRadio(ActionEvent event) {
		for (RadioButton r : RadioButtonsList)
			if (r.isSelected()) {
				save.setVisible(true);
				return;
			}
		save.setVisible(false);
	}

	Boolean StartSelected = false;
	Boolean GoalSelected = false;
	Boolean algSelected = false;

	@FXML
	void progress(ActionEvent event) {
		if (StartSelected)
			progress.setProgress(progress.getProgress() - (1 / 3.0));
		StartSelected = false;
		if (GoalSelected)
			progress.setProgress(progress.getProgress() - (1 / 3.0));
		GoalSelected = false;

		for (Label L : LabelsList) {
			if (L.getStyle().startsWith("-fx-text-fill:red;")) {
				if (!StartSelected)
					progress.setProgress(progress.getProgress() + (1 / 3.0));
				StartSelected = true;
			}
			if (L.getStyle().startsWith("-fx-text-fill: #30A9DE;")) {
				if (!GoalSelected)
					progress.setProgress(progress.getProgress() + (1 / 3.0));
				GoalSelected = true;
			}
		}

		if (!algSelected & !algorithmTypes.getSelectionModel().isEmpty()) {
			progress.setProgress(progress.getProgress() + (1 / 3.0));
			algSelected = true;
		}
		if (progress.getProgress() == 1.0) {
			progress.setVisible(false);
			search.setVisible(true);
		} else {
			progress.setVisible(true);
			search.setVisible(false);
		}
		save.setVisible(false);
	}

	@FXML
	void clear(ActionEvent event) {
		StartSelected = false;
		GoalSelected = false;
		algSelected = false;
		for (RadioButton R : RadioButtonsList) {
			R.setSelected(false);
			LabelsList.get(RadioButtonsList.indexOf(R)).setStyle(
					"-fx-text-fill: white; -fx-effect:dropshadow(gaussian , rgba(33, 131, 128, 1), 5,0.8, 0.3, 0.0) ;");
		}
		progress.setProgress(0);
		algorithmTypes.setValue(null);
		save.setVisible(false);
	}

	public static int startCityId;
	public static ArrayList<Integer> goalCityIds = new ArrayList<Integer>();
	static ArrayList<City> Path = new ArrayList<City>();
	static String algorithmName = null;

	@FXML
	void search(ActionEvent event) throws IOException {
		Path.clear();
		goalCityIds.clear();
		for (Label L : LabelsList)
			if (L.getStyle().startsWith("-fx-text-fill:red;")) {
				startCityId = LabelsList.indexOf(L);
				break;
			}
		for (Label L : LabelsList)
			if (L.getStyle().startsWith("-fx-text-fill: #30A9DE;"))
				goalCityIds.add(LabelsList.indexOf(L));
		if (algorithmTypes.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Breadth First Search")) {
			Path = Search.BFS(startCityId, goalCityIds);
			algorithmName = "Breadth First Search";
		}
		if (algorithmTypes.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Depth First Search")) {
			Path = Search.DFS(startCityId, goalCityIds);
			algorithmName = "Depth First Search";
		}
		if (algorithmTypes.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Iterative Deepening")) {
			Path = Search.IterativeDeepening(startCityId, goalCityIds);
			algorithmName = "Iterative Deepening";
		}
		if (algorithmTypes.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Greedy Search")) {
			Path = Search.Greedy(startCityId, goalCityIds);
			algorithmName = "Greedy Search";
		}
		if (algorithmTypes.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("A Star Search")) {
			Path = Search.AStar(startCityId, goalCityIds);
			algorithmName = "A Star Search";
		}
		if (algorithmTypes.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Uniform Cost Search")) {
			Path = Search.uniformCost(startCityId, goalCityIds);
			algorithmName = "Uniform Cost Search";
		}
		if (algorithmTypes.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Optimal for All Goals")) {
			Path = Search.Optimal1AllGoals(startCityId, goalCityIds);
			algorithmName = "Optimal for All Goals";
		}

		Parent root = FXMLLoader.load(getClass().getResource("View2.fxml"));
		Scene scene = new Scene(root, 1280, 700);
		Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
		st.setScene(scene);
		st.show();
	}

	@FXML
	void pressLabel(MouseEvent event) {
		for (Label L : LabelsList)
			if (L.isPressed()) {
				if (RadioButtonsList.get(LabelsList.indexOf(L)).isSelected())
					RadioButtonsList.get(LabelsList.indexOf(L)).setSelected(false);
				else
					RadioButtonsList.get(LabelsList.indexOf(L)).setSelected(true);
			}
		selectRadio(new ActionEvent());
	}
}