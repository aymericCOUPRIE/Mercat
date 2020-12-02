package router;

import application.Main;
import javafx.fxml.FXMLLoader;

import java.util.*;

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
     * ajouter un racourci nom pour un chemin
     * @param name, path
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





}