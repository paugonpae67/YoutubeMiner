package AISS.YouTubeMiner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Max value must be an integer greater or equal to 0")
public class MaxValueException extends Exception{
}
