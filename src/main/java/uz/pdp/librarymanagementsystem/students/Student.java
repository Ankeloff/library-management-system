package uz.pdp.librarymanagementsystem.students;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student {

    private Long id;
    private String fullname;
    private String username;
    private Long phoneNumber;
    private String password;
    private boolean isAdmin = false;
    private Integer age;


}
