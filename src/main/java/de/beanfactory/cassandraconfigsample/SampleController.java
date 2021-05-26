package de.beanfactory.cassandraconfigsample;

import de.beanfactory.cassandraconfigsample.cassandra.model.Person;
import de.beanfactory.cassandraconfigsample.feature.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SampleController {

    private FeatureService featureService;

    @Autowired
    public SampleController(FeatureService featureService) {
        this.featureService = featureService;
    }


    @GetMapping(path="persons")
    public List<Person> persons() {
        return featureService.findAll().collect(Collectors.toList());
    }
}
