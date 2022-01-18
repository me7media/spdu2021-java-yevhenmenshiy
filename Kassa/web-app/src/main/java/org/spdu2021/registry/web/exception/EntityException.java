package org.spdu2021.registry.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityException extends RuntimeException{
        public EntityException(String message) { super(message);}
}
