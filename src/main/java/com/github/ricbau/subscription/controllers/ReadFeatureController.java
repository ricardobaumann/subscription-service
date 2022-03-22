package com.github.ricbau.subscription.controllers;

import com.github.ricbau.subscription.controllers.mappers.PostResultMapper;
import com.github.ricbau.subscription.controllers.results.FeatureDetails;
import com.github.ricbau.subscription.domain.operations.ReadFeatureOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/features")
public class ReadFeatureController {

    private final ReadFeatureOperation readFeatureOperation;
    private final PostResultMapper postResultMapper;

    @GetMapping("/{id}")
    public ResponseEntity<FeatureDetails> get(@PathVariable String id) {
        return readFeatureOperation.findById(id)
                .map(postResultMapper::toFeatureDetails)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<FeatureDetails> get() {
        return readFeatureOperation.findAll()
                .stream()
                .map(postResultMapper::toFeatureDetails)
                .collect(Collectors.toList());
    }

}
