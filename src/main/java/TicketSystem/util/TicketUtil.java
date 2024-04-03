package TicketSystem.util;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;

import java.awt.*;
import java.util.EnumSet;

public class TicketUtil {
    public static void open(TicketType ticketType, StringSelectInteractionEvent event) {
        event.reply("Creating ticket...").setEphemeral(true).queue();

        event.getInteraction().editSelectMenu(SelectMenuUtil.ticketSelect()).queue();

        Guild guild = event.getGuild();
        Member member = event.getMember();
        String authorIconUrl = event.getMessage().getAuthor().getAvatarUrl();
        Category category = event.getGuild().getCategoryById("1224200360231571467");
        Role moderator = guild.getRoleById("1221828926813503558");
        Role TechSupport = guild.getRoleById("1224528342443888721");
        EnumSet<Permission> viewChannelPermission = EnumSet.of(Permission.VIEW_CHANNEL);

        String ticketTypeStr = "";
        String ticketName = "";

        switch(ticketType) {
            case GENERALSUPPORT:
                ticketTypeStr = "GS";
                ticketName = "General Support";
                break;
            case TECHSUPPORT:
                ticketTypeStr = "TS";
                ticketName = "Technical Support";
                break;
            case BANAPPEAL:
                ticketTypeStr = "BA";
                ticketName = "Ban Appeal";
                break;
            default:
                member.getUser().openPrivateChannel().complete().sendMessage("Error: Please contact an admin...").queue();
                return;
        }

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setAuthor(event.getMessage().getAuthor().getName(), authorIconUrl, authorIconUrl);
        embedBuilder.setTitle(ticketName);
        embedBuilder.setColor(Color.GREEN);
        embedBuilder.setDescription("```Please describe how we can assist you.```");
        embedBuilder.setFooter(event.getMessage().getAuthor().getName(), authorIconUrl);
        embedBuilder.setTimestamp(event.getTimeCreated());

        switch (ticketTypeStr) {
            case "GS":
                guild.createTextChannel(ticketTypeStr + "-" + member.getUser().getName(), category)
                        .addPermissionOverride(member, viewChannelPermission, null)
                        .addPermissionOverride(guild.getPublicRole(), null, viewChannelPermission)
                        .addPermissionOverride(moderator, viewChannelPermission, null)
                        .flatMap(channel -> channel.sendMessage("<@&1221828926813503558> <@&1221828581944983704> ---- " + member.getAsMention()).addEmbeds(embedBuilder.build()).setActionRow(ButtonUtil.closeTicket()))
                        .queue();
                break;
            case "TS":
                guild.createTextChannel(ticketTypeStr + "-" + member.getUser().getName(), category)
                        .addPermissionOverride(member, viewChannelPermission, null)
                        .addPermissionOverride(guild.getPublicRole(), null, viewChannelPermission)
                        .addPermissionOverride(TechSupport, viewChannelPermission, null)
                        .flatMap(channel -> channel.sendMessage("<@&1224528342443888721> ---- " + member.getAsMention()).addEmbeds(embedBuilder.build()).setActionRow(ButtonUtil.closeTicket()))
                        .queue();
                break;
            default:
                guild.createTextChannel(ticketTypeStr + "-" + member.getUser().getName(), category)
                        .addPermissionOverride(member, viewChannelPermission, null)
                        .addPermissionOverride(guild.getPublicRole(), null, viewChannelPermission)
                        .flatMap(channel -> channel.sendMessage("<@&1221828581944983704> <@&1221827311595163648> ---- " + member.getAsMention()).addEmbeds(embedBuilder.build()).setActionRow(ButtonUtil.closeTicket()))
                        .queue();
                break;
        }
    }
}
