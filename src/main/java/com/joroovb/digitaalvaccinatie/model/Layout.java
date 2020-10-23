package com.joroovb.digitaalvaccinatie.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Layout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    private char i;
    private String type;
    private int x;
    private int y;
    private int w;
    private int h;
    private int minW;
    private int maxW;

    @ManyToOne
    @JoinColumn(name = "caregiverid")
    private Caregiver caregiver;

    public Layout() {

    }

    public Layout(char i, int x, int y, int w, int h, int minW, int maxW) {
        this.i = i;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.minW = minW;
        this.maxW = maxW;
    }

    public char getI() {
        return i;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getMinW() {
        return minW;
    }

    public void setMinW(int minW) {
        this.minW = minW;
    }

    public int getMaxW() {
        return maxW;
    }

    public void setMaxW(int maxW) {
        this.maxW = maxW;
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }
}
