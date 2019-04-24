package com.chatboard.lib;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MobileResult extends BaseMessage {

    private boolean state = false;

    private String message;

    private int errorCode;

    private Object result = null;

    public MobileResult(String message) {
        this.message = message;
    }

    public MobileResult(boolean state, String message, Object result) {
        this.state = state;
        this.message = message;
        this.result = result;
    }
}
