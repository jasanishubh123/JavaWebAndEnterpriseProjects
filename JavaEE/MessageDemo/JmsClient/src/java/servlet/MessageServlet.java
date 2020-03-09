/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
public class MessageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MessageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            try{
                Properties p = new Properties();
                p.put(Context.PROVIDER_URL,"mq://localhost:7676");
                InitialContext ic= new  InitialContext(p);
                
                Queue queue = (Queue)ic.lookup("jms/itqueue");
                
                ConnectionFactory cf = (ConnectionFactory)ic.lookup("jms/itqueueFactory");
                
                try{
                    Connection con;
                    con = cf.createConnection();
                    Session session = con.createSession();
                    MessageProducer mp = session.createProducer(queue);
                    
                    TextMessage tm = session.createTextMessage("This is Queue Message");
                    mp.send(tm);
                    
                }catch(JMSException ej){
                    ej.printStackTrace();
                }
                
                
                InitialContext ic1=new InitialContext(p);
                Topic topic=(Topic)ic1.lookup("jms/ittopic");
                TopicConnectionFactory tcf = (TopicConnectionFactory)ic1.lookup("jms/ittopicFactory");
                TopicConnection tcon= tcf.createTopicConnection();
                TopicSession tsession= tcon.createTopicSession(true, 0);
                TopicPublisher tmp = tsession.createPublisher(topic);
                TextMessage tms=tsession.createTextMessage("Message for Topic Bean");
                tmp.publish(tms);
                tcon.close();
                
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
           // out.println("<h1>Servlet MessageServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
