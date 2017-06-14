package com.domain.config;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.NCSARequestLog;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("unused")
public class ApplicationConfig {

    public static final String ACCESS_LOG_FILENAME = "./log/access-yyyy_mm_dd.log";

    @Bean
    public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
        JettyEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory
                = new JettyEmbeddedServletContainerFactory();

        jettyEmbeddedServletContainerFactory.addServerCustomizers((JettyServerCustomizer) jettyServerCustomizer -> {
            HandlerCollection handlers = new HandlerCollection();
            for (Handler handler : jettyServerCustomizer.getHandlers()) {
                handlers.addHandler(handler);
            }
            RequestLogHandler requestLogHandler = new RequestLogHandler();
            NCSARequestLog requestLog = new NCSARequestLog(ACCESS_LOG_FILENAME);
            requestLog.setRetainDays(30);
            requestLog.setAppend(true);
            requestLog.setExtended(false);
            requestLog.setLogTimeZone("GMT");
            requestLogHandler.setRequestLog(requestLog);
            handlers.addHandler(requestLogHandler);
            jettyServerCustomizer.setHandler(handlers);
        });
        return jettyEmbeddedServletContainerFactory;
    }
}
