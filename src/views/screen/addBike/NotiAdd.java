package views.screen.addBike;

import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.detailpark.DetailParkScreenHandler;

public class NotiAdd {
	
//	public static Stage stagee;
	
	public static void Display(Stage stagee, String message,int parkId) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Thêm thành công");
		window.setWidth(400);
		window.setHeight(200);
		
		Button button = new Button("OK");
		button.setOnAction(e -> {
			DetailParkScreenHandler homeHandler;
			try {
				homeHandler = new DetailParkScreenHandler(stagee, Configs.DETAIL_PARK_PATH,parkId);
				homeHandler.setScreenTitle("Home Screen");
				homeHandler.show();
				window.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		button.setAlignment(Pos.BOTTOM_CENTER);
		
		
		VBox layout = new VBox(20);
		
		layout.getChildren().add(new javafx.scene.control.Label("Thêm thành công"));
		layout.getChildren().addAll(button);
		
		  
        // add label to vbox

	    
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		scene.disposePeer();
		window.setScene(scene);
		window.showAndWait();
		
	}
	
//	public void SetStage(Stage stage) {
//		this.stagee = stage;
//	}
	

}
