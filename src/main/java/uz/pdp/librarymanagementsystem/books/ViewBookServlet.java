package uz.pdp.librarymanagementsystem.books;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.students.Student;
import uz.pdp.librarymanagementsystem.students.StudentDao;

import java.io.IOException;
import java.util.List;

@WebServlet({"/books"})
public class ViewBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fullname = req.getParameter("fullname");
        String username = req.getParameter("username");
        Long phoneNumber = Long.valueOf(req.getParameter("phoneNumber"));
        String password = req.getParameter("password");
        Integer age = Integer.valueOf(req.getParameter("password"));

        Student student = Student.builder()
                .fullname(fullname)
                .username(username).phoneNumber(phoneNumber)
                .password(password)
                .age(age)
                .build();

        boolean result = StudentDao.Register(student);
        System.out.println(result);
         if (!result){
             return;
         }

        String pageStr = req.getParameter("page");
        int page = 1;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int size = 10;

        List<Book> bookList = BookDao.getAllBooks(size, page);

        req.setAttribute("bookList", bookList);

        boolean added = Boolean.parseBoolean(req.getParameter("added"));
        if (added) {
            req.setAttribute("message", "Successfully added!!!");
        }


        req.getRequestDispatcher("book.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);

        boolean result = StudentDao.Login(student);

        if (!result) {
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

        String pageStr = req.getParameter("page");
        int page = 1;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int size = 10;

        List<Book> bookList = BookDao.getAllBooks(size, page);

        req.setAttribute("bookList", bookList);

        boolean added = Boolean.parseBoolean(req.getParameter("added"));
        if (added) {
            req.setAttribute("message", "Successfully added!!!");
        }
        req.getRequestDispatcher("book.jsp").forward(req, resp);

    }
}
