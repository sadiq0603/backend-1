package com.sloms.controller;

import com.sloms.repository.AssessmentRepository;
import com.sloms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AssessmentRepository assessmentRepository;

    @GetMapping("/stats")
    public Map<String, Object> getOverallStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalStudents", studentRepository.count());
        stats.put("totalAssessments", assessmentRepository.count());
        // Simple average calculation would go here if needed
        return stats;
    }

    @GetMapping("/student/{studentId}")
    public Map<String, Object> getStudentStats(@PathVariable Long studentId) {
        Map<String, Object> stats = new HashMap<>();
        // Fetch specific student stats
        return stats;
    }
}
