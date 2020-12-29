package com.project.study.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ApiResponse
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
  private Boolean result;
  private String msg;
  private Object data;

}