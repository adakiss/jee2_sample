package hu.adakiss.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.adakiss.sample.dalmock.Hero;
import hu.adakiss.sample.dalmock.Race;
import hu.adakiss.sample.dalmock.User;
import hu.adakiss.sample.service.HeroService;
import hu.adakiss.sample.service.HeroServiceImpl;
import hu.adakiss.sample.service.RaceService;
import hu.adakiss.sample.service.RaceServiceImpl;
import hu.adakiss.sample.service.UserService;
import hu.adakiss.sample.service.UserServiceImpl;

@WebServlet("/createhero")
public class CreateHeroServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private final RaceService raceService = new RaceServiceImpl();
  private final UserService userService = new UserServiceImpl();
  private final HeroService heroService = new HeroServiceImpl();

  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    if (request.getSession(false) != null) {
      request.setAttribute("validationError", "");
      request.setAttribute("races", raceService.fetchAllRaces());
      request.getRequestDispatcher("createhero.jsp").forward(request, response);
    } else {
      request.getRequestDispatcher("login").forward(request, response);
    }
  }

  @Override
  protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    if (request.getSession(false) != null) {
      User creator = userService.findUserByUsername(request.getSession().getAttribute("currentUser").toString()).get();
      String heroName = request.getParameter("name");
      String heroDescription = request.getParameter("description");
      Race race1 = raceService.findRaceByName(request.getParameter("race1")).get();
      Race race2 = raceService.findRaceByName(request.getParameter("race2")).get();
      int race1Percentage = Integer.parseInt(request.getParameter("race1Percentage"));
      Hero heroToSave = new Hero(heroName, heroDescription, race1, race2, creator, race1Percentage);
      heroService.saveHero(heroToSave);
      request.getRequestDispatcher("").forward(request, response);
    } else {
      request.getRequestDispatcher("login.jsp").forward(request, response);
    }
  }

}
