package tn.iit.storeManagement.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorSM  {
    private String message;
    private String conflict;
}
