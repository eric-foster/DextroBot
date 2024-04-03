package TicketSystem.util;

public enum TicketType {
    GENERALSUPPORT,
    TECHSUPPORT,
    BANAPPEAL;

    private static TicketType ticketType;

    public static void setTicketType(TicketType ticketType) {
        TicketType.ticketType = ticketType;
    }

    public static TicketType getTicketType() {
        return ticketType;
    }
}
