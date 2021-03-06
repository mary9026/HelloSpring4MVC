package mary.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    // 호출방법 : http://localhost:8080/
    @GetMapping("/")   // action 메서드 //맵핑에 의해서 index 호출되어서 처리 후
    public String index() {

        // 비지니스 로직 처리

        return "index";     // view 리턴 (결과 페이지만 출력할때 사용)
        // 뷰리졸버 정의문에 의해
        // 머리말 + 리턴값 + 꼬리말을 조합해서 뷰 렌더링
        // /WEB-INF/jsp/ + index + .jsp
    }

    // 호출방법 : http://localhost:8080/hello  <- 예전에 사용하던 방식
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView(); // ModelAndView 뷰 페이지에 데이터를 싣어서 보내줄때는 ModelAndView를 기재해 줘야 함

        mv.setViewName("hello"); //  뷰 지정
        // /WEB-INF/jsp/ + hello + .jsp

        mv.addObject("msg", "Hello, World!!"); // 뷰에 넘길 객체를 modelandview 객체에 담음 - msg 라는 객체에 hello, world 값을 담아서 보냄
        mv.addObject("msg2", "안녕하세요~ 스프링 4!!");
        mv.addObject("msg3", "こんにちは、スプリング４!!");

       return mv;
    }
}
