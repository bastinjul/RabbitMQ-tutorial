package be.bastinjul.rabbitmqtutorial.api;

import be.bastinjul.rabbitmqtutorial.services.ProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Tag(name = "TestController")
@Controller
public class TestController {

    private final ProducerService producerService;

    public TestController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @Operation
    @GetMapping(value = "/test/send")
    @ResponseBody
    public String testSend(@RequestParam(value = "message", defaultValue = "Hello World!") String message) {
        return "message sent";
    }
}
