package com.github.ricbau.subscription.controllers.results;

import lombok.Value;

import java.net.URI;

@Value
public class ResourcePostResult {
    String id;
    URI location;
}
