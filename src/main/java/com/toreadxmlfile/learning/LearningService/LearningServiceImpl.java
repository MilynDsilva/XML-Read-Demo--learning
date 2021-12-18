package com.toreadxmlfile.learning.LearningService;

import com.toreadxmlfile.learning.SomeDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LearningServiceImpl implements LearningIntServicer {

    List<SomeDTO> list;


    public LearningServiceImpl(){
        //list= new ArrayList<>();
        list=  new ArrayList<>();

        //list.add(1,"jvc","Test");
        //list.add(new SomeDTO("a",""));
        // list.add(new SomeDTO(1,"jvc"));


    }

    @Override
    public List<SomeDTO> getDetails() {
        return list;
    }

    @Override
    public SomeDTO getDetails(String someDetail) {
        SomeDTO c = null;
        //arr trav
        for (SomeDTO someDTO:list) {
            if(someDTO.getLoc()==someDetail)
            {
                c=someDTO;
                break;
            }
        }
        return c;
    }

    @Override
    public SomeDTO addDetails(SomeDTO someDTO) {
        return null;
    }
}