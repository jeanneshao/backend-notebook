package com.example.websocket.stomp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Principal;

/**
 * @author Jeanne 2023/6/27
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StimulatedPrincipal implements Principal {
    private String name;
    @Override
    public String getName() {
        return name;
    }
}
