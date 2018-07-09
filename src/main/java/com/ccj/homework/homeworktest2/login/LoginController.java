package com.ccj.homework.homeworktest2.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.print.attribute.standard.PrinterLocation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class LoginController {

    @GetMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {


        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>用户登录</title>");
        writer.println("</head>");
        writer.println("<body><h1>用户登录</h1>");
        writer.println("<form method='post'>");
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<td>Name:</td>");
        writer.println("<td><input name='name'/></td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>PWD:</td>");
        writer.println("<td><input name='pwd'/></td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>&nbsp;</td>");
        writer.println("<td><input type='reset'/>" + "<input type='submit'/></td>");
        writer.println("</tr>");
        writer.println("</table>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");

    }

    @PostMapping("/login")
    public String verification(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        if (name.equals("root") && pwd.equals("root")) {
            User user = new User();
            user.setName(name);
            session.setAttribute("user", user);
            return "登录成功!";
        } else {
            return "用户名或密码错误!";

        }
    }
}

