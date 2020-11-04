package pl.coderslab;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("pl.coderslab")
@PropertySource("classpath:foo.properties")
public class AppConfig {
}
