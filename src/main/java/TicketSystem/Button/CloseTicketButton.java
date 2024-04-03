package TicketSystem.Button;

import TicketSystem.util.ButtonUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

import java.awt.*;

public class CloseTicketButton {
    public static void execute(ButtonInteractionEvent event) {
        String authorIconUrl = event.getMessage().getAuthor().getAvatarUrl();

        event.deferEdit().queue();
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setAuthor(event.getMessage().getAuthor().getName(), authorIconUrl, authorIconUrl);
        embedBuilder.setTitle("Confirm Closing Ticket");
        embedBuilder.setColor(Color.RED);
        embedBuilder.setDescription("> Are you sure you want to close this ticket?");
        embedBuilder.setFooter(event.getMessage().getAuthor().getName(), authorIconUrl);
        embedBuilder.setTimestamp(event.getTimeCreated());
        event.getChannel().sendMessageEmbeds(embedBuilder.build()).setActionRow(ButtonUtil.confirmCloseTicket()).queue();
    }
}
