package hu.adakiss.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class RootServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    if (request.getSession(false) != null) {
      request.getRequestDispatcher("home.jsp").forward(request, response);
    } else {
      request.getRequestDispatcher("login").forward(request, response);
    }
  }

  @Override
  protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
