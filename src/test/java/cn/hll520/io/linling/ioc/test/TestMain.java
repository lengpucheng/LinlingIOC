package cn.hll520.io.linling.ioc.test;

import cn.hll520.io.linling.LinLingApplicationMain;
import cn.hll520.io.linling.ioc.annotation.AutoInject;
import cn.hll520.io.linling.ioc.annotation.Control;
import cn.hll520.io.linling.ioc.container.ApplicationContainer;
import cn.hll520.io.linling.ioc.container.ApplicationDeploymentStart;
import cn.hll520.io.linling.ioc.test.ioc_1.Person;
import cn.hll520.io.linling.ioc.test.ioc_1.Student;

import java.util.Arrays;

/**
 * @author lpc
 * @version 1.0  2020-11-27-10:40
 * @since 2020-11-27-10:40
 * 描述： 主要测试入口
 */
@Control()
public class TestMain {

//        @AutoInject
    static Student student;


    public static void main(String... args) {
        ApplicationDeploymentStart applicationDeploymentStart = new ApplicationDeploymentStart(LinLingApplicationMain.class);
        applicationDeploymentStart.run(args);
//        student.say();
        System.out.println("out");
        System.out.println();
        System.out.println(Student.class.getName());
        Person person= (Person) applicationDeploymentStart.getApplicationContainer().getContainer().get(Student.class.getName());
        person.say();

        System.out.println(person.getAge());

        System.out.println(person.call(1302));

    }
}

