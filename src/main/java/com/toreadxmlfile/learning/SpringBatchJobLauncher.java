package com.toreadxmlfile.learning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class SpringBatchJobLauncher {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBatchJobLauncher.class);

    private final Job job;
    private final JobLauncher jobLauncher;

    @Autowired
    public SpringBatchJobLauncher(Job job, JobLauncher jobLauncher) {
        this.job = job;
        this.jobLauncher = jobLauncher;
    }

    @Scheduled(cron = "0/10 * * * * *")
    //@Scheduled(cron = "0 0 8,10 * * *")
    public void runSpringBatchExampleJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        LOGGER.info("Spring Batch job was started");

        jobLauncher.run(job, newExecution());

        LOGGER.info("Spring Batch job was stopped");
    }

    private JobParameters newExecution() {
        Map<String, JobParameter> parameters = new HashMap<>();

        JobParameter parameter = new JobParameter(new Date());
        parameters.put("currentTime", parameter);

        return new JobParameters(parameters);
    }
}

//* "0 0 * * * *" = the top of every hour of every day.
//        * "*/10 * * * * *" = every ten seconds.
//        * "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
//        * "0 0 8,10 * * *" = 8 and 10 o'clock of every day.
//        * "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
//        * "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
//        * "0 0 0 25 12 ?" = every Christmas Day at midnight

//https://stackoverflow.com/questions/26147044/spring-cron-expression-for-every-day-101am