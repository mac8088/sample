package net.atos.sample.do2dto;

import java.util.Date;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private Long id;
    private String name;
    private String email;
    private Date birthday;
    private User user;
}
