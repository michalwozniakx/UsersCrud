package pl.coderslab.users;

import pl.conderslab.utils.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/list")
public class UserList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();        //Pobieramy w ten sposób listę wszystkich użytkowników i dodajemy atrybut do obiektu HttpServletRequest,
        request.setAttribute("users", userDao.findAll());       //dzięki temu będziemy mogli go wykorzystać w pliku jsp.

        //System.out.println(Arrays.toString(userDao.findAll()));

        getServletContext().getRequestDispatcher("/users/list.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
