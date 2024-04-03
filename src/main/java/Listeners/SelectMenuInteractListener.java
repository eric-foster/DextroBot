package Listeners;

import TicketSystem.SelectMenu.TicketSelect_SelectMenu;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class SelectMenuInteractListener extends ListenerAdapter {
    @Override
    public void onStringSelectInteraction(@NotNull StringSelectInteractionEvent event) {
        switch (event.getSelectMenu().getId().toLowerCase()) {
            case "ticketselect":
                TicketSelect_SelectMenu.execute(event);
                break;
            default:
                event.reply("This selectmenu does not exist.").setEphemeral(true).queue();
        }
    }
}
