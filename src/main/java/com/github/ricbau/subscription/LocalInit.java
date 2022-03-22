package com.github.ricbau.subscription;

import com.github.ricbau.subscription.domain.commands.FeatureCommand;
import com.github.ricbau.subscription.domain.core.FeatureType;
import com.github.ricbau.subscription.domain.services.CreateFeatureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.function.Function;

@Slf4j
@Component
@Profile("local")
@AllArgsConstructor
public class LocalInit implements CommandLineRunner {

    private final CreateFeatureService createFeatureService;

    @Override
    public void run(String... args) {
        createFeatureService.create(
                        new FeatureCommand(FeatureType.GOOD, 10,
                                BigDecimal.valueOf(20.2))
                ).peek(feature -> log.info("Test feature created: {}", feature))
                .getOrElseThrow(Function.identity());
    }
}
