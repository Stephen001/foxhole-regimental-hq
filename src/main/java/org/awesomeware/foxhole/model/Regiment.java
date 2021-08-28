package org.awesomeware.foxhole.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Regiment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Faction faction;
    private String name;

    public UUID getID() {
        return id;
    }

    public Faction getFaction() {
        return faction;
    }

    public String getName() {
        return name;
    }
}