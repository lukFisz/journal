package luk.fisz.journal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

import static luk.fisz.journal.common.definition.AppBean.APP_ASYNC_EXEC;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = APP_ASYNC_EXEC)
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("Journal-AppAsyncThread-");
        executor.initialize();
        return executor;
    }

}
