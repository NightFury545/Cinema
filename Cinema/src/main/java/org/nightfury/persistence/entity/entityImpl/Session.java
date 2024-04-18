package org.nightfury.persistence.entity.entityImpl;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.nightfury.persistence.entity.GenericEntity;

@Data
@Builder
@AllArgsConstructor
public class Session implements GenericEntity {
    private int id;
    private Movie movie;
    private Hall hall;
    private LocalDateTime startDateTime;
}
