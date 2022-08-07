package uz.pdp.librarymanagementsystem.students;

import uz.pdp.librarymanagementsystem.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public static boolean Register(Student student){

        if (student.getUsername().equals("admin")){
            return false;
        }

        List<Student> studentList = getStudentList();

        if (student.getPassword().isEmpty()){
            return false;
        }

        for (Student student1 : studentList) {
            if (student.getUsername().equals(student1.getUsername())) {
                return false;
            }
        }


        try {
          Connection connection = DbConnection.getConnection();

            String sql = "insert into student(fullname, username, phone_number, password, age) VALUES " +
                "(?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,student.getFullname());
            preparedStatement.setString(2,student.getUsername());
            preparedStatement.setLong(3,student.getPhoneNumber());
            preparedStatement.setString(4,student.getPassword());
            preparedStatement.setInt(5,student.getAge());

            preparedStatement.executeQuery();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }



    public static List<Student> getStudentList(){

        List<Student> studentList = new ArrayList<>();
        Connection connection = DbConnection.getConnection();

        String sql = "select * from student";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

            Long id = resultSet.getLong("id");
            String fullname = resultSet.getString("fullname");
            String username = resultSet.getString("username");
            Long phoneNumber = resultSet.getLong("phone_number");
            String password = resultSet.getString("password");
            int age = resultSet.getInt("age");
            boolean isAdmin = resultSet.getBoolean("is_admin");

            Student student = Student.builder()
                    .id(id)
                    .fullname(fullname)
                    .username(username)
                    .phoneNumber(phoneNumber)
                    .password(password)
                    .age(age)
                    .isAdmin(isAdmin)
                    .build();

            studentList.add(student);

            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return studentList;
    }





}
