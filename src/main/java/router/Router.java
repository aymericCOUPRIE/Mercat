package router;

import application.Main;
import facade.CategoryFacade;
import javafx.fxml.FXMLLoader;
import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class Router {


    /**
     * singleton
     */
    public static Router instanceRouteur;

    /**
     * si on veut passer des paramètres en changent de page
     */
    public Object[] params;
    public int paramProduct;

    private static ArrayList<Product> parametre;
    private static ArrayList<Category> parametreC = CategoryFacade.getInstance().getAllCategory();

    /**
     * associer un nom à des chemins
     */
    private HashMap<String, String> screenMap = new HashMap<>();


    /**
     * Default constructor
     * Respect the Singleton pattern
     */
    private Router() {
    }


    /**
     * This methof is used to access the list of all the paths
     *
     * @return a HashMap containing the name of the path and the Inteface corresponding to the path
     */
    public HashMap<String, String> getScreenMap() {
        return screenMap;
    }

    /**
     * @return Router INSTANCE qui est un singleton
     */
    public static Router getInstance() {
        if (instanceRouteur == null) {
            instanceRouteur = new Router();
        }
        return instanceRouteur;
    }

    /**
     * This method is used to get the parameters given when changing interfaces
     *
     * @return Object[]  the params of the new loaded view
     */
    public Object[] getParams() {
        return this.params;
    }

    /**
     * ajouter un racourci nom pour un chemin
     *
     * @param name name of the path
     * @param path name of the Interface
     */
    public void add(String name, String path) {

        screenMap.put(name, path);
    }

    /**
     * se rentre sur la page dont le nom est passé en paramètres
     *
     * @param name name of the path
     */
    public void activate(String name) {
        this.params = new String[0];
        try {
            Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource(instanceRouteur.getScreenMap().get(name))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * se rentre sur la page dont le nom est passé en paramètres
     *
     * @param name name of the path
     * @param a    parameter given from the old controller to the new one
     */
    public void activate(String name, int a) {
        this.paramProduct = a;
        try {
            Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource(instanceRouteur.getScreenMap().get(name))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * changer de page en prenant des paramètres avec nous (une instance de user par exemple)
     *
     * @param name   name of the path
     * @param params parameter given from the old controller to the new one
     */
    public void activate(String name, Object[] params) {
        this.params = params;
        try {
            Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource(instanceRouteur.getScreenMap().get(name))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * changer de page en prenant des paramètres avec nous (une instance de user par exemple)
     *
     * @param name name of the path
     * @param p    Changer de page avec une ArrayList de Product
     */
    public void activate(String name, ArrayList<Product> p) {
        this.parametre = p;
        try {
            Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource(instanceRouteur.getScreenMap().get(name))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to get parameters from another controller
     *
     * @return a list of products
     */
    public ArrayList<Product> getParametre() {
        return parametre;
    }

    /**
     * This method is used to get parameters from another controller
     *
     * @return a list of categories
     */
    public static ArrayList<Category> getParametreC() {
        return parametreC;
    }
}