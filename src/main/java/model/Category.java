package model;

import java.util.*;

/**
 * 
 */
public class Category {

    private int idCategorie;
    private String nameCategory;

    /**
     * Default constructor
     */
    public Category(int idCategorie, String nameCategory) {
        this.idCategorie = idCategorie;
        this.nameCategory = nameCategory;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}