package TicketSystem.SelectMenu.Options;

import TicketSystem.util.TicketUtil;
import TicketSystem.util.TicketType;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;

public class TechSupportOption {
    public static void execute(StringSelectInteractionEvent event) {
        TicketUtil.open(TicketType.TECHSUPPORT, event);
    }
}
