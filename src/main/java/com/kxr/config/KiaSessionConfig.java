package com.kxr.config;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

@Configuration
public class KiaSessionConfig {

    private static final String RULES_PATH = "rules/";

    @Bean
    public KieFileSystem kieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = getKieServices().newKieFileSystem();
        for (Resource file : getRuleFiles()) {
            kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_PATH + file.getFilename(), "UTF-8"));
        }
        return kieFileSystem;
    }

    private Resource[] getRuleFiles() throws IOException {

        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        final Resource[] resources = resourcePatternResolver.getResources("classpath*:" + RULES_PATH + "**/*.*");
        return resources;

    }


    @Bean
    public KieContainer kieContainer() throws IOException {
        System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm:ss");
        final KieRepository kieRepository = getKieServices().getRepository();
        kieRepository.addKieModule(new KieModule() {
            public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });

        KieBuilder kieBuilder = getKieServices().newKieBuilder(kieFileSystem());
        kieBuilder.buildAll();
        return getKieServices().newKieContainer(kieRepository.getDefaultReleaseId());

    }

    private KieServices getKieServices() {
        return KieServices.Factory.get();
    }

    @Bean
    public KieBase kieBase() throws IOException {
        return kieContainer().getKieBase();
    }


    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public KieSession kieSession() throws IOException {
        return kieContainer().newKieSession();
    }

// 从maven仓库中加载规则文件
//    @Bean
//    public KieContainer kieContainer() throws IOException {
//        System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm:ss");
//        final KieRepository kieRepository = getKieServices().getRepository();
//        kieRepository.addKieModule(new KieModule() {
//            public ReleaseId getReleaseId() {
//                return kieRepository.getDefaultReleaseId();
//            }
//        });
//
//        KieBuilder kieBuilder = getKieServices().newKieBuilder(kieFileSystem());
//        kieBuilder.buildAll();
//        KieServices kieServices = getKieServices();
//        ReleaseId releaseId = kieServices.newReleaseId("com.example", "my-rules", "1.0.0");
//        KieContainer kieContainer = kieServices.newKieContainer(releaseId);
//        KieScanner kieScanner = kieServices.newKieScanner(kieContainer);
//        kieScanner.start(10000); // 扫描间隔时间，单位毫秒
//
//        return kieContainer;
//    }
}
