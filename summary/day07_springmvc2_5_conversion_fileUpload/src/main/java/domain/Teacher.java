package domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Teacher {
    private String name;
    private Course course;
}
