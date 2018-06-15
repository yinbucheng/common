package cn.intellif.bucheng.common;

import cn.intellif.bucheng.common.annotation.EnableLoggerConfiguration;
import cn.intellif.bucheng.common.annotation.PrintArgsDetail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLoggerConfiguration
public class CommonApplication {
	public static void main(String[] args) {
		SpringApplication.run(CommonApplication.class, args);
	}
}
