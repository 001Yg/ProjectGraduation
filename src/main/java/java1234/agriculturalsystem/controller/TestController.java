package java1234.agriculturalsystem.controller;

import java1234.agriculturalsystem.entity.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java1234")    //"/java1234.agriculturalsystem"
public class TestController {
    @GetMapping("/test")
    public R test(){
        return R.ok("牛逼java1234");
    }
}
