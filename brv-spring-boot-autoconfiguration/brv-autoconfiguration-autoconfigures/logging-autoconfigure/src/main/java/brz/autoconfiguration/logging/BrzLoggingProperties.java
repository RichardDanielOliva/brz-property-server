package brz.autoconfiguration.logging;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("beeto.logging")
public class BrzLoggingProperties {
	private String loggerName= "BeetoAuditLogger";

	public String getLoggerName() {
		return loggerName;
	}

	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}
	
}
