package domain;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Data
public class User {
    private String username;
    private String password;
}
