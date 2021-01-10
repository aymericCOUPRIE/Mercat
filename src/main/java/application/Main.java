package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import router.Router;

import java.io.IOException;

/**
 * Main class, class that launch the application
 */
public class Main extends Application {

    public static Stage primaryStage = null;

    /**
     * Method that creates the window for the graphical interfaces
     *
     * @param primaryStage scene for the graphic interfaces
     */
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

    /**
     * MAIN, it calls the creation of the window
     *
     * @param args eventual parameters added when launching the app
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * List of all the paths between interfaces
     */
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
        r.add("Basket", "/BasketUI.fxml");
        r.add("HistoricOrder", "/ConsultHistoricOrderUI.fxml");
        r.add("Rate_Seller", "/Rate_Seller.fxml");
        r.add("Rate_Product", "/Rate_Product.fxml");
        r.add("Comment_Product", "/Comment_Product.fxml");
        r.add("DetailsProduct", "/DetailProduct.fxml");
        r.add("UpdateCategories", "/CategoryUI.fxml");
        r.add("SellerProducts", "/SellerProducts.fxml");
    }

}
