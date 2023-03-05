package jpabook.jpashop.domain;

import javax.persistence.Entity;

@Entity
public class Movie extends Item {

    private String direct;
    private String actor;

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
