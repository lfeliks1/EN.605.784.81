package app.demo;

// import org.springframework.http.HttpHeaders;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("rpc/hello")
public class RpcController {
    /**
     * This is an example of a method as simple as it gets
     */
    @RequestMapping(path="toDo", method=RequestMethod.GET)
    @ResponseBody
    public String sayHello()  {
        return "--- Hello, 605.784.81 online class ! ---";    
    }    
    @RequestMapping(path="say/{welcome}", method=RequestMethod.GET)
    @ResponseBody
    public String sayWelcome(
            @PathVariable("welcome")String greeting,
            @RequestParam(value = "name", defaultValue = "Happy learning ") String name) {
        return greeting + ", " + name;
    }
}
