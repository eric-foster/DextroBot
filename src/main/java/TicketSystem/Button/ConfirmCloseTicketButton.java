package TicketSystem.Button;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class ConfirmCloseTicketButton {
    public static void execute(ButtonInteractionEvent event) {
        TextChannel textChannel = event.getChannel().asTextChannel();
        Category gsCategory = event.getGuild().getCategoryById("1224899651782705216");
        Category tsCategory = event.getGuild().getCategoryById("1224533180648919121");
        Category baCategory = event.getGuild().getCategoryById("1224899788793712650");
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
        String channelOwner = textChannel.getName().split("-")[1];
        textChannel.getMemberPermissionOverrides().forEach(permissionOverride -> permissionOverride.delete().queue());


        switch (ticketType.toLowerCase()) {
            case "gs":
                textChannel.getManager().setName("C-GS-" + channelOwner).setParent(gsCategory).queueAfter(3, TimeUnit.SECONDS);
                break;
            case "ts":
                textChannel.getManager().setName("C-TS-" + channelOwner).setParent(tsCategory).queueAfter(3, TimeUnit.SECONDS);
                break;
            default:
                textChannel.getManager().setName("C-BA-" + channelOwner).setParent(baCategory).queueAfter(3, TimeUnit.SECONDS);
                break;
        }
    }
}
