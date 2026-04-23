package com.sloms.controller;

import com.sloms.model.Assessment;
import com.sloms.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentRepository assessmentRepository;

    @GetMapping
    public List<Assessment> getAllAssessments() {
        return assessmentRepository.findAll();
    }

    @GetMapping("/student/{studentId}")
    public List<Assessment> getAssessmentsByStudent(@PathVariable Long studentId) {
        return assessmentRepository.findByStudentId(studentId);
    }

    @PostMapping
    public Assessment createAssessment(@RequestBody Assessment assessment) {
        return assessmentRepository.save(assessment);
    }
}
