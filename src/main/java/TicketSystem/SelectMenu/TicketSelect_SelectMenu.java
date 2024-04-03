package TicketSystem.SelectMenu;

import TicketSystem.SelectMenu.Options.BanApealOption;
import TicketSystem.SelectMenu.Options.GeneralSupportOption;
import TicketSystem.SelectMenu.Options.TechSupportOption;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;

public class TicketSelect_SelectMenu {
    public static void execute(StringSelectInteractionEvent event) {
        switch (event.getValues().getFirst().toLowerCase()) {
            case "general support":
                GeneralSupportOption.execute(event);
                break;
            case "technical support":
                TechSupportOption.execute(event);
                break;
            case "ban appeal":
                BanApealOption.execute(event);
                break;
            default:
                event.reply("This selectmenu option does not exist.").setEphemeral(true).queue();
        }
    }
}
