package ua.lviv.iot.lab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Column;

@Entity
public  class AbstractGoodsForCreativity {
  @Column
  private String name;
  @Column
  private KindOfProduct kindOfProduct;
  @Column
  private double priceInUAH;
  @Column
  private String countryOfProducing;
  @Column
  private int minimumAgeForUsing;
  @Column
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

  public AbstractGoodsForCreativity(String name, KindOfProduct kind, double priceInUAH, String countryOfProducing,
      int minimumAgeForUsing) {
    super();
    this.name = name;
    this.kindOfProduct = kind;
    this.priceInUAH = priceInUAH;
    this.countryOfProducing = countryOfProducing;
    this.minimumAgeForUsing = minimumAgeForUsing;
  }

  public String getHeaders() {
    return "name," + "kind," + "priceInUAH," + "countryOfProducing," + "minimumAgeForUsing";

  }

  public String toCSV() {
    return getName() + "," + getKind() + "," + getPriceInUAH() + "," + getCountryOfProducing() + ","
        + getMinimumAgeForUsing();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public KindOfProduct getKind() {
    return kindOfProduct;
  }

  public void setKind(KindOfProduct kind) {
    this.kindOfProduct = kind;
  }

  public double getPriceInUAH() {
    return priceInUAH;
  }

  public void setPriceInUAH(double priceInUAH) {
    this.priceInUAH = priceInUAH;
  }

  public String getCountryOfProducing() {
    return countryOfProducing;
  }

  public void setCountryOfProducing(String countryOfProducing) {
    this.countryOfProducing = countryOfProducing;
  }

  public int getMinimumAgeForUsing() {
    return minimumAgeForUsing;
  }

  public void setMinimumAgeForUsing(int minimumAgeForUsing) {
    this.minimumAgeForUsing = minimumAgeForUsing;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AbstractGoodsForCreativity() {
    super();
  }

}
