/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wns.ta.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wns.ta.dao.GAReportDAO;
import com.wns.ta.vo.WorkItemVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author u162914
 */
public class JESearchController extends HttpServlet {

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
        
        String action = request.getParameter("action");
        System.out.println("action:" + action);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        /* TODO output your page here. You may use following sample code. */
        
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonArray = "";
        try {
            if(action.equalsIgnoreCase("search")) {
                List<WorkItemVO> workItemList = GAReportDAO.generateJESearch();
                
                // Convert Java Object to Json
                jsonArray = gson.toJson(workItemList);
                
                //Return Json in the format required by jTable plugin
                jsonArray = "{\"Result\":\"OK\",\"Records\":" + jsonArray + "}";
            }
            /* else if (action.equalsIgnoreCase("requestorlist")) {
                String requestor = request.getParameter("requestor");
                List<String> requestorList = GAReportDAO.getRequestorList(requestor);
                
                // Convert Java Object to Json
                jsonArray = new Gson().toJson(requestorList);
                System.out.println("jsonArray" + requestor);
            }*/
            else if(action.equalsIgnoreCase("search1")) {
                String WI_Name = request.getParameter("WI_Name");
                String requestorEmail = request.getParameter("requestorEmail");                
                String txt_APC = request.getParameter("txt_APC");
                String select_Src = request.getParameter("select_Src");
                String select_Cpa = request.getParameter("select_Cpa");
                String select_ReasonCode = request.getParameter("select_ReasonCode");
                String select_Type = request.getParameter("select_Type");
                String datepckEffFrom = request.getParameter("datepckEffFrom");
                String datepckEffTo = request.getParameter("datepckEffTo");
                String approvalFrom = request.getParameter("approvalFrom");
                String approvalTo = request.getParameter("approvalTo");
                String approverEmail = request.getParameter("approverEmail");
                
                
                //Iterator itr= request.getAttributeNames().;
                
                //System.out.println("WI_Name:" + WI_Name +",requestorEmail:"+requestorEmail+",approverEmail:"+approverEmail);
               System.out.println("processRequest() Input parameters=>"+WI_Name+requestorEmail+approverEmail+
                        txt_APC+select_Src+select_Cpa+select_ReasonCode+select_Type+datepckEffFrom+
                        datepckEffTo+approvalFrom+approvalTo);
                // while(itr.hasNext())
               // {
               //      System.out.println(itr.next().toString());
               // }
                List<WorkItemVO> workItemList = GAReportDAO.generateJESearch1(
                        WI_Name,requestorEmail,
                        txt_APC,select_Src,select_Cpa,
                        select_ReasonCode,select_Type,datepckEffFrom,
                        datepckEffTo,approverEmail,approvalFrom,approvalTo);
                
                // Convert Java Object to Json
                jsonArray = gson.toJson(workItemList);
                
                //Return Json in the format required by jTable plugin
                jsonArray = "{\"Result\":\"OK\",\"Records\":" + jsonArray + "}";
            }
            

            
            
            out.print(jsonArray);
        } catch (Exception ex) {
            String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getMessage() + "}";
            response.getWriter().print(error);
        }

        /* out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet SearchController</title>");            
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>Servlet SearchController at " + request.getContextPath() + "</h1>");
         out.println("</body>");
         out.println("</html>");
         */
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