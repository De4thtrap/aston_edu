package edu.aston.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.aston.model.BookDto;
import edu.aston.model.UserDto;
import edu.aston.service.BookService;
import edu.aston.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

  private static final Gson gson = new GsonBuilder().create();
  private final UserService userService = new UserService();

  @Override
  protected void doPost(
      HttpServletRequest request,
      HttpServletResponse response) throws IOException {

    String username = request.getParameter("username");
    String titles = request.getParameter("books");
    List<String> books = Arrays.asList(titles.split(","));
    UserDto dto = new UserDto(username, books);
    userService.addUser(dto);

    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    out.flush();
    response.setStatus(HttpServletResponse.SC_OK);
  }

  @Override
  protected void doGet(
      HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    String username = request.getParameter("username");
    UserDto dto = userService.getUser(username);

    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    out.write(gson.toJson(dto));
    out.flush();
    response.setStatus(HttpServletResponse.SC_OK);
  }

  @Override
  protected void doPut(
      HttpServletRequest request,
      HttpServletResponse response) throws IOException {

    String username = request.getParameter("username");
    UserDto dto = userService.getUser(username);
    String titles = request.getParameter("books");
    List<String> books = Arrays.asList(titles.split(","));
    dto.setBooks(books);
    userService.updateUser(dto);

    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    out.flush();
    response.setStatus(HttpServletResponse.SC_OK);
  }

  @Override
  protected void doDelete(
      HttpServletRequest request,
      HttpServletResponse response) throws IOException {

    String username = request.getParameter("username");
    userService.deleteUser(username);

    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    out.flush();
    response.setStatus(HttpServletResponse.SC_OK);
  }

}
