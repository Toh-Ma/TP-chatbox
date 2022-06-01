package fr.ensim.interop.introrest.model.weather;

public class Wind {
    private Float speed;
    private Float deg;

    public Wind() {
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Float getDeg() {
        return deg;
    }

    public void setDeg(Float deg) {
        this.deg = deg;
    }
}
