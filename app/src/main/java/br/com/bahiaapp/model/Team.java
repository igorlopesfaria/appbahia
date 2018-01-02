package br.com.bahiaapp.model;

import java.io.Serializable;

/**
 * Created by Igor Faria on 02/01/18.
 */

public class Team implements Serializable{

    private Long id;
    private String name;
    private String shortName;
    private String shieldIMG;

    public Team(String name, String shortName, String shieldIMG){
        this.shortName = shortName;
        this.shieldIMG = shieldIMG;

    }

    public Team () {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShieldIMG() {
        return shieldIMG;
    }

    public void setShieldIMG(String shieldIMG) {
        this.shieldIMG = shieldIMG;
    }
}
