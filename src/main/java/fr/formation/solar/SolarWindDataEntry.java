package fr.formation.solar;

import java.math.BigDecimal;

public class SolarWindDataEntry {

    private String date;
    private BigDecimal speed;
    private BigDecimal density;
    private BigDecimal bt;
    private BigDecimal bz;


    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getSpeed() {
        return this.speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public BigDecimal getDensity() {
        return this.density;
    }

    public void setDensity(BigDecimal density) {
        this.density = density;
    }


    public BigDecimal getBt() {
        return this.bt;
    }

    public void setBt(BigDecimal bt) {
        this.bt = bt;
    }

    public BigDecimal getBz() {
        return this.bz;
    }

    public void setBz(BigDecimal bz) {
        this.bz = bz;
    }

}
