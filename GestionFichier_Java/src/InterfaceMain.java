import java.io.IOException;
import java.util.PriorityQueue;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class InterfaceMain extends Application {
	
	private PriorityQueue<Fichier> getFiles() {
		try {
			LoadFichier loader = new LoadFichier("D:\\NUIT DE LINFO");
			return loader.listFichier;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void drawButton(PriorityQueue<Fichier> listeFichiers, VBox mainVBox) {
		
		int compteur = 0;
		int fichiersParLigne = 10;
		HBox currentHBox = new HBox();
		currentHBox.setAlignment(Pos.CENTER);
		currentHBox.getStyleClass().add("cloud");
		VBox vbox = new VBox();
		for (Fichier f : listeFichiers) {
			if (compteur == fichiersParLigne) {
				mainVBox.getChildren().add(currentHBox);
				currentHBox = new HBox();
				currentHBox.setAlignment(Pos.CENTER);
				currentHBox.getStyleClass().add("cloud");
				compteur = 0;
				fichiersParLigne = (int) (fichiersParLigne*1.5);
			}
			
			Button currentButton = new Button("Bouton "+f.nomF);
			currentButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					f.note++;
					listeFichiers.remove(f);
					listeFichiers.add(f);
					mainVBox.getChildren().clear();
					drawButton(listeFichiers, mainVBox);

				}
			});
			Image currentImage = new Image("D:\\NUIT DE LINFO\\IMG\\"+f.type+".png");
			ImageView view = new ImageView(currentImage);
			double taille = 32;
			view.setFitWidth(taille);
			view.setFitHeight(taille);
			VBox buttonBox = new VBox();
			buttonBox.setAlignment(Pos.CENTER);
			buttonBox.getChildren().addAll(view,currentButton);
			
			currentHBox.getChildren().add(buttonBox);
			compteur++;
		}
		mainVBox.getChildren().add(currentHBox);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			VBox mainVBox = new VBox();
			PriorityQueue<Fichier> listeFichiers = getFiles();
			
			drawButton(listeFichiers, mainVBox);

			Scene scene = new Scene(mainVBox,1080,720);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
