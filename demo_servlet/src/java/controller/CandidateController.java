/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.CandidateDAO;
import entity.Candidate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vannhat
 */
public class CandidateController extends HttpServlet {

    CandidateDAO cdDAO = new CandidateDAO();
    List<Candidate> list = cdDAO.getAllCandidates();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");
            System.out.println(theCommand);
            if (theCommand == null) {
                theCommand = "LIST";
            }
                
            switch (theCommand) {
                case "LIST":
                    listCandidate(request, response);
                    break;
                case "LIST-EXPERIENCE":
                    listExperience(request, response);
                    break;
                case "LIST-FRESHER":
                    listFresher(request, response);
                    break;
                case "LIST-INTERN":
                    listIntern(request, response);
                    break;
                default:
                    listCandidate(request, response);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void listCandidate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Candidate> list = cdDAO.getAllCandidates();
        request.setAttribute("candidateList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListCandidate.jsp");
        dispatcher.forward(request, response);
        System.out.print(list.toString());
    }

    private void listExperience(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Candidate> experienceList = new ArrayList<>();
        for (Candidate candidate : list) {
            if (candidate.getCandidateType().getTypeId() == 1) {
                experienceList.add(candidate);
            }
        }
        request.setAttribute("candidateList", experienceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListCandidate.jsp");
        dispatcher.forward(request, response);
        System.out.print(list);
    }

    private void listFresher(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Candidate> fresherList = new ArrayList<>();
        for (Candidate candidate : list) {
            if (candidate.getCandidateType().getTypeId() == 2) {
                fresherList.add(candidate);
            }
        }
        request.setAttribute("candidateList", fresherList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListCandidate.jsp");
        dispatcher.forward(request, response);
        System.out.print(list);
    }

    private void listIntern(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        List<Candidate> internList = new ArrayList<>();
        for (Candidate candidate : list) {
            if (candidate.getCandidateType().getTypeId() == 2) {
                internList.add(candidate);
            }
        }
        request.setAttribute("candidateList", internList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListCandidate.jsp");
        dispatcher.forward(request, response);
        System.out.print(list);
    }
}
