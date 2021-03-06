package com.example.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "languages")
public class LanguageEntity implements Serializable {

  @Id
  private UUID id;

  @NotEmpty
  private String name;

  @ManyToMany(targetEntity=CountryEntity.class)
  @Column(table = "languages_countries", name="spoken_countries")
  private List<CountryEntity> spokenCountries;

  public LanguageEntity() {

  }

  public LanguageEntity(UUID id, String name){
    this.id = id;
    this.name = name;
    this.spokenCountries = new ArrayList<>();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<CountryEntity> getSpokenCountries() {
    return spokenCountries;
  }

  public void setSpokenCountries(List<CountryEntity> spokenCountries) {
    this.spokenCountries = spokenCountries;
  }
}
