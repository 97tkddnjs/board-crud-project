package board.apiproject;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import shop.Repository.MemberRepositoryImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import shop.Repository.MemberRepository;
////import org.apache.tomcat.jdbc.pool.DataSource;
//
//import javax.sql.DataSource;
////
//@Configuration
////@ComponentScan
//public class SpringConfig {
//
//    private final DataSource dataSource;
//
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//
//    @Bean
//    public MemberRepository memberRepository() {
//// return new MemoryMemberRepository();
//        return new MemberRepositoryImpl(dataSource);
//    }
//
//}

//@Configuration
//@ComponentScan
public class SpringConfig {


    //    jdbc에서 필요한 것들
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }



    //jpa에 필요한 것들
//    private final DataSource dataSource;
//    private final EntityManager em;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }
    //spring jpa

//    private final MemberRepository memberRepository;

    //    @Autowired // 생성자가 하나면 생략되도 되긴 하다.
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//    //jpa 까진
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
    //    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository);
//    }
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
//    @Bean
//    public MemberRepository memberRepository() {
//        //return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//
//    }
}