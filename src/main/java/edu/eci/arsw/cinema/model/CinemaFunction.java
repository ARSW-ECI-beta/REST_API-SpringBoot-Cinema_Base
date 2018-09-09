/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.model;

import edu.eci.arsw.cinema.persistence.CinemaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author cristian
 */
public class CinemaFunction {
    
    private Movie movie;
    private List<List<Boolean>> seats=new ArrayList<>();
    private Date date;
    
    public CinemaFunction(){}
    
    public CinemaFunction(Movie movie, Date date){
        this.movie=movie;
        this.date=date;
        List<Boolean> row= new ArrayList<>(Arrays.asList(new Boolean[12]));
        Collections.fill(row, Boolean.TRUE);
        for (int i=0;i<7;i++){
            this.seats.add(row);
        }
    }
    
    public void buyTicket(int row,int col) throws CinemaException{
        if (seats.get(row).get(col).equals(false)){
            seats.get(row).set(col,Boolean.FALSE);
        }
        else{
            throw new CinemaException("Seat booked");
        }
    }
    
    public List<List<Boolean>> getSeats() {
        return this.seats;
    }
    
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
    
}
