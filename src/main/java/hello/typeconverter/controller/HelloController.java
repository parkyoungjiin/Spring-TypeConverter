package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController {
    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data");
        //getParameter는 String으로 넘어오기에 숫자로 변환.
        Integer intValue = Integer.valueOf(data);
        System.out.println("intValue = " + intValue);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        //RequestParam은 String을 Integer로 자동으로 타입을 변환해줌. (컨버터가 작동됨.)
        //ModelAttribute, PathVariable도 확인 가능.
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        //StringToIpPort (String -> IpPort 객체로 변환하는 컨버터가 작동됨.)
        System.out.println("ipPort IP = " + ipPort.getIp());
        System.out.println("ipPort PORT= " + ipPort.getPort());
        return "ok";
    }
}
