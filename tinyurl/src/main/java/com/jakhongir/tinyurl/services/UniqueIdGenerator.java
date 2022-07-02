package com.jakhongir.tinyurl.services;

import com.jakhongir.tinyurl.dtos.UniqueIdRequest;
import com.jakhongir.tinyurl.dtos.UniqueIdResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UniqueIdGenerator {
    Optional<UniqueIdResponse> generate(UniqueIdRequest request);
}
