package TicketSystem.Button;

import TicketSystem.util.Transcripts;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

import java.awt.*;
import java.util.List;

public class ConfirmCloseTicketButton {
    public static void execute(ButtonInteractionEvent event) {
        TextChannel textChannel = event.getChannel().asTextChannel();
        List<Message> messages = textChannel.getIterableHistory().reverse().complete();
        String authorIconUrl = event.getMessage().getAuthor().getAvatarUrl();

        event.deferEdit().queue();
        event.getMessage().delete().queue();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setAuthor(event.getMessage().getAuthor().getName(), authorIconUrl, authorIconUrl);
        embedBuilder.setTitle("Closed");
        embedBuilder.setColor(Color.RED);
        embedBuilder.setDescription("This ticket is closed.");
        embedBuilder.setFooter(event.getMessage().getAuthor().getName(), authorIconUrl);
        embedBuilder.setTimestamp(event.getTimeCreated());

        textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
        String ticketType = textChannel.getName().split("-")[0];
        textChannel.getMemberPermissionOverrides().forEach(permissionOverride -> permissionOverride.delete().queue());
        Transcripts.createTranscript(event, ticketType, messages);
    }
}
