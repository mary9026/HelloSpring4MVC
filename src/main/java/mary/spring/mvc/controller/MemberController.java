package mary.spring.mvc.controller;

import mary.spring.mvc.service.MemberService;
import mary.spring.mvc.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
public class MemberController {

    @Autowired
    private MemberService msrv04;

    @GetMapping("/member")
    public String member() {
        return "member";
    }

    @PostMapping("/memberok")
    public ModelAndView memberok(MemberVO mvo) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("memberok");
        mv.addObject("result", msrv04.newMember(mvo)); // result는 실행하고 난 결과
        mv.addObject("mvo", mvo); // mvo는 입력받은거 그대로 출력

        return mv;
    }

    @GetMapping("/memberlist")
    public ModelAndView memberlist() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("memberlist"); //  /WEB-INF/jsp/memberlist.jsp 파일을 불러온다 라는 의미
        mv.addObject("mvos", msrv04.readMember());

        return mv;
    }

    @GetMapping("/memberview")
    public ModelAndView memberview(String userid) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("memberview");
        mv.addObject("mvo", msrv04.readOneMember(userid));

        return mv;
    }


}
