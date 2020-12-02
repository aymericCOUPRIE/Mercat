package router;

import application.Main;
import javafx.fxml.FXMLLoader;

import java.util.*;

/**
 * 
 */
public class Router {


    /**
     * 
     */
    public static Router instanceRouteur;

    /**
     * 
     */
    public Object[] params;

    /**
     * 
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
     * @param name, path
     */
    public void add(String name, String path) {

        screenMap.put(name, path);
    }

    /**
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