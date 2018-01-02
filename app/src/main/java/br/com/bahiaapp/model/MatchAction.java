package br.com.bahiaapp.model;

import java.io.Serializable;

/**
 * Created by Igor Faria on 02/01/18.
 */

public class MatchAction implements Serializable {

    private Long id;
    private String description;
    private String title;
    private String time;
    private Boolean homeAction;
    private Boolean awayAction;
    private Boolean matchAction;
    private MatchActionType matchActionType;
    private Match match;


    public MatchAction(MatchActionType matchActionType, String description, String title, String time,
                       Boolean homeAction, Boolean awayAction, Boolean matchAction){
        this.description = description;
        this.title = title;
        this.time = time;
        this.homeAction = homeAction;
        this.awayAction = awayAction;
        this.matchAction = matchAction;
        this.setMatchActionType(matchActionType);
    }

    public MatchAction(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public Boolean isHomeAction() {
        return homeAction;
    }

    public void setHomeAction(Boolean homeAction) {
        this.homeAction = homeAction;
    }

    public Boolean isAwayAction() {
        return awayAction;
    }

    public void setAwayAction(Boolean awayAction) {
        this.awayAction = awayAction;
    }

    public Boolean isMatchAction() {
        return matchAction;
    }

    public void setMatchAction(Boolean matchAction) {
        this.matchAction = matchAction;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public MatchActionType getMatchActionType() {
        return matchActionType;
    }

    public void setMatchActionType(MatchActionType matchActionType) {
        this.matchActionType = matchActionType;
    }
}
