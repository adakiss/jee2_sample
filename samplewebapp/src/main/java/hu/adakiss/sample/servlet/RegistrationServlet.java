package hu.adakiss.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.adakiss.sample.common.LoginAttribute;
import hu.adakiss.sample.dalmock.User;
import hu.adakiss.sample.exception.SampleAppException;
import hu.adakiss.sample.service.UserService;
import hu.adakiss.sample.service.UserServiceImpl;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet implements LoginAttribute {

  private static final long serialVersionUID = 1L;
  private final UserService userService = new UserServiceImpl();

  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute(ATTR_USERNAME, "");
    request.setAttribute(ATTR_ERROR, "");
    request.getRequestDispatcher("registration.jsp").forward(request, response);
  }

  @Override
  protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    User newUser = new User(request.getParameter("username"), request.getParameter("password"));
    try {
      userService.addUser(newUser);
      request.getRequestDispatcher("login.jsp").forward(request, response);
    } catch (SampleAppException e) {
      request.setAttribute(ATTR_USERNAME, newUser.getUsername());
      request.setAttribute(ATTR_ERROR, e.getMessage());
      request.getRequestDispatcher("registration.jsp");
    }
  }
}
