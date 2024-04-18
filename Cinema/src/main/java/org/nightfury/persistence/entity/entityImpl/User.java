package org.nightfury.persistence.entity.entityImpl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.nightfury.persistence.entity.GenericEntity;
@Data
@Builder
@AllArgsConstructor
public class User implements GenericEntity {
    private int id;
    private String name;
    private String password;
}
