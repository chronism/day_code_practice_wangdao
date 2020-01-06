package domain;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class User {
    String username;
    int money;
}
