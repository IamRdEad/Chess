package com.rdead.chess;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GeneralMessage {
    private String username;
    private int code;
}
