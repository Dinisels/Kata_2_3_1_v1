package ms;


import ms.config.SpringConfig;
import ms.dao.UserDao;
import ms.model.User;
import ms.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main_for_test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.addUser(new User(2, "Ivqan", 24, "sadsad@asda.ru"));

        System.out.println(userService.getAllUsers().toString());





    }


}
