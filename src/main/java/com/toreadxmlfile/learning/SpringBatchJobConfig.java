package com.toreadxmlfile.learning;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SpringBatchJobConfig {
    @Bean
    public ItemReader<SomeDTO> itemReader() {
        Jaxb2Marshaller studentMarshaller = new Jaxb2Marshaller();
        studentMarshaller.setClassesToBeBound(SomeDTO.class);

        return new StaxEventItemReaderBuilder<SomeDTO>()
                .name("newXmlReader")
                .resource(new ClassPathResource("data/xmllearndata.xml"))
                .addFragmentRootElements("url")
                .unmarshaller(studentMarshaller)
                .build();
    }

    @Bean
    public ItemWriter<SomeDTO> itemWriter() { return new LoggingItem();
    }

    @Bean
    public Step exampleJobStep(ItemReader<SomeDTO> reader,
                               ItemWriter<SomeDTO> writer,
                               StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("exampleJobStep")
                .<SomeDTO, SomeDTO>chunk(1)
                .reader(reader)
                .writer(writer)
                .build();
    }

    @Bean
    public Job exampleJob(Step exampleJobStep,
                          JobBuilderFactory jobBuilderFactory) {
        return jobBuilderFactory.get("exampleJob")
                .incrementer(new RunIdIncrementer())
                .flow(exampleJobStep)
                .end()
                .build();
    }
}
