package com.example.SpringEmailProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class EmailController {

    @Autowired
    private EmailSenderService senderService;

    @GetMapping("/")  // This handles the initial page (index.html)
    public String showForm() {
        return "index";  // This will look for index.html in templates or static folder
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestParam("toEmail") String toEmail,
                            @RequestParam("subject") String subject,
                            @RequestParam("body") String body,
                            Model model) {
        senderService.sendSimpleEmail(toEmail, subject, body);
        model.addAttribute("message", "Email sent successfully to " + toEmail);
        return "email-status"; // Success page
    }
}
