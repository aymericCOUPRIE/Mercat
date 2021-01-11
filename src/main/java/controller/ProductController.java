package controller;

import facade.CategoryFacade;
import facade.ProductFacade;
import facade.UserFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Category;
import model.Product;
import router.Router;

import java.util.ArrayList;

/**
 * Class ProductController
 */
public class ProductController {

    @FXML
    private ChoiceBox txtCategory;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtPrice2;
    @FXML
    private TextField txtNameProduct;
    @FXML
    private Label errorText;

    //Partie recherche
    //Bouton

    //TextField Product
    @FXML
    private TextField txtProduct1;
    @FXML
    private TextField txtProduct2;
    @FXML
    private TextField txtProduct3;
    @FXML
    private TextField txtProduct4;
    //TextField City
    @FXML
    private TextField txtCity1;
    @FXML
    private TextField txtCity2;
    //TextField Category
    @FXML
    private TextField txtCategory1;
    @FXML
    private TextField txtCategory2;


    private String categoryName;
    private String priceEuros;
    private String priceCents;
    private String description;
    private String productName;
    private String city;

    private final ProductFacade productFacade = ProductFacade.getInstance();
    private final CategoryFacade categoryFacade = CategoryFacade.getInstance();
    private final UserFacade userFacade = UserFacade.getInstanceUserFacade();

    private Product productToModify;


    /**
     * Default constructor
     */
    public ProductController() {
    }

    /**
     * This method is called when the seller tries to add a new Product,
     * when he clicks on btnProduct
     */
    public void addProduct() {
        Object category = txtCategory.getValue();

        System.out.println("category :" + categoryName);
        productName = txtNameProduct.getText();
        description = txtDescription.getText();

        priceEuros = txtPrice.getText();
        priceCents = txtPrice2.getText();


        if (productName.equals("") || description.equals("") || priceEuros.equals("") || category == null) {
            display("You need to fill every field");
        } else {
            try {
                int i = Integer.parseInt(priceEuros);
                try {
                    int c = Integer.parseInt(priceCents);
                    categoryName = txtCategory.getValue().toString();
                    String price = i + "." + c;
                    Float f = Float.parseFloat(price);
                    String seller = userFacade.getConnectedUser().getPseudo();
                    Product p = new Product(productName, description, f, seller, categoryName);
                    System.out.println(p.getDescription());
                    if (productFacade.createProduct(p)) {
                        display("Produit ajouté");
                    }
                } catch (NumberFormatException n) {
                    display("The cent field must be an integer");
                }
            } catch (NumberFormatException n) {
                display("The price is not an integer");
            }

            //productFacade.createProduct(productName,description,price,);
        }
    }

    /**
     * This method is called by btnPtoduct in ModifyProduct.fxml
     *It updates the products with his new values in the fields
     *
     */
    public void updateProduct() {
        Object category = txtCategory.getValue();

        System.out.println("category :" + categoryName);
        productName = txtNameProduct.getText();
        description = txtDescription.getText();

        priceEuros = txtPrice.getText();
        priceCents = txtPrice2.getText();


        if (productName.equals("") || description.equals("") || priceEuros.equals("") || category == null) {
            display("You need to fill every field");
        } else {
            try {
                int i = Integer.parseInt(priceEuros);
                try {
                    categoryName = txtCategory.getValue().toString();
                    int c = Integer.parseInt(priceCents);
                    String price = i + "." + c;
                    Float f = Float.parseFloat(price);
                    String seller = userFacade.getConnectedUser().getPseudo();
                    Product p = new Product(productToModify.getIdProduct(), productName, description, f, "", seller, productToModify.getCity(), productFacade.getCategoryId(categoryName), categoryName);
                    System.out.println(p.getDescription());
                    if (productFacade.updateProduct(p)) {
                        display("Produit modifié");
                    }
                } catch (NumberFormatException n) {
                    display("The cent field must be an integer");
                }
            } catch (NumberFormatException n) {
                display("The price is not an integer");
            }

            //productFacade.createProduct(productName,description,price,);
        }
    }


    /**
     * Displays an error message
     *
     * @param msg the message we want to display on the page
     */
    @FXML
    public void display(String msg) {
        errorText.setText(msg);
    }

    /**
     * Thanks to this method you don't have an error message at the beginning
     * If needed define every text field with data of the product we want the details
     */
    public void initialize() {
        // TODO Auto-generated method stub
        errorText.setText("");
        ArrayList<String> listNomCategory = new ArrayList<String>();
        for (Category c : categoryFacade.getAllCategory()) {
            listNomCategory.add(c.getNameCategory());
        }
        ObservableList observableList = FXCollections.observableArrayList(listNomCategory);
        txtCategory.setItems(observableList);
        if (Router.getInstance().getParametre() != null) {//Si on vient de la page avec tous les produits du vendeurs
            Product product = Router.getInstance().getParametre().get(0);
            this.productToModify = product;
            txtNameProduct.setText(product.getNameProduct());
            txtDescription.setText(product.getDescription());
            String prix = "" + product.getPriceProduct();
            int i = prix.indexOf(".");
            txtPrice.setText(prix.substring(0, i));
            txtPrice2.setText(prix.substring(i + 1));
        }
    }

    /**
     * This method enables you to research a product by his name
     *
     */
    public void getProductsByName() {
        productName = txtProduct1.getText();
        if (productName.equals("")) {
            display("You need to fill the field");
        } else {
            ArrayList<Product> p = productFacade.getProductsByName(productName);
            System.out.println("ProductByName productController");
            Router.getInstance().activate("ProductUI", p);
        }
    }

    /**
     * This method enables you to research a product by his name and the name of a city
     *
     */
    public void getProductsByNameAndCity() {
        productName = txtProduct2.getText();
        city = txtCity1.getText();
        if (productName.equals("") || city.equals("")) {
            display("You need to fill every field");
        } else {
            ArrayList<Product> p = productFacade.getProductsByNameAndCity(productName, city);
            Router.getInstance().activate("ProductUI", p);
        }
    }

    /**
     * This method enables you to research a product by his name and the category
     *
     */
    public void getProductsByNameAndCategory() {
        productName = txtProduct3.getText();
        categoryName = txtCategory1.getText();
        if (productName.equals("") || categoryName.equals("")) {
            display("You need to fill every field");
        } else {
            ArrayList<Product> p = productFacade.getProductsByNameAndCategory(productName, categoryName);
            Router.getInstance().activate("ProductUI", p);
        }
    }

    /**
     * This method enables you to research a product by name, category and city
     *
     */
    public void getProductsByNameAndCityAndCategory() {
        productName = txtProduct4.getText();
        categoryName = txtCategory2.getText();
        city = txtCity2.getText();
        if (productName.equals("") || city.equals("") || categoryName.equals("")) {
            display("You need to fill every field");
        } else {
            ArrayList<Product> p = productFacade.getProductByNameAndCityAndCategory(productName, city, categoryName);
            Router.getInstance().activate("ProductUI", p);
        }
    }


    /**
     * This method enables you to go to the homePage
     *
     */
    @FXML
    public void goHome() {
        Router.getInstance().activate("HomePage");
    }

    /**
     * This method is called when the button called sellerPage is clicked
     * When called this method shows the Seller profile page
     *
     */
    public void goToSellerPage() {
        ArrayList<Product> p = new ArrayList<Product>();
        p.add(this.productToModify);
        Router.getInstance().activate("SellerProfileUI", p);
    }


}