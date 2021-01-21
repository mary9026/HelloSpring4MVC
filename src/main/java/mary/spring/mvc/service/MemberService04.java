package mary.spring.mvc.service;


import mary.spring.mvc.dao.MemberDAO03;
import mary.spring.mvc.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("msrv04")
public class MemberService04 implements MemberService{

    @Autowired
    private MemberDAO03 mdao03;

    // 회원 정보 생성
    public String newMember(MemberVO mvo) {
        String result = "회원데이터 처리중 ..?!?";
        int cnt = mdao03.insertMember(mvo);
        if (cnt > 0) result = "회원데이터 저장완료 ! ";

        return result;
    }

    // 회원 정보 수정 (이름, 등급, 포인트)
    public String modifyMember(MemberVO mvo) {


        return null;
    }

    public String removeMember(String name) {


        return null;
    }

    // 회원정보 조회 (아이디, 등급, 가입일)
    public List<MemberVO> readMember() {

        return mdao03.selectMember();
    }

    // 회원정보 조회 (아이디로 검색)
    public MemberVO readOneMember(String userid) {

        return mdao03.selectOneMember(userid);
    }
}
