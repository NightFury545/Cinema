package org.nightfury.persistence.entity.entityImpl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.nightfury.persistence.entity.GenericEntity;

@Data
@Builder
@AllArgsConstructor
public class Ticket implements GenericEntity {
    private int id;
    private Session session;
    private int seatNumber;
    private double price;
    private String status;
    private User user;
}
