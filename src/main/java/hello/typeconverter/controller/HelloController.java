package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        //request에서 받는 건 문자타입
        String data = request.getParameter("data"); //문자 타입 조회
        Integer intVale = Integer.valueOf(data); //숫자 타입으로 변경
        System.out.println("intVale = " + intVale);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        //@RequestParam은 문자타입의 쿼리스트링을 지정한 타입으로 변환해준다.
        //@ModelAttribute, @PathVariable도 마찬가지!
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        System.out.println("ipPort ip = " + ipPort.getIp());
        System.out.println("ipPort port = " + ipPort.getPort());
        return "ok";
    }
}
