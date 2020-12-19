package com.example.backend.api;

import com.example.backend.models.Activity;
import com.example.backend.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ActivityApi {

    @Autowired
    ActivityRepository activityRepository;

    @GetMapping("/getactivities")
    public ResponseEntity<List<Activity>> findAll(){
        List<Activity> activities= activityRepository.findAll();
        return new ResponseEntity<>(activities,new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/addactivity")
    public ResponseEntity<Activity> saveActivity(Activity activity){
        Activity activity1 = activityRepository.save(activity);
        return new ResponseEntity<>(activity1,new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/updateactivity/{email:.+")
    public ResponseEntity<Activity> updateActivity(Activity activity, @PathVariable String email){
        Optional<Activity> activity1 = activityRepository.findByEmail(email);
        if(activity1.isPresent()){
            Activity newActivity = activity1.get();
            newActivity.setActivity(activity.getActivity());
            return new ResponseEntity<>(activityRepository.save(newActivity), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
