package mary.spring.mvc.service;

import mary.spring.mvc.dao.SungJukV12DAO;
import mary.spring.mvc.vo.SungJukVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service("sjsrv13")
public class SungJukV13ServiceImpl implements SungJukV13Service {

    @Autowired
    private SungJukV12DAO sjdao12;

//    public void displayMenu() { 불필요
//        StringBuilder sb = new StringBuilder();
//        sb.append("-------------------\n")
//                .append("성적 처리프로그램 v12\n")
//                .append("-------------------\n")
//                .append("1. 성적 데이터 입력\n")
//                .append("2. 성적 데이터 조회\n")
//                .append("3. 성적 데이터 상세조회\n")
//                .append("4. 성적 데이터 수정\n")
//                .append("5. 성적 데이터 삭제\n")
//                .append("0. 프로그램 종료\n")
//                .append("-------------------\n")
//                .append("원하시는 작업은 ? ");
//        System.out.print(sb);
//    }

    // 입력받은 성적데이터를 처리하고 sungjuk 테이블에 새로운 행으로 추가한 뒤
    // 결과 리턴
    public String newSungJuk(SungJukVO sj) {
//        Scanner sc = new Scanner(System.in);
//        String name;
//        int kor, eng, mat;
//
//        System.out.print("이름을 입력하세요 : ");
//        name = sc.nextLine();
//        System.out.print("국어를 입력하세요 : ");
//        kor = sc.nextInt();
//        System.out.print("영어를 입력하세요 : ");
//        eng = sc.nextInt();
//        System.out.print("수학을 입력하세요 : ");
//        mat = sc.nextInt();
//
//        SungJukVO sj = new SungJukVO(name, kor, eng, mat,
//                0,0,' ');
        computeSungJuk(sj);

        return sjdao12.insertSungJuk(sj);


    }

    public void computeSungJuk(SungJukVO sj) {
        sj.setTot( sj.getKor() + sj.getEng() + sj.getMat() );
        sj.setMean( (double)sj.getTot() / 3 );
        switch((int)(sj.getMean() / 10)) {
            case 10:
            case 9: sj.setGrd('수'); break;
            case 8: sj.setGrd('우'); break;
            case 7: sj.setGrd('미'); break;
            case 6: sj.setGrd('양'); break;
            default: sj.setGrd('가');
        } // switch
    }

    // 조회할 성적데이터를 DAO로부터 넘겨받아 출력
    public List<SungJukVO> readSungJuk() {
//        String fmt = "번호:%s, 이름:%s, 국어:%d, 영어:%d, 수학:%d, 등록일:%s\n";
//        StringBuilder sb = new StringBuilder();
//
//        ArrayList<SungJukVO> sjs =
//            (ArrayList<SungJukVO>) sjdao12.selectSungJuk(); // !!!
//
//        for(SungJukVO sj : sjs) {
//            String result = String.format( fmt, sj.getSjno(),
//                sj.getName(),sj.getKor(),sj.getEng(),sj.getMat(),
//                sj.getRegdate().substring(0,10) );
//            sb.append(result);
//        }
//
//        System.out.println(sb.toString());
        return sjdao12.selectSungJuk();
    }

    public SungJukVO readOneSungJuk(String sjno) {
//        String fmt = "번호:%s, 이름:%s, 국어:%d, 영어:%d, 수학:%d\n" +
//                    "총점:%d, 평균:%.1f, 학점:%s, 등록일:%s\n";
//
//        Scanner sc = new Scanner(System.in);
//        System.out.print("조회할 성적번호는? ");
//        String sjno = sc.nextLine();
//
//        SungJukVO sj = sjdao12.selectOneSungJuk(sjno);
//
//        String result = String.format(fmt, sj.getSjno(),
//                sj.getName(), sj.getKor(), sj.getEng(),
//                sj.getMat(), sj.getTot(), sj.getMean(),
//                sj.getGrd(), sj.getRegdate());
//
//        System.out.println(result);
        return sjdao12.selectOneSungJuk(sjno);
    }

    public String modifySungJuk(SungJukVO sj) {
//        Scanner sc = new Scanner(System.in);
//        SungJukVO sj = new SungJukVO();
//
//        System.out.print("수정할 성적번호는? ");
//        sj.setSjno( sc.nextInt() );
//        System.out.print("수정할 국어점수는? ");
//        sj.setKor( sc.nextInt() );
//        System.out.print("수정할 영어점수는? ");
//        sj.setEng( sc.nextInt() );
//        System.out.print("수정할 수학점수는? ");
//        sj.setMat( sc.nextInt() );
//
//        computeSungJuk(sj);
//
//        String result = sjdao12.updateSungJuk(sj);
//        System.out.println(result);
        computeSungJuk(sj);
        return sjdao12.updateSungJuk(sj);
    }

    public String removeSungJuk(String sjno) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("삭제할 성적번호는? ");
//        int sjno = sc.nextInt();
//
//        String result = sjdao12.deleteSungJuk(sjno);
//        System.out.println(result);
        return sjdao12.deleteSungJuk(Integer.parseInt(sjno));
    }
}
