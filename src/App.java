import java.io.IOException;

import controller.PaymentController;
import entity.invoice.Invoice;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import utils.Configs;
//import views.screen.home.HomeScreenHandler;
import views.screen.BaseScreenHandler;
import views.screen.home.HomeScreenByHoan;
import views.screen.home.HomeScreenHandler;
import views.screen.invoice.InvoiceScreenHandler;
import views.screen.payment.PaymentScreenHandler;
import views.screen.returnbike.ChooseBikeParkScreenHandler;

public class App extends Application {

	public static void main(String[] args) {
	launch(args);

	}
	
	@FXML
	ImageView logo;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {

			// initialize the scene
			StackPane root = (StackPane) FXMLLoader.load(getClass().getResource(Configs.SPLASH_SCREEN_PATH));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();

			// Load splash screen with fade in effect
			FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), root);
			fadeIn.setFromValue(0);
			fadeIn.setToValue(1);
			fadeIn.setCycleCount(1);

			// Finish splash with fade out effect
			FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), root);
			fadeOut.setFromValue(1);
			fadeOut.setToValue(0);
			fadeOut.setCycleCount(1);

			// After fade in, start fade out
			fadeIn.play();
			fadeIn.setOnFinished((e) -> {
				fadeOut.play();
			});

			// After fade out, load actual content
			fadeOut.setOnFinished((e) -> {
				try {
					//display home
			//		HomeScreenHandler homeHandler = new HomeScreenHandler(primaryStage, Configs.HOME_PATH);
					HomeScreenByHoan homeHandler = new HomeScreenByHoan(primaryStage, "/views/fxml/homeByHoan.fxml");
					homeHandler.setScreenTitle("Home Screen");

					homeHandler.show();
					


					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
