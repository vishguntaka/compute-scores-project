package com.company.name;

import com.company.name.service.ComputeNameScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ComputeNamesScore implements CommandLineRunner {

    @Resource(name = "computeNameScoreServiceDelegator" )
    private ComputeNameScoreService computeNameScoresService;

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(ComputeNamesScore.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }

    @Override
    public void run(String... args) throws Exception {
        Assert.notEmpty(args, "No arguments provided");
        System.out.println(computeNameScoresService.computeNameScore(args));

    }
}
