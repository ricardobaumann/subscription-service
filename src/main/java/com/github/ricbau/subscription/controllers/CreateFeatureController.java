package com.github.ricbau.subscription.controllers;

import com.github.ricbau.subscription.controllers.mappers.PostResultMapper;
import com.github.ricbau.subscription.controllers.results.ResourcePostResult;
import com.github.ricbau.subscription.domain.commands.FeatureCommand;
import com.github.ricbau.subscription.domain.operations.CreateFeatureOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.function.Function;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/features")
public class CreateFeatureController {

    private final CreateFeatureOperation createFeatureOperation;
    private final PostResultMapper postResultMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResourcePostResult post(
            @RequestBody @Valid FeatureCommand featureCommand) {
        return createFeatureOperation.create(featureCommand)
                .map(postResultMapper::toResult)
                .getOrElseThrow(Function.identity());
    }

}
