package org.awesomeware.foxhole.model;

import java.util.stream.Stream;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class FactionConvertor implements AttributeConverter<Faction, String> {
 
    @Override
    public String convertToDatabaseColumn(Faction faction) {
        if (faction == null) {
            return null;
        }
        return faction.getName();
    }

    @Override
    public Faction convertToEntityAttribute(String name) {
        if (name == null) {
            return null;
        }

        return Stream.of(Faction.values())
          .filter(c -> c.getName().equals(name))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}
