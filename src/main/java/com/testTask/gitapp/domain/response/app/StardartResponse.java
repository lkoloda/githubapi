package com.testTask.gitapp.domain.response.app;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class StardartResponse<T> {
    private static final String MSG_EMPTY="";
    private static final String CODE_OK="OK";

    private T response;
    private final String responseCode;
    private final LocalDateTime execDate;
    private final String message;

    public StardartResponse(final String code,final String message, final LocalDateTime execDate){
        this.execDate = execDate==null ? LocalDateTime.now():execDate;
        this.message = message ==null ? StardartResponse.MSG_EMPTY:message;
        this.responseCode=code==null ? StardartResponse.CODE_OK:code;
    }

    public StardartResponse<T> setResponse(final T obj){
        this.response = obj;
        return this;
    }

}
