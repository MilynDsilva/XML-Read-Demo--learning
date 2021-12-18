package com.toreadxmlfile.learning.LearningService;

import com.toreadxmlfile.learning.SomeDTO;

import java.util.List;

public interface LearningIntServicer {
    public List<SomeDTO> getDetails();

    public SomeDTO getDetails(String someDetail);

    public SomeDTO addDetails(SomeDTO someDTO);
}
