package ro.jtonic.isr.yts.validation.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Antonel Ernest Pazargic on 09/05/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@Data
@Builder
public class ErrorMessage {
    private String message;
    private String description;
}
