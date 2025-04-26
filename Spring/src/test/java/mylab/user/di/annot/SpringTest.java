package mylab.user.di.annot;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di-annot.xml")
public class SpringTest {



    //        UserService 를 주입 받기
    @Autowired
    UserService userService;

    //        UserServiceTest 클래스를 작성하세요.
    @Test
    void userServiceTest(){
        //        UserService의 레퍼런스가 Not Null 인지 검증
        Assertions.assertNotNull(userService);
        //        userService.getRepository() 가 Not Null 인지 검증
        Assertions.assertNotNull(userService.getUserRepository());
        //        userService.getRepository().getDbType() 값이 MySQL 인지 값을 비교하기
        Assertions.assertEquals(userService.getUserRepository().getDbType(), "MySQL");
        //        userService.getSecurityService() 가 Not Null 인지 검증
        Assertions.assertNotNull(userService.getSecurityService());
        //        userService.registerUser() 메서드가 True 인 검증
        System.out.println(userService.registerUser("U001","name", "password"));
    }


}
