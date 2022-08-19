package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import shop.Repository.MemberRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.Repository.MemberRepository;

import javax.sql.DataSource;
//
@Configuration
//@ComponentScan
public class SpringConfig {
//    @Autowired
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
        return new MemberRepositoryImpl(dataSource);
    }

}