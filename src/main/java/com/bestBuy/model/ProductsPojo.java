package com.bestBuy.model;

public class ProductsPojo {

    /* {
      "id": 333179,
      "name": "Energizer - N Cell E90 Batteries (2-Pack)",
      "type": "HardGood",
      "price": 5.99,
      "upc": "039800013200",
      "shipping": 0,
      "description": "Alkaline batteries; 1.5V",
      "manufacturer": "Energizer",
      "model": "E90BP-2",
      "url": "http://www.bestbuy.com/site/energizer-n-cell-e90-batteries-2-pack/333179.p?id=1185268509951&skuId=333179&cmp=RMXCC",
      "image": "http://img.bbystatic.com/BestBuy_US/images/products/3331/333179_sa.jpg",
      "createdAt": "2016-11-17T17:58:03.298Z",
      "updatedAt": "2016-11-17T17:58:03.298Z",
      "categories": [

        }*/

    private String name;
    private String type;
     private double price;
    private String upc;
    private int shipping;
    private String description;
    private String manufacturer;
    private String model;
    private String url;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public int getShipping() {
        return shipping;
    }

    public void setShipping(int shipping) {
        this.shipping = shipping;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
