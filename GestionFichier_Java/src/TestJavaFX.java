
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

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
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class TestJavaFX extends Application {

	private Favoris listeFavoris = new Favoris();
	private Set<KeyCode> pressedKeys = new HashSet<>();
	
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
		int fichiersParLigne1 = 50;
		int modulo = 5;
		HBox currentHBox = new HBox();
		currentHBox.setAlignment(Pos.CENTER);
		currentHBox.getStyleClass().add("cloud");
		VBox vbox = new VBox();
		for (Fichier f : listeFichiers) {
			if (compteur%modulo == 0) {
				vbox.getChildren().add(currentHBox);
				currentHBox = new HBox();
				currentHBox.setAlignment(Pos.CENTER);
				currentHBox.getStyleClass().add("cloud");
				if (compteur == fichiersParLigne1) {
					ScrollPane sc = new ScrollPane();
					sc.setContent(vbox);
					mainVBox.getChildren().add(sc);
					vbox = new VBox();
					compteur = 0;
				}
			}
			
			Button currentButton = new Button(f.nomF);
			currentButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					f.note++;
					try {
						Desktop.getDesktop().open(new File(f.path));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					listeFichiers.remove(f);
					listeFichiers.add(f);
					mainVBox.getChildren().clear();
					drawButton(listeFichiers, mainVBox);

				}
			});
			
		
			
			currentButton.setOnMouseClicked(e -> {
				if (e.getButton() == MouseButton.SECONDARY && this.pressedKeys.contains(KeyCode.DELETE)) {
					File file = new File(f.path);
					if (file.delete()) {
						listeFichiers.remove(f);
						mainVBox.getChildren().clear();
						drawButton(listeFichiers, mainVBox);
					}
					
					
				}
			});
			
			currentButton.setOnMouseClicked(e -> {
				if (e.getButton() == MouseButton.PRIMARY && this.pressedKeys.contains(KeyCode.SHIFT)) {
					String s = f.path.substring(0,f.path.length()-f.nomF.length());;
					System.out.println(s);
					try {
						Desktop.getDesktop().open(new File(s));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			Image currentImage = new Image("D:\\NUIT DE LINFO\\IMG\\"+f.type+".png");
			ImageView view = new ImageView(currentImage);
			double taille = 32;
			view.setFitWidth(taille);
			view.setFitHeight(taille);
			VBox buttonBox = new VBox();
			buttonBox.setAlignment(Pos.CENTER);
			
			Button buttonFav = new Button();
			buttonFav.setPrefWidth(20);
			if (f.isFav) {
				buttonFav.getStyleClass().add("hearthFull");				
			} else {
				buttonFav.getStyleClass().add("hearthEmpty");
			}
			
			buttonFav.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					f.isFav = !f.isFav;
					buttonFav.getStyleClass().clear();
					if (f.isFav)
					{
						buttonFav.getStyleClass().add("hearthFull");						
						listeFavoris.setFav.add(f.hashCode());
					} else {
						buttonFav.getStyleClass().add("hearthEmpty");
						listeFavoris.setFav.remove(f.hashCode());
					}

				}
			});
			
			buttonBox.getChildren().addAll(view,currentButton,buttonFav);
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

			Scene scene = new Scene(mainVBox,1500,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene.setOnKeyPressed(e -> this.pressedKeys.add(e.getCode()));
			scene.setOnKeyReleased(e -> this.pressedKeys.remove(e.getCode()));
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
