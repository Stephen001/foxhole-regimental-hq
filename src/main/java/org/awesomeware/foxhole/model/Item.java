package org.awesomeware.foxhole.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Faction faction;
    private String name;
    private String description;
    @ManyToOne
    private ItemType itemType;
    private int crateSize;

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Faction getFaction() {
        return this.faction;
    }

    public ItemType getItemType() {
        return this.itemType;
    }

    public int getCrateSize() {
        return this.crateSize;
    }
}
