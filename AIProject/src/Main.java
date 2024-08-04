import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	public static Stage s;
	public static Scene scene;

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("View1.fxml"));
			scene = new Scene(root, 900, 600);
			primaryStage.setScene(scene);
			primaryStage.setTitle("GPS"); // give the app. a title
			primaryStage.getIcons().add(new Image("Icon.png"));
			primaryStage.setResizable(false); // make the app. not resizable
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Node>[] PathCost = new ArrayList[20];
	@SuppressWarnings("unchecked")
	public static ArrayList<Integer>[] Heurestic = new ArrayList[20];

	public static void main(String[] args) throws IOException {
		BufferedReader input = null;
		File file = new File("src//AerialDistancesAndRoutes.txt");
		Pattern notnumber = Pattern.compile("[^0-9]");
		input = new BufferedReader(new FileReader(file));
		for (int i = 0; i < 20; i++) {
			String[] result = input.readLine().split("\\s");
			Heurestic[i] = new ArrayList<Integer>();
			PathCost[i] = new ArrayList<Node>();
			for (int j = 0; j < 20; j++) {
				if (notnumber.matcher(result[j]).find()) {
					String[] temp = result[j].split("-");
					PathCost[i].add(new Node(j, Integer.parseInt(temp[0])));
					Heurestic[i].add(Integer.parseInt(temp[1]));
				} else
					Heurestic[i].add(Integer.parseInt(result[j]));
			}
		}
		input.close();
		launch(args);
	}
}
