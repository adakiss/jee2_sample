package hu.adakiss.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.adakiss.sample.service.HeroService;
import hu.adakiss.sample.service.HeroServiceImpl;

@WebServlet("/allheroes")
public class AllHeroesServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private final HeroService heroService = new HeroServiceImpl();

  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    if (request.getSession(false) != null) {
      request.setAttribute("heroList", heroService.listAllHeroes());
      request.getRequestDispatcher("herolist.jsp").forward(request, response);
    } else {
      request.getRequestDispatcher("login").forward(request, response);
    }
  }
}
