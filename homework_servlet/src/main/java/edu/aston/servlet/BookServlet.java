package edu.aston.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.aston.model.BookDto;
import edu.aston.service.BookService;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookServlet", urlPatterns = "/book")
public class BookServlet extends HttpServlet {

    private static final Gson gson = new GsonBuilder().create();

    private final BookService bookService = new BookService();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String title = request.getParameter("title");
        int requested = Integer.parseInt(request.getParameter("requested"));
        BookDto dto = new BookDto(title, requested);
        bookService.addBook(dto);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(gson.toJson(dto));
        out.flush();
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        BookDto dto = bookService.getBook(title);
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

        String title = request.getParameter("title");
        int requested = Integer.parseInt(request.getParameter("requested"));
        BookDto dto = new BookDto(title, requested);
        bookService.updateBook(dto);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(gson.toJson(dto));
        out.flush();
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String title = request.getParameter("title");
        bookService.deleteBook(title);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.flush();
        response.setStatus(HttpServletResponse.SC_OK);
    }

}
