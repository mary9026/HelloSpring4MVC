package mary.spring.mvc.controller;

import mary.spring.mvc.service.SungJukV13Service;
import mary.spring.mvc.vo.SungJukVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

// URL              View
// ~/sungjuk        (sungjuk.jsp)
// ~/sungjukok      (.jsp)
// ~/sungjuklist    (.jsp)
// ~/sungjukview    (.jsp)


@Controller
public class SungJukController {

    @Autowired
    private SungJukV13Service sjsrv13;

    @GetMapping("/sungjuk")     // 성적입력폼
    public String sungjuk() {
        return "sungjuk";
    }

    // 성적입력처리 (post 방식으로 요청 시 호출됨)
    // 성적입력 폼에 입력한 내용들은 스프링 컨테이너에 의해
    // SungJukVO 의 멤버변수에 자동으로 저장됨
    // 단, form 의 각 변수명과 SungJukVO 의 멤버변수명은 일치해야 함

    // ~/sungjuk -> ~/sungjukok -> sjsrv13 -> sjdao12
    //      view        WAS         service     dao
    @PostMapping("/sungjukok")      // 성적입력처리
    public ModelAndView sungjukok(SungJukVO sjvo) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("sungjukok");
        mv.addObject("result", sjsrv13.newSungJuk(sjvo));
        mv.addObject("sj", sjvo);

        // SungJukV12ServiceImpl sjsrv12 = new SungJukV12ServiceImpl(); <- 이제 이렇게 안씀
        //sjsrv13.newSungJuk(sjvo);

        return mv;
    }

    // 성적 데이터 조회
    // 학생번호, 이름, 국어, 영어, 수학, 등록일 형태로 출력
    // ~/sungjuklist -> sjsrv13 -> sjdao12 -> db
    //      view        service     dao
    @GetMapping("/sungjuklist")     // 성적조회
    public ModelAndView sungjuklist() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sungjuklist");
        mv.addObject("sjlist", sjsrv13.readSungJuk());

        return mv;
    }

    // sungjuklist.jsp 에서
    // 목록에서 학생이름을 클릭하면 학생번호 sjno 를 전송
    @GetMapping("/sungjukview")
    public ModelAndView sungjukview(String sjno) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("sungjukview");
        // 뷰리졸버의 머리글 + 뷰이름 + 뷰리졸버꼬리글
        // WEB-INF/jsp + sungjukview + .jsp

        mv.addObject("sj", sjsrv13.readOneSungJuk(sjno));


        return mv;
    }

    @GetMapping("/sungjukdel")
    public String sungjukdel(String sjno) {

        // 성적번호를 이용해서 지정한 성적데이터를 삭제함
        sjsrv13.removeSungJuk(sjno);

        // 성적데이터를 삭제하고 난 뒤 /sungjuklist로 바로 이동
        return "redirect:/sungjuklist";
    }

        // 성적번호를 이용해서 수정할 성적데이터를 읽어와서
        // sungjukupd.jsp 에 출력함
    @GetMapping("/sungjukupd")
    public ModelAndView sungjukupd(String sjno) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("sungjukupd");
        mv.addObject("sj", sjsrv13.readOneSungJuk(sjno));

        return mv;
    }

    // 수정할 성적데이터를 전송 받아서
    // sungjuk 테이블에 적용하고 sungjuklist 로 redirect 함
    @PostMapping("/sungjukupdok")
    public String sungjukupdok(SungJukVO sj) {

        System.out.println(sjsrv13.modifySungJuk(sj));
        // 특정 메서드가 return 한 결과를 콘솔에서 확인할 수 있음

        return "redirect:/sungjuklist";
    }

}
