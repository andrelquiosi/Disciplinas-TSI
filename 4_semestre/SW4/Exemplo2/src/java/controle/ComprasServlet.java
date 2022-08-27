/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controle;

import dados.ItemCompra;
import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aluno
 */
@WebServlet(name = "ComprasServlet", urlPatterns = {"/inserir", "/remover", "/alterar"})
public class ComprasServlet extends HttpServlet {

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
        
        request.setCharacterEncoding("UTF-8");
        
        HttpSession sessao = request.getSession(true);
        LinkedList lista = (LinkedList) sessao.getAttribute("lista");
        if (lista == null) {
            lista = new LinkedList();
            sessao.setAttribute("lista", lista);
        }
        try{
        if (request.getRequestURI().endsWith("inserir")) {
            
            String item = request.getParameter("item");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            if (quantidade <=0){
                throw new Exception("Informe uma Quantidade válida!");
            }
            
            if (item != null && item.trim().length() > 0) {
                ItemCompra itemCompra = new ItemCompra(quantidade, item);
                lista.add(itemCompra);
            }
            
        } else if (request.getRequestURI().endsWith("remover")) {
            int pos = Integer.parseInt(request.getParameter("posicao"));
            if (pos >= 0 && pos < lista.size()) {
                lista.remove(pos);
            }
        } else if (request.getRequestURI().endsWith("alterar")) {
            int pos = Integer.parseInt(request.getParameter("posicao"));
            int qtd = Integer.parseInt(request.getParameter("qtd"));
            
            if (pos >= 0 && pos < lista.size()) {
                ItemCompra ic = (ItemCompra) lista.get(pos);
                ic.setQuantidade(qtd);
            }
        }
        }catch(NumberFormatException nfe){
            sessao.setAttribute("msgErro", "Informe uma quantiadade válida!");
        }catch(Exception ex){
            sessao.setAttribute("msgErro", ex.getMessage());
        }
        response.sendRedirect("index.jsp");
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
