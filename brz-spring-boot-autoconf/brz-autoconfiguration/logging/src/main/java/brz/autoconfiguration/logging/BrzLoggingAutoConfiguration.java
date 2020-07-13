package brz.autoconfiguration.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import brz.autoconfiguration.library.logging.LoggableAspect;

@Configuration
@ConditionalOnClass(LoggableAspect.class)
@EnableConfigurationProperties(BrzLoggingProperties.class)
public class BrzLoggingAutoConfiguration {
	
	@Autowired
	private BrzLoggingProperties properties;

	@Bean
	public LoggableAspect loggableAspect() {
		return new LoggableAspect(properties.getLoggerName());
	}
}
