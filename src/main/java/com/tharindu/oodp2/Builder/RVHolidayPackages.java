package com.tharindu.oodp2.Builder;

class HolidayPackages {
    private final String flight;
    private final String hotel;
    private final boolean airportPickup;
    private final boolean sightseeingTours;
    private final boolean travelInsurance;

    public HolidayPackages(HolidayPkgBuilder builder) {
        this.flight = builder.getFlight();
        this.hotel = builder.getHotel();
        this.airportPickup = builder.isAirportPickup();
        this.sightseeingTours = builder.isSightseeingTours();
        this.travelInsurance = builder.isTravelInsurance();
    }

    public void showDetails() {
        StringBuilder sb = new StringBuilder()
                .append("🏖️ Holiday Package:\n")
                .append("  • Flight: ").append(flight).append("\n")
                .append("  • Hotel: ").append(hotel).append("\n");
        if (airportPickup) sb.append("  ✔ Airport pickup\n");
        if (sightseeingTours) sb.append("  ✔ Sightseeing tours\n");
        if (travelInsurance) sb.append("  ✔ Travel insurance\n");
        System.out.println(sb);
    }
}

class HolidayPkgBuilder{
    // required parameters
    private String flight;
    private String hotel;
    // optional parameters
    private boolean airportPickup;
    private boolean sightseeingTours;
    private boolean travelInsurance;

    public String getFlight() {
        return flight;
    }

    public HolidayPkgBuilder setFlight(String flight) {
        this.flight = flight;
        return this;
    }

    public HolidayPkgBuilder setHotel(String hotel) {
        this.hotel = hotel;
        return this;
    }

    public String getHotel() {
        return hotel;
    }

    public boolean isAirportPickup() {
        return airportPickup;
    }

    public HolidayPkgBuilder setAirportPickup(boolean airportPickup) {
        this.airportPickup = airportPickup;
        return this;
    }

    public boolean isSightseeingTours() {
        return sightseeingTours;
    }

    public HolidayPkgBuilder setSightseeingTours(boolean sightseeingTours) {
        this.sightseeingTours = sightseeingTours;
        return this;
    }

    public boolean isTravelInsurance() {
        return travelInsurance;
    }

    public HolidayPkgBuilder setTravelInsurance(boolean travelInsurance) {
        this.travelInsurance = travelInsurance;
        return this;
    }
    public HolidayPackages build() {
        return new HolidayPackages(this);
    }
}

public class RVHolidayPackages {
    public static void main(String[] args) {
HolidayPackages tours = new HolidayPkgBuilder()
        .setFlight("Flight to the Maldives")
        .setHotel("Beach Resort")
        .setAirportPickup(true)
        .setSightseeingTours(true)
        .setTravelInsurance(true).build();

        tours.showDetails();
    }
}

// Output:
// 🏖️ Holiday Package:
//   • Flight: Flight to the Maldives
//   • Hotel: Beach Resort
//  ✔ Airport pickup
//   ✔ Sightseeing tours
//   ✔ Travel insurance