package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Topping")
public class Topping {
    @Id
    @Column(name = "t_id")
    @SequenceGenerator(sequenceName="topping_id_maker", name="topping_seq")
    @GeneratedValue(generator="topping_seq", strategy=GenerationType.SEQUENCE)
    private int topping_id;
    
    @Column(name = "topping_name")
    private String topping_name;
    
    @Column(name = "calories")
    private double calories;
    
    @ManyToOne
    @JoinColumn(name="tt_id")
    private int tt_id;
    
    public Topping() {
        super();
    }
    
    public Topping(int topping_id, String topping_name, double calories, int tt_id) {
        super();
        this.topping_id = topping_id;
        this.topping_name = topping_name;
        this.calories = calories;
        this.tt_id = tt_id;
    }
    public int getT_id() {
        return topping_id;
    }
    public void setT_id(int topping_id) {
        this.topping_id = topping_id;
    }
    public String getTopping_name() {
        return topping_name;
    }
    public void setTopping_name(String topping_name) {
        this.topping_name = topping_name;
    }
    public double getCalories() {
        return calories;
    }
    public void setCalories(double calories) {
        this.calories = calories;
    }
    public int getTt_id() {
        return tt_id;
    }
    public void setTt_id(int tt_id) {
        this.tt_id = tt_id;
    }
    
    @Override
    public String toString() {
        return "Topping [topping_id=" + topping_id + ", topping_name=" + topping_name + ", calories=" + calories + ", tt_id="
                + tt_id + "]";
    }
}
