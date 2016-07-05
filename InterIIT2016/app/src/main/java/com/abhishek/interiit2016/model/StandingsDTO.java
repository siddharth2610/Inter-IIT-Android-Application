package com.abhishek.interiit2016.model;

/**
 * Created by GUNDA ABHISHEK on 29-06-2016.
 */
public class StandingsDTO {
    private String position;
    private String college_name;
    private String standings_points;

    public StandingsDTO(String position ,String college_name,String standings_points){
        this.position=position;
        this.college_name=college_name;
        this.standings_points=standings_points;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getStandings_points() {
        return standings_points;
    }

    public void setStandings_points(String standings_points) {
        this.standings_points = standings_points;
    }



}
