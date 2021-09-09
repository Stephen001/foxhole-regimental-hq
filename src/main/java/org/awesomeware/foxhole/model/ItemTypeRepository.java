package org.awesomeware.foxhole.model;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface ItemTypeRepository extends CrudRepository<ItemType, UUID> {
    
}
