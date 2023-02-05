package io.aweseean.assignments.helsinkicitybikes.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class WebErrorController implements ErrorController {

    @GetMapping
    public String getErrorPage(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            String text = "";
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                text = "The page you are looking for cannot be found.";
            } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
                text = "You are not authorized to the page you are requesting.";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                text = "You don't have permissions for this page.";
            } else {
                text = "It's an unknown error.";
            }
            model.addAttribute("errorText", text);
            model.addAttribute("errorCode", statusCode);
        } else {
            model.addAttribute("errorText", "An unknown error has occurred");
            model.addAttribute("errorCode", "Unknown");
        }
        return "error";
    }
}
