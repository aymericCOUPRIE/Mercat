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

    /**
     * primaryStage corresponds to the window of the application
     */
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
            FXMLLoader root = new FXMLLoader(getClass().getResource("/userInterfaces/user/LoginUI.fxml"));
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
        r.add("HomePage", "/userInterfaces/HomePageUI.fxml");
        r.add("Login", "/userInterfaces/user/LoginUI.fxml");
        r.add("SignUpC", "/userInterfaces/user/SignUpUIConsumer.fxml");
        r.add("SignUpS", "/userInterfaces/user/SignUpUISeller.fxml");
        r.add("HandleConsumer", "/userInterfaces/user/UpdateConsumerProfileUI.fxml");
        r.add("HandleConsumerS", "/userInterfaces/user/HandleConsumersUI.fxml");
        r.add("HandleSeller", "/userInterfaces/user/UpdateSellerProfileUI.fxml");
        r.add("ProfileSeller", "/userInterfaces/user/SellerProfileUI.fxml");
        r.add("HandleSellerS", "/userInterfaces/user/HandleSellersUI.fxml");
        r.add("AddProduct", "/userInterfaces/product/AddProduct.fxml");
        r.add("ModifyProduct", "/userInterfaces/product/ModifyProduct.fxml");
        r.add("ProductUI", "/userInterfaces/product/ProductUI.fxml");
        r.add("Basket", "/userInterfaces/basket_order/BasketUI.fxml");
        r.add("HistoricOrder", "/userInterfaces/basket_order/ConsultHistoricOrderUI.fxml");
        r.add("Rate_Seller", "/userInterfaces/comment_rate/Rate_Seller.fxml");
        r.add("Rate_Product", "/userInterfaces/comment_rate/Rate_Product.fxml");
        r.add("Comment_Product", "/userInterfaces/comment_rate/Comment_Product.fxml");
        r.add("DetailsProduct", "/userInterfaces/product/DetailProduct.fxml");
        r.add("UpdateCategories", "/userInterfaces/product/CategoryUI.fxml");
        r.add("SellerProducts", "/userInterfaces/user/SellerProducts.fxml");
    }

}
