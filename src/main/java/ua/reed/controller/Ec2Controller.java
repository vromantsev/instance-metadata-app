package ua.reed.controller;

import ua.reed.service.InstanceMetadataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/instance")
@RestController
public class Ec2Controller {

    private final InstanceMetadataService instanceMetadataService;

    public Ec2Controller(InstanceMetadataService instanceMetadataService) {
        this.instanceMetadataService = instanceMetadataService;
    }

    @GetMapping("/stats")
    public ResponseEntity<String> getInstanceStats() {
        return ResponseEntity.ok()
                .body(instanceMetadataService.getInstanceMetadata().asString());
    }

    @GetMapping("/stats/{tagId}")
    public ResponseEntity<?> getTagMetadata(@PathVariable("tagId") final String tagId) {
        return ResponseEntity.ok()
                .body(instanceMetadataService.getInstanceMetadataTag(tagId));
    }

    @GetMapping("/health")
    public String getHealth() {
        return "App is healthy!";
    }

}
