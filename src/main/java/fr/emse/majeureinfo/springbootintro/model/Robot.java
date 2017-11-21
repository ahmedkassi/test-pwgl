package fr.emse.majeureinfo.springbootintro.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class Robot {
    @Id @GeneratedValue
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Sensor sensor;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)

    private Actuator actuator;
    public Robot(Sensor sensor, Actuator actuator) {
        this.sensor = sensor;
        this.actuator = actuator;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Actuator getActuator() {
        return actuator;
    }

    public void setActuator(Actuator actuator) {
        this.actuator = actuator;
    }

    public void switchSensor() {
        if (this.getSensor().getStatus() == Status.ON){
            this.getSensor().setStatus(Status.OFF);
        }
        else {
            this.getSensor().setStatus(Status.ON);
        }
    }


    public void switchActuator() {
        if (this.getActuator().getStatus() == Status.ON) {
            this.getActuator().setStatus(Status.OFF);
        }
        else {
            this.getActuator().setStatus(Status.ON);
        }
    }



}
