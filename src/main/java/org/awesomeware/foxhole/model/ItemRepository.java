package org.awesomeware.foxhole.model;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, UUID> {
    
}
