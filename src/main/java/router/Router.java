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
    public static Router INSTANCE;

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



    /**
     * @param name
     */
    public void activate(String name) {
        this.params = new String[0];
        try {
            Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource(INSTANCE.getScreenMap().get(name))));
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
            Main.primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource(INSTANCE.getScreenMap().get(name))));
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }


    public HashMap<String, String> getScreenMap() {
        return screenMap;
    }

    /**
     * @return Router INSTANCE
     */
    public static Router getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Router();
        }
        return INSTANCE;
    }

    /**
     * @param name, path
     */
    public void add(String name, String path) {
        screenMap.put(name, path);
    }

}