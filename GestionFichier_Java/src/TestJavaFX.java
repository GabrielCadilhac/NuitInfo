
import java.io.IOException;
import java.util.PriorityQueue;

import javax.swing.JLabel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class TestJavaFX extends Application {

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
		int fichiersParLigne = 2;
		HBox currentHBox = new HBox();
		
		for (Fichier f : listeFichiers) {
			System.out.println(f.nomF+" "+f.note);
			if (compteur == fichiersParLigne) {
				mainVBox.getChildren().add(currentHBox);
				currentHBox = new HBox();
			}
			Button currentButton = new Button("Bouton "+f.nomF);

			currentButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					f.note++;
					listeFichiers.remove(f);
					System.out.println(listeFichiers);
					listeFichiers.add(f);
					System.out.println(listeFichiers);
					mainVBox.getChildren().clear();
					
					drawButton(listeFichiers, mainVBox);

				}
			});
			
			currentHBox.getChildren().add(currentButton);/////////////////////////////
			compteur++;
		}
		mainVBox.getChildren().add(currentHBox);
		System.out.println("######################");
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			VBox mainVBox = new VBox();
			PriorityQueue<Fichier> listeFichiers = getFiles();

			drawButton(listeFichiers, mainVBox);

			Scene scene = new Scene(mainVBox,400,400);
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
