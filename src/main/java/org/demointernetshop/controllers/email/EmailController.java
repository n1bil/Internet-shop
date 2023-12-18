package org.demointernetshop.controllers.email;

import lombok.AllArgsConstructor;
import org.demointernetshop.entity.Email;
import org.demointernetshop.services.DemoInternetSenderEmail;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmailController {

    private final DemoInternetSenderEmail mailSender;

    @PostMapping("/send-mail")
    public String sendEmail(@RequestBody Email request){
        mailSender.send(request.getTo(), request.getSubject(), request.getText());
        return "Email sent successfully!";
    }
}
