
//Namespace
package com.quiniela.wc.domain;

//Imports

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Class that represents a football match
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Match {

    private Long id;
    private String stage;
    private Date datetime;

    private Stadium stadium;

    @JsonProperty("localTeam")
    private Team local;

    @JsonProperty("visitorTeam")
    private Team visitor;

    @NotNull
    @Range(min = 0, max = 15)
    private Integer goalsLocal;

    @NotNull
    @Range(min = 0, max = 15)
    private Integer goalsVisitor;


    //Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Date getDatetime() {
        if (this.datetime == null) {
            return null;
        }
        return new Date(this.datetime.getTime());
    }

    public void setDatetime(final Date datetime) {
        if (datetime == null) {
            this.datetime = null;
        } else {
            this.datetime = new Date(datetime.getTime());
        }
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Team getLocal() {
        return local;
    }

    public void setLocal(Team local) {
        this.local = local;
    }

    public Team getVisitor() {
        return visitor;
    }

    public void setVisitor(Team visitor) {
        this.visitor = visitor;
    }

    public Integer getGoalsLocal() {
        if (this.goalsLocal == null || this.goalsLocal < 0) {
            return null;
        }
        else {
            return goalsLocal;
        }
    }

    public void setGoalsLocal(Integer goalsLocal) {
        this.goalsLocal = goalsLocal;
    }

    public Integer getGoalsVisitor() {
        if (this.goalsVisitor == null || this.goalsVisitor < 0) {
            return null;
        }
        else {
            return goalsVisitor;
        }
    }

    public void setGoalsVisitor(Integer goalsVisitor) {
        this.goalsVisitor = goalsVisitor;
    }



}