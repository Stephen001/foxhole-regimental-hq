package org.awesomeware.foxhole.model;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface RegimentRepository extends CrudRepository<Regiment, UUID> {
    
}
