package gov.mois.kais;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppStartupRunner implements ApplicationRunner {

    @Value("${common}")
    private String common;

    @Value("${test}")
    private String test;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("AppStartupRunner run start");
        System.out.println("common = " + common);
        System.out.println("test = " + test);
    }
}
