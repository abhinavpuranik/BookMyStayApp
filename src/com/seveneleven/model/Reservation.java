/*
 * @author Developer
 * @version 3.0
 * Reservation Model
 */

package com.seveneleven.model;

public class Reservation {

    private String guestName;
    private String roomType;
    private long requestTime;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.requestTime = System.currentTimeMillis();
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public long getRequestTime() {
        return requestTime;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName +
               " | Room: " + roomType +
               " | Request Time: " + requestTime;
    }
}