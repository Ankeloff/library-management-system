package uz.pdp.librarymanagementsystem.students;

import uz.pdp.librarymanagementsystem.db.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDao {

    public static boolean Register(Student student){

        if (student.getUsername().equals("admin")){
            System.out.println("hello");
            return false;
        }
        System.out.println("ishladi");
        List<Student> studentList = getStudentList();

        System.out.println(Arrays.toString(studentList.toArray()));

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
            System.out.println(student);
            String sql = "INSERT INTO student(fullname, username, phone_number, password, age)" +
                "VALUES ('"+ student.getFullname() +"','"+ student.getUsername()+"','"+ student.getPhoneNumber() +"'," +
                    "'"+ student.getPassword() +"','"+ student.getAge()+"')";

            Statement statement = connection.createStatement();


            System.out.println(statement.execute(sql));

//            preparedStatement.setString(1,student.getFullname());
//            preparedStatement.setString(2,student.getUsername());
//            preparedStatement.setLong(3,student.getPhoneNumber());
//            preparedStatement.setString(4,student.getPassword());
//            preparedStatement.setInt(5,student.getAge());

//            System.out.println(preparedStatement);
//            preparedStatement.executeQuery();
            System.out.println("oxiri");
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


    public static boolean Login(Student student) {

        List<Student> studentList = getStudentList();

        for (Student student1 : studentList) {
            if (student1.getUsername().equals(student.getUsername()) &&
                    student1.getPassword().equals(student.getPassword())){
                return true;
            }
        }

        return false;
    }
}
