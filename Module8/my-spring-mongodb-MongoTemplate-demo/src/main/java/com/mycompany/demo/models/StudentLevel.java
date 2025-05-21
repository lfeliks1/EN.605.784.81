package com.mycompany.demo.models;

import lombok.Getter;

@Getter
public enum StudentLevel {
  UNDERGRADUATE("undergraduate"),
  GRADUATE("graduate"),
  POSTGRADUATE("postgraduate");

  private final String level;

  StudentLevel(String level) {
    this.level = level;
  }
}