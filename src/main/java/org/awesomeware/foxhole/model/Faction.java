package org.awesomeware.foxhole.model;

public enum Faction {
    WARDEN("Wardens"), COLONIAL("Colonials");

    private String name;

    private Faction(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
