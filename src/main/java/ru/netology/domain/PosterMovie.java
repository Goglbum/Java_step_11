package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PosterMovie {
  private int id;
  private String imageURL;
  private String moviName;
  private String genre;
  private boolean premiere;
}
