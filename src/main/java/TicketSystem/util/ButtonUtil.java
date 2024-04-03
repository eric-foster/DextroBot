package TicketSystem.util;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class ButtonUtil {
    public static Button closeTicket() {
        return Button.danger("closeTicket", "Close the Ticket");
    }

    public static Button confirmCloseTicket() {
        return Button.danger("confirmCloseTicket", "Confirm Closing");
    }
}
