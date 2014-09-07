package br.com.spo.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.spo.model.beans.Usuario;
import br.com.spo.model.enumerations.Telas;

@WebFilter(filterName = "AcessoFiltro", urlPatterns = "/pages/*", dispatcherTypes = { DispatcherType.FORWARD, DispatcherType.INCLUDE,
        DispatcherType.REQUEST })
public class AcessoFiltro implements Filter {
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) req).getSession();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        
        if ((usuarioLogado == null)) {
            ((HttpServletResponse) resp).sendRedirect(((HttpServletRequest) req).getContextPath() + Telas.INDEX.getUrl() + ".xhtml");
        } else {
            chain.doFilter(req, resp);
        }
    }
    
    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
    
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}
