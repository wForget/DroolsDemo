package cn.wangz.drools;

import cn.wangz.drools.module.Student;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;

/**
 * Created by hadoop on 2018/10/18.
 */
public class DroolsMain {
    public static void main(String[] args) {
        // KieServices is the factory for all KIE services
        KieServices ks = KieServices.Factory.get();

        // From the kie services, a container is created from the classpath
        KieContainer kc = ks.getKieClasspathContainer();

        execute(kc);
    }

    private static void execute(KieContainer kieContainer) {
        // From the container, a session is created based on
        // its definition and configuration in the META-INF/kmodule.xml file
        KieSession ksession = kieContainer.newKieSession("student-rule");

        // The application can also setup listeners
        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.addEventListener(new DebugRuleRuntimeEventListener());

        // To setup a file based audit logger, uncomment the next line
        // KieRuntimeLogger logger = ks.getLoggers().newFileLogger( ksession, "./helloworld" );

        // To setup a ThreadedFileLogger, so that the audit view reflects events whilst debugging,
        // uncomment the next line
        // KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( ksession, "./helloworld", 1000 );

        // The application can insert facts into the session
        Student student1 = new Student("wangz", 17, 69);
        Student student2 = new Student("hel", 19, 85);
        ksession.insert(student1);
        ksession.insert(student2);

        // and fire the rules
        ksession.fireAllRules();

        // Remove comment if using logging
        // logger.close();

        // and then dispose the session
        ksession.dispose();

        System.out.println("name:" + student1.getName() + ", adult:" + student1.getAdult() + ", grade:" + student1.getGrade());
        System.out.println("name:" + student2.getName() + ", adult:" + student2.getAdult() + ", grade:" + student2.getGrade());
    }
}
