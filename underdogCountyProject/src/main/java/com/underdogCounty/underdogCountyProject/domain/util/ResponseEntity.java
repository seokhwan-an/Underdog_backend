package com.underdogCounty.underdogCountyProject.domain.util;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ResponseEntity<T>{

  private final Object status;

  private final T body;

}
