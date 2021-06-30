/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

//import filter.FilterManager;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public abstract class Command{
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    
    public void init(
      HttpServletRequest servletRequest,
      HttpServletResponse servletResponse) {
        this.request = servletRequest;
        this.response = servletResponse;
    }

    public abstract void process() throws ServletException, IOException;

    protected void forward(String target) throws ServletException, IOException {
         
        target = String.format("/%s.jsp", target);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }

}
