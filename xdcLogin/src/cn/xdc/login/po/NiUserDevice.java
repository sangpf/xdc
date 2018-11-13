package cn.xdc.login.po;

public class NiUserDevice {
    private Integer userid;

    private String brand;

    private String model;

    private String serialno;

    private String release;

    private String manufacturer;

    private String imei;

    private Byte networkprovider;

    private Byte size;

    private Byte resolution;

    private String comment;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release == null ? null : release.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public Byte getNetworkprovider() {
        return networkprovider;
    }

    public void setNetworkprovider(Byte networkprovider) {
        this.networkprovider = networkprovider;
    }

    public Byte getSize() {
        return size;
    }

    public void setSize(Byte size) {
        this.size = size;
    }

    public Byte getResolution() {
        return resolution;
    }

    public void setResolution(Byte resolution) {
        this.resolution = resolution;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}