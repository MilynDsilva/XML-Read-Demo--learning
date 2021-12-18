package com.toreadxmlfile.learning.controller;

import com.toreadxmlfile.learning.LearningService.LearningServiceImpl;
import com.toreadxmlfile.learning.LoggingItem;
import com.toreadxmlfile.learning.SomeDTO;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class LearningController {

    @Autowired
    private LearningServiceImpl learningService;
//    //private  priority priority;
    @GetMapping("/home")
    public String home() {
        return ("home");
    }

    @GetMapping("/sitemap")
    public List<SomeDTO> getDetails() {
        return this.learningService.getDetails();
        //should display all xml data
    }


    @GetMapping("/sitemaps")
//    public List<SomeDTO> getDetails() {
//        return this.learningService.getDetails();

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
    @GetMapping("/sitemapss")
        //@Bean
        public ItemWriter<SomeDTO> itemWriter() { return new LoggingItem();
        }
//



    @GetMapping("/sitemap/{loc}")
    public String test1() {
        return ("test");
        //should return details of particular location ie loc and priority
    }
    @PostMapping("/sitemap")
    public String test2() {
        return ("test");
        //should be able update details of particular location ie loc and priority
    }


}



    //get courses
//    @GetMapping("/courses")
//    public List<Course> getCourses()
//    {
//        return this.courseSerivice.getCourses();
//    }
//    @GetMapping("/courses/{courseId}")
//
//    public  Course getCourse(@PathVariable String courseId) //to recieve
//    {
//        return this.courseSerivice.getCourse(Long.parseLong(courseId));
//    }

//    @PostMapping("/courses")
//
////    @PostMapping(path = "/courses",consumes = "application/json")
//    public Course addCourse(@RequestBody Course course)
//    {
//        return this.courseSerivice.addCourse(course);
//    }
//

