package servlets;

import entity.KpopGroup;
import repository.KpopGroupRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/group")
public class KpopGroupServlet extends HttpServlet {

    private final KpopGroupRepository kpopGroupRepository = new KpopGroupRepository();

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
            case "group/new":
                showNewForm(req, resp);
                break;
            case "group/insert":
                insertGroup(req, resp);
                break;
            case "group/update":
                updateGroup(req, resp);
                break;
            case "group/delete":
                deleteGroup(req, resp);
                break;
            case "group/edit":
                showEditForm(req, resp);
                break;
            default:
                listGroup(req, resp);
                break;
        }
    }

    private void listGroup(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        Long id = Long.valueOf(req.getParameter("id"));
        List<KpopGroup> listGroups = kpopGroupRepository.getAllById(id);
        req.setAttribute("listGroups", listGroups);
        RequestDispatcher dispatcher = req.getRequestDispatcher("showGroups.jsp");
        dispatcher.forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("formGroup.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long groupId = Long.valueOf(req.getParameter("id"));
        KpopGroup existingGroup = kpopGroupRepository.get(groupId);
        RequestDispatcher dispatcher = req.getRequestDispatcher("formGroup.jsp");
        req.setAttribute("group", existingGroup);
        dispatcher.forward(req, resp);

    }

    private void insertGroup(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        kpopGroupRepository.insert(parameterWithoutId(req));
        resp.sendRedirect("group/list");
    }

    private void updateGroup(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        kpopGroupRepository.update(parameter(req));
        resp.sendRedirect("group/list");
    }

    private void deleteGroup(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        Long groupId = Long.valueOf(req.getParameter("id"));
        kpopGroupRepository.delete(groupId);
        resp.sendRedirect("group/list");
    }

    private KpopGroup parameter(HttpServletRequest req) {
        Long groupId = Long.valueOf(req.getParameter("groupId"));
        String groupName = req.getParameter("groupName");
        LocalDate dataStartContract = LocalDate.parse(req.getParameter("dataStartContract"));
        LocalDate dataEndContract = LocalDate.parse(req.getParameter("dataEndContract"));
        String managerName = req.getParameter("managerName");
        Long agencyIdFk = Long.valueOf(req.getParameter("agencyIdFk"));
        return new KpopGroup(groupId, groupName, dataStartContract, dataEndContract, managerName, agencyIdFk);
    }

    private KpopGroup parameterWithoutId(HttpServletRequest req) {
        String groupName = req.getParameter("groupName");
        LocalDate dataStartContract = LocalDate.parse(req.getParameter("dataStartContract"));
        LocalDate dataEndContract = LocalDate.parse(req.getParameter("dataEndContract"));
        String managerName = req.getParameter("managerName");
        Long agencyIdFk = Long.valueOf(req.getParameter("agencyIdFk"));
        return new KpopGroup(null, groupName, dataStartContract, dataEndContract, managerName, agencyIdFk);
    }
}
