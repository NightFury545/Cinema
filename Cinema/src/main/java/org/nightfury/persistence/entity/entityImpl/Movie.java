package org.nightfury.persistence.entity.entityImpl;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.nightfury.persistence.entity.GenericEntity;

@Data
@Builder
@AllArgsConstructor
public class Movie implements GenericEntity {
    private int id;
    private String name;
    private LocalDate releaseYear;
    private String genre;
    private int duration;
    private String director;
    private String description;
}
