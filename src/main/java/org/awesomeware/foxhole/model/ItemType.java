package org.awesomeware.foxhole.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemType {

    @Id
    private String name;

    public String getName() {
        return this.name;
    }
}
