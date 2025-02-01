package dev.wayron.nobsv2_exam.product.model;


public enum Region {
    UNITED_STATES("USA"),
    CANADA("CAN"),
    BRAZIL("BRA");

    private final String region;

    Region(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

}
