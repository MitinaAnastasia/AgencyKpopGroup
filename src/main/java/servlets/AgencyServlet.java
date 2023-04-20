package servlets;

import entity.Agency;
import repository.AgencyRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class AgencyServlet extends HttpServlet {

    private final AgencyRepository agencyRepository = new AgencyRepository();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getServletPath();
        switch (action) {
            case "/new":
                showNewForm(req, resp);
                break;
            case "/insert":
                insertAgency(req, resp);
                break;
            case "/update":
                updateAgency(req, resp);
                break;
            case "/delete":
                deleteAgency(req, resp);
                break;
            case "/edit":
                showEditForm(req, resp);
                break;
            default:
                listAgency(req, resp);
                break;
        }
    }

    private void listAgency(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        List<Agency> listAgencies = agencyRepository.getAll();
        req.setAttribute("listAgencies", listAgencies);
        RequestDispatcher dispatcher = req.getRequestDispatcher("showAgencies.jsp");
        dispatcher.forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("formAgency.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long agencyId = Long.valueOf(req.getParameter("id"));
        Agency existingAgency = agencyRepository.get(agencyId);
        RequestDispatcher dispatcher = req.getRequestDispatcher("formAgency.jsp");
        req.setAttribute("agency", existingAgency);
        dispatcher.forward(req, resp);

    }

    private void insertAgency(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        agencyRepository.insert(parameterWithoutId(req));
        resp.sendRedirect("list");
    }

    private void updateAgency(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        agencyRepository.update(parameter(req));
        resp.sendRedirect("list");
    }

    private void deleteAgency(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        Long agencyId = Long.valueOf(req.getParameter("id"));
        agencyRepository.delete(agencyId);
        resp.sendRedirect("list");
    }

    private Agency parameter(HttpServletRequest req) {
        Long agencyId = Long.valueOf(req.getParameter("agencyId"));
        String agencyName = req.getParameter("agencyName");
        String directorName = req.getParameter("directorName");
        String telephoneNumber = req.getParameter("telephoneNumber");
        String address = req.getParameter("address");
        return new Agency(agencyId, agencyName, directorName, telephoneNumber, address);
    }

    private Agency parameterWithoutId(HttpServletRequest req) {
        String agencyName = req.getParameter("agencyName");
        String directorName = req.getParameter("directorName");
        String telephoneNumber = req.getParameter("telephoneNumber");
        String address = req.getParameter("address");
        return new Agency(null, agencyName, directorName, telephoneNumber, address);
    }
}

