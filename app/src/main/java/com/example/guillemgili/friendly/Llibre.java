package com.example.guillemgili.friendly;

/**
 * Created by guillem.gili on 11/25/16.
 */
public class Llibre {
    private String name;
    boolean selected=false,visible=false;//visible es per la descripcio
    private String author;
    private String year;
    private String editorial;
    private String category;
    private String score;


    Llibre(boolean icon, String name) {
        this.selected = icon;
        this.name = name;
        this.selected=false;
    }

    Llibre() {
        this.selected=false;
    }

    Llibre(String name,String author, String year, String editorial, String categoria, String valoracio){
        this.selected=false;
        this.visible=false;
        this.name=name;
        this.author=author;
        this.year=year;
        this.editorial=editorial;
        this.category=categoria;
        this.score=valoracio;
    }

    public void unselect(){this.selected=false;}
    public void select(){this.selected=true;}
    public boolean isSelected(){return selected;};

    public void setVisible(boolean visible){this.visible=visible;}
    public boolean isVisible(){return this.visible;}

    //getters
    public String getValoracio(){return score;}
    public String getCategoria(){return category;}
    public String getEditorial(){return editorial;}
    public String getYear(){return year;}
    public String getAuthor(){return author;}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
