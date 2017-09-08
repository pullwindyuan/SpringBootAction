package nuc.jyg.chapter6;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;

@SpringBootApplication
@Controller
public class Chapter6Application {

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(Chapter6Application.class, args);
	}

	@Bean(destroyMethod = "shutdown")
	public DataSource dataSource() {
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setJdbcUrl(environment.getProperty("spring.datasource.hikari.jdbc-url"));
		hikariDataSource.setUsername(environment.getProperty("spring.datasource.hikari.username"));
		hikariDataSource.setPassword(environment.getProperty("spring.datasource.hikari.password"));
		hikariDataSource.setMaximumPoolSize(Integer.parseInt(environment.getProperty("spring.datasource.hikari.maximum-pool-size")));
		hikariDataSource.setMinimumIdle(Integer.parseInt(environment.getProperty("spring.datasource.hikari.minimum-idle")));
		hikariDataSource.setConnectionTestQuery(environment.getProperty("spring.datasource.hikari.connection-test-query"));
		hikariDataSource.setIdleTimeout(Long.parseLong(environment.getProperty("spring.datasource.hikari.idle-timeout")));
		hikariDataSource.setMaxLifetime(Long.parseLong(environment.getProperty("spring.datasource.hikari.max-lifetime")));
		hikariDataSource.setConnectionTimeout(Long.parseLong(environment.getProperty("spring.datasource.hikari.connection-timeout")));
		return hikariDataSource;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String add() {
		return "add";
	}

/*    @RequestMapping(path = "/update", method = RequestMethod.GET)
    public String update() {
        return "update";
    }*/
}
