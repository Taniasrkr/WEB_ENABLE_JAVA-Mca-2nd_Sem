package com.assignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "upload";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = request.getParameter("filename");
        if (fileName == null || fileName.equals("")) {
            response.getWriter().println("File name is missing!");
            return;
        }

        String filePath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR + File.separator + fileName;
        File downloadFile = new File(filePath);

        if (!downloadFile.exists()) {
            response.getWriter().println("File not found on server!");
            return;
        }

        // Set content type and headers
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + downloadFile.getName());

        FileInputStream inStream = new FileInputStream(downloadFile);
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inStream.close();
        outStream.close();
    }
}
