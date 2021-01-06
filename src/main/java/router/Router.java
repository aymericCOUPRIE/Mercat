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
    public  Object[] params;

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
    private Router() {}


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
     *
     * @return Object[]  the params of the new loaded view
     */
    public Object[] getParams() {
        return this.params;
    }

    /**
     * ajouter un racourci nom pour un chemin
     * @param name,path
     */
    public void add(String name, String path) {

        screenMap.put(name, path);
    }

    /**
     * se rentre sur la page dont le nom est passé en paramètres
     * @param name
     */
    public void activate(String name) {
        this.params = new String[0];
        try {
            Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource(instanceRouteur.getScreenMap().get(name))));
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * changer de page en prenant des paramètres avec nous (une instance de user par exemple)
     * @param name
     * @param params
     */
    public void activate(String name, Object[] params) {
        this.params = params;
        try {
            Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource(instanceRouteur.getScreenMap().get(name))));
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param name
     * @param p
     * Changer de page avec une ArrayList de Product
     */
    public void activate(String name, ArrayList<Product> p) {
        this.parametre = p;
        try {
            Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource(instanceRouteur.getScreenMap().get(name))));
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getParametre() {
        return parametre;
    }

    public static ArrayList<Category> getParametreC() {
        return parametreC;
    }
}