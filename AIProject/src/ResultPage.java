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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class ResultPage implements Initializable {

	@FXML
	private Button back;

	@FXML
	private Line JerusalemRamallahRoute;

	@FXML
	private Line BethlehemJerusalemRoute;

	@FXML
	private Line TubasJeninRoute;

	@FXML
	private Line NablusTubasRoute;

	@FXML
	private Line NablusSabastiaRoute;

	@FXML
	private Line SabastiaJeninRoute;

	@FXML
	private Line SalfitNablusRoute;

	@FXML
	private Line RamallahSalfitRoute;

	@FXML
	private Line SabastiaTulkarmRoute;

	@FXML
	private Line QalqilyaNablusRoute;

	@FXML
	private Line RamallahRamlehRoute;

	@FXML
	private Line JerichoRamallahRoute;

	@FXML
	private Line HebronBethlehemRoute;

	@FXML
	private Line DuraHebronRoute;

	@FXML
	private Line HaifaAkaRoute;

	@FXML
	private Line BethlehemJerichoRoute;

	@FXML
	private Line JeninNazarethRoute;

	@FXML
	private Line NazarethHaifaRoute;

	@FXML
	private Line JerusalemRamlehRoute;

	@FXML
	private Line RamlehYafaRoute;

	@FXML
	private Line HalhoulBethlehemRoute;

	@FXML
	private Line HebronHalhoulRoute;

	@FXML
	private Line YafaQalqilyaRoute;

	@FXML
	private Line RamallahNablusRoute;

	@FXML
	private Line JeninHaifaRoute;

	@FXML
	private Line SafadAkaRoute;

	@FXML
	private Line NazarethSafadRoute;

	@FXML
	private Line JerichoNablusRoute;

	@FXML
	private Label bethlehemLabel;

	@FXML
	private Circle bethlehemNode;

	@FXML
	private Label ramallahLabel;

	@FXML
	private Circle ramallahNode;

	@FXML
	private Label jeninLabel;

	@FXML
	private Circle jeninNode;

	@FXML
	private Label jerusalemLabel;

	@FXML
	private Circle jerusalemNode;

	@FXML
	private Label nablusLabel;

	@FXML
	private Circle nablusNode;

	@FXML
	private Label hebronLabel;

	@FXML
	private Circle hebronNode;

	@FXML
	private Label tulkarmLabel;

	@FXML
	private Circle tulkarmNode;

	@FXML
	private Label qalqilyaLabel;

	@FXML
	private Circle qalqilyaNode;

	@FXML
	private Label nazarethLabel;

	@FXML
	private Circle nazarethNode;

	@FXML
	private Label salfitLabel;

	@FXML
	private Circle salfitNode;

	@FXML
	private Label duraLabel;

	@FXML
	private Circle duraNode;

	@FXML
	private Label ramlehLabel;

	@FXML
	private Circle ramlehNode;

	@FXML
	private Label haifaLabel;

	@FXML
	private Circle haifaNode;

	@FXML
	private Label yafaLabel;

	@FXML
	private Circle yafaNode;

	@FXML
	private Label akaLabel;

	@FXML
	private Circle akaNode;

	@FXML
	private Label halhoulLabel;

	@FXML
	private Circle halhoulNode;

	@FXML
	private Label sabastiaLabel;

	@FXML
	private Circle sabastiaNode;

	@FXML
	private Label tubasLabel;

	@FXML
	private Circle tubasNode;

	@FXML
	private Label safadLabel;

	@FXML
	private Circle safadNode;

	@FXML
	private Label jerichoLabel;

	@FXML
	private Circle jerichoNode;

	@FXML
	private BarChart<String, Number> BarChart;

	@FXML
	private CategoryAxis CategoryAxis;

	@FXML
	private Label JerusalemRamallahCost;

	@FXML
	private Label BethlehemJerusalemCost;

	@FXML
	private Label TubasJeninCost;

	@FXML
	private Label NablusTubasCost;

	@FXML
	private Label NablusSabastiaCost;

	@FXML
	private Label SabastiaJeninCost;

	@FXML
	private Label SalfitNablusCost;

	@FXML
	private Label RamallahSalfitCost;

	@FXML
	private Label SabastiaTulkarmCost;

	@FXML
	private Label QalqilyaNablusCost;

	@FXML
	private Label RamallahRamlehCost;

	@FXML
	private Label JerichoRamallahCost;

	@FXML
	private Label HebronBethlehemCost;

	@FXML
	private Label DuraHebronCost;

	@FXML
	private Label HaifaAkaCost;

	@FXML
	private Label BethlehemJerichoCost;

	@FXML
	private Label JeninNazarethCost;

	@FXML
	private Label NazarethHaifaCost;

	@FXML
	private Label JerusalemRamlehCost;

	@FXML
	private Label RamlehYafaCost;

	@FXML
	private Label HalhoulBethlehemCost;

	@FXML
	private Label HebronHalhoulCost;

	@FXML
	private Label YafaQalqilyaCost;

	@FXML
	private Label RamallahNablusCost;

	@FXML
	private Label JeninHaifaCost;

	@FXML
	private Label SafadAkaCost;

	@FXML
	private Label NazarethSafadCost;

	@FXML
	private Label JerichoNablusCost;

	@FXML
	private Label algorithmLabel;

	@FXML
	private Label costLabel;

	@FXML
	private ListView<String> fringeListView;

	@FXML
	private ListView<String> visitedCitiesListView;

	@FXML
	private AnchorPane BFSInfo;

	@FXML
	private AnchorPane DFSInfo;

	@FXML
	private AnchorPane IDInfo;

	@FXML
	private AnchorPane GreedyInfo;

	@FXML
	private AnchorPane AStarInfo;

	@FXML
	private AnchorPane UCSInfo;

	@FXML
	private AnchorPane OptimalAllGoalsInfo;

	@FXML
	void back(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("View1.fxml"));
		Scene scene = new Scene(root, 900, 600);
		Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
		st.setScene(scene);
		st.show();
	}

	ObservableList<String> fringeList = FXCollections.observableArrayList();
	ObservableList<String> visitedList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ArrayList<Circle> Nodes = new ArrayList<Circle>();
		Line[][] lines = new Line[20][20];
		Label[][] labelRoutes = new Label[20][20];
		ArrayList<Label> LabelsList = new ArrayList<Label>();

		algorithmLabel.setText(HomePage.algorithmName);
		if (HomePage.algorithmName.equalsIgnoreCase("Breadth First Search")) 
			BFSInfo.setVisible(true);
		if (HomePage.algorithmName.equalsIgnoreCase("Depth First Search")) 
			DFSInfo.setVisible(true);
		if (HomePage.algorithmName.equalsIgnoreCase("Iterative Deepening")) 
			IDInfo.setVisible(true);
		if (HomePage.algorithmName.equalsIgnoreCase("Greedy Search")) 
			GreedyInfo.setVisible(true);
		if (HomePage.algorithmName.equalsIgnoreCase("A Star Search")) 
			AStarInfo.setVisible(true);
		if (HomePage.algorithmName.equalsIgnoreCase("Uniform Cost Search")) 
			UCSInfo.setVisible(true);
		if (HomePage.algorithmName.equalsIgnoreCase("Optimal for All Goals")) 
			OptimalAllGoalsInfo.setVisible(true);
		ObservableList<Label> labelList = FXCollections.observableArrayList(akaLabel, bethlehemLabel, duraLabel,
				haifaLabel, halhoulLabel, hebronLabel, jeninLabel, jerichoLabel, jerusalemLabel, nablusLabel,
				nazarethLabel, qalqilyaLabel, ramallahLabel, ramlehLabel, sabastiaLabel, safadLabel, salfitLabel,
				tubasLabel, tulkarmLabel, yafaLabel);
		LabelsList.addAll(labelList);
		for (Label L : LabelsList)
			L.setStyle(HomePage.LabelsList.get(LabelsList.indexOf(L)).getStyle() + "  -fx-opacity: 0.5;");

		ObservableList<Circle> NodesList = FXCollections.observableArrayList(akaNode, bethlehemNode, duraNode,
				haifaNode, halhoulNode, hebronNode, jeninNode, jerichoNode, jerusalemNode, nablusNode, nazarethNode,
				qalqilyaNode, ramallahNode, ramlehNode, sabastiaNode, safadNode, salfitNode, tubasNode, tulkarmNode,
				yafaNode);
		Nodes.addAll(NodesList);

		ObservableList<Line> linesList = FXCollections.observableArrayList(HaifaAkaRoute, SafadAkaRoute,
				HalhoulBethlehemRoute, HebronBethlehemRoute, BethlehemJerichoRoute, BethlehemJerusalemRoute,
				DuraHebronRoute, JeninHaifaRoute, NazarethHaifaRoute, HebronHalhoulRoute, JeninNazarethRoute,
				SabastiaJeninRoute, TubasJeninRoute, JerichoNablusRoute, JerichoRamallahRoute, JerusalemRamallahRoute,
				JerusalemRamlehRoute, QalqilyaNablusRoute, RamallahNablusRoute, NablusSabastiaRoute, SalfitNablusRoute,
				NablusTubasRoute, NazarethSafadRoute, YafaQalqilyaRoute, RamallahRamlehRoute, RamallahSalfitRoute,
				RamlehYafaRoute, SabastiaTulkarmRoute);

		ObservableList<Label> labelRoutesList = FXCollections.observableArrayList(HaifaAkaCost, SafadAkaCost,
				HalhoulBethlehemCost, HebronBethlehemCost, BethlehemJerichoCost, BethlehemJerusalemCost, DuraHebronCost,
				JeninHaifaCost, NazarethHaifaCost, HebronHalhoulCost, JeninNazarethCost, SabastiaJeninCost,
				TubasJeninCost, JerichoNablusCost, JerichoRamallahCost, JerusalemRamallahCost, JerusalemRamlehCost,
				QalqilyaNablusCost, RamallahNablusCost, NablusSabastiaCost, SalfitNablusCost, NablusTubasCost,
				NazarethSafadCost, YafaQalqilyaCost, RamallahRamlehCost, RamallahSalfitCost, RamlehYafaCost,
				SabastiaTulkarmCost);
		int index = 0;
		int[][] stroke = new int[20][20];
		for (int i = 0; i < Main.PathCost.length; i++)
			for (int j = 0; j < Main.PathCost[i].size(); j++) {
				if (Main.PathCost[i].get(j).id < i)
					continue;
				lines[Main.PathCost[i].get(j).id][i] = linesList.get(index);
				labelRoutesList.get(index).setText(Main.PathCost[i].get(j).driveRoute + "km");
				labelRoutes[Main.PathCost[i].get(j).id][i] = labelRoutesList.get(index);
				stroke[Main.PathCost[i].get(j).id][i] = 1;
				index++;
			}
		visitedList.add(Search.orderOfCityExpansionList.get(0).toString());
		for (int i = 1; i < Search.orderOfCityExpansionList.size(); i++) {
			visitedList.add(Search.orderOfCityExpansionList.get(i).toString());
			Nodes.get(Search.orderOfCityExpansionList.get(i).getId()).setStyle(
					Nodes.get(Search.orderOfCityExpansionList.get(i).getId()).getStyle() + " -fx-fill: #30a9de;");
			if (lines[Search.orderOfCityExpansionList.get(i).getId()][Search.orderOfCityExpansionList.get(i).getNextTo()
					.getId()] != null)
				lines[Search.orderOfCityExpansionList.get(i).getId()][Search.orderOfCityExpansionList.get(i).getNextTo()
						.getId()].setStyle("-fx-stroke: #30a9de;");
			else
				lines[Search.orderOfCityExpansionList.get(i).getNextTo().getId()][Search.orderOfCityExpansionList.get(i)
						.getId()].setStyle("-fx-stroke: #30a9de;");
		}
		visitedCitiesListView.setItems(visitedList);
		costLabel.setText("Cost Of Path Found: " + HomePage.Path.get(HomePage.Path.size() - 1).getCost() + "km");
		fringeList.add(HomePage.Path.get(0).toString());
		Nodes.get(HomePage.Path.get(0).getId())
				.setStyle("-fx-fill: red; -fx-effect:dropshadow(gaussian , white, 5,0.8, 0.3, 0.0) ; -fx-opacity: 1;");
		LabelsList.get(HomePage.Path.get(0).getId())
				.setStyle(HomePage.LabelsList.get(HomePage.Path.get(0).getId()).getStyle() + "  -fx-opacity: 1;");
		for (int i = 1; i < HomePage.Path.size(); i++) {
			fringeList.add(HomePage.Path.get(i).toString());
			LabelsList.get(HomePage.Path.get(i).getId())
					.setStyle(HomePage.LabelsList.get(HomePage.Path.get(i).getId()).getStyle() + "  -fx-opacity: 1;");
			Nodes.get(HomePage.Path.get(i).getId()).setStyle("-fx-fill: #df5e88; -fx-opacity: 1;");
			if (HomePage.goalCityIds.contains(HomePage.Path.get(i).getId()))
				Nodes.get(HomePage.Path.get(i).getId())
						.setStyle("-fx-fill: #30a9de; -fx-effect:dropshadow(gaussian , white, 5,0.8, 0.3, 0.0) ;");

			if (lines[HomePage.Path.get(i).getId()][HomePage.Path.get(i).getNextTo().getId()] != null) {
				lines[HomePage.Path.get(i).getId()][HomePage.Path.get(i).getNextTo().getId()]
						.setStyle("-fx-stroke:#df5e88; -fx-stroke-width: "
								+ stroke[HomePage.Path.get(i).getId()][HomePage.Path.get(i).getNextTo().getId()]
								+ "; -fx-opacity: 1;");
				stroke[HomePage.Path.get(i).getId()][HomePage.Path.get(i).getNextTo().getId()] += 1;
				labelRoutes[HomePage.Path.get(i).getId()][HomePage.Path.get(i).getNextTo().getId()].setStyle(
						"-fx-text-fill:#df5e88; -fx-effect:dropshadow(gaussian , white, 5,0.8, 0.3, 0.0) ; -fx-opacity: 1;");
			} else {
				lines[HomePage.Path.get(i).getNextTo().getId()][HomePage.Path.get(i).getId()]
						.setStyle("-fx-stroke:#df5e88; -fx-stroke-width: "
								+ stroke[HomePage.Path.get(i).getNextTo().getId()][HomePage.Path.get(i).getId()]
								+ "; -fx-opacity: 1;");
				stroke[HomePage.Path.get(i).getNextTo().getId()][HomePage.Path.get(i).getId()] += 1;
				labelRoutes[HomePage.Path.get(i).getNextTo().getId()][HomePage.Path.get(i).getId()].setStyle(
						"-fx-text-fill:#df5e88; -fx-effect:dropshadow(gaussian , white, 5,0.8, 0.3, 0.0) ; -fx-opacity: 1;");
			}
		}
		fringeListView.setItems(fringeList);
		ObservableList<String> cityNames = FXCollections.observableArrayList();
		Series<String, Number> series = new Series<String, Number>();
		for (int i = 0; i < 20; i++) {
			cityNames.add(City.getCityName(i));
			CategoryAxis.getCategories().setAll(cityNames);
			series.getData().add(new Data<>(City.getCityName(i), Search.minHeurestic(i, HomePage.goalCityIds)));
		}
		BarChart.getData().add(series);
	}
}
