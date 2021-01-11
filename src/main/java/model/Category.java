package model;

/**
 * Class Category
 */
public class Category {

    private int idCategorie;
    private String nameCategory;

    /**
     * CONSTRUCTOR
     *
     * @param idCategorie  of the category
     * @param nameCategory of the category
     */
    public Category(int idCategorie, String nameCategory) {
        this.idCategorie = idCategorie;
        this.nameCategory = nameCategory;
    }

    /**
     * GETTER
     *
     * @return the id of the category
     */
    public int getIdCategorie() {
        return idCategorie;
    }

    /**
     * GETTER
     *
     * @return the name of the category
     */
    public String getNameCategory() {
        return nameCategory;
    }

    /**
     * SETTER
     *
     * @param nameCategory new name of the category
     */
    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}