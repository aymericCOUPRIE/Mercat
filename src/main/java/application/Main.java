package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import router.Router;

public class Main extends Application {

    public static Stage primaryStage = null;

    @Override
    public void start(Stage primaryStage) {
        Main.primaryStage = primaryStage;

        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/LoginUI.fxml"));
            Parent skillLayout = root.load();
            Scene scene = new Scene(skillLayout, 1000, 800);

            primaryStage.setTitle("Mercat");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void init() {
        Router r = Router.getInstance();
        r.add("HomePage", "/HomePageUI.fxml");
        r.add("Login", "/LoginUI.fxml");
        r.add("SignUpC", "/SignUpUIConsumer.fxml");
        r.add("SignUpS", "/SignUpUISeller.fxml");
        r.add("HandleConsumer", "/UpdateConsumerProfileUI.fxml");
        r.add("HandleConsumerS", "/HandleConsumersUI.fxml");
        r.add("HandleSeller", "/UpdateSellerProfileUI.fxml");
        r.add("ProfileSeller", "/SellerProfileUI.fxml");
        r.add("HandleSellerS", "/HandleSellersUI.fxml");
        r.add("AddProduct", "/AddProduct.fxml");
        r.add("ModifyProduct", "/ModifyProduct.fxml");
        r.add("ProductUI", "/ProductUI.fxml");
        r.add("Basket","/BasketUI.fxml");
        r.add("HistoricOrder", "/ConsultHistoricOrderUI.fxml");
        r.add("Rate_Seller", "/Rate_Seller.fxml");
        r.add("Rate_Product", "/Rate_Product.fxml");
    }

}
