package hu.adakiss.sample.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.adakiss.sample.common.LoginAttribute;
import hu.adakiss.sample.dalmock.User;
import hu.adakiss.sample.service.UserService;
import hu.adakiss.sample.service.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet implements LoginAttribute {

  private static final long serialVersionUID = 1L;
  private final UserService userService = new UserServiceImpl();

  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute(ATTR_USERNAME, "");
    request.setAttribute(ATTR_ERROR, "");
    request.getRequestDispatcher("login.jsp").forward(request, response);
  }

  @Override
  protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    Optional<User> maybeUser = userService.findUserByUsername(username);
    if (maybeUser.isPresent() && maybeUser.get().getPassword().equals(request.getParameter("password"))) {
      HttpSession session = request.getSession();
      session.setAttribute("currentUser", username);
      request.getRequestDispatcher("home.jsp").forward(request, response);
    } else {
      request.setAttribute(ATTR_USERNAME, username);
      request.setAttribute(ATTR_ERROR, "Authentication failed");
      request.getRequestDispatcher("login.jsp").forward(request, response);
    }
  }
}
