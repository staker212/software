package controladores;

import modelos.Usuario;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener datos del formulario
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        int edad = Integer.parseInt(request.getParameter("edad"));

        // Crear objeto Usuario (modelo)
        Usuario usuario = new Usuario(nombre, correo, edad);

        // Guardar en base de datos o lista simulada (puedes conectar a DB aquí)
        request.setAttribute("usuario", usuario);

        // Redireccionar a JSP para mostrar resultados
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
        dispatcher.forward(request, response);
    }
}
