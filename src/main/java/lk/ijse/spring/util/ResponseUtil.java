package lk.ijse.spring.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Lahiru Dilshan
 * @created Fri 10:07 AM on 9/15/2023
 * @project Spring-Assigment-02
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ResponseUtil {
    private int code;
    private String massage;
    private Object data;
}
