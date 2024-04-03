package Commands;

import TicketSystem.util.SelectMenuUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;

public class TicketEmbedCommand {
    public static void execute(SlashCommandInteractionEvent event) {
        Member member = event.getMember();
        Member bot = event.getGuild().getMemberById( "1223111199709728838");

        assert member != null;
        if (member.getPermissions().contains(Permission.ADMINISTRATOR)) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Support Center");
            embedBuilder.setColor(Color.blue);
            embedBuilder.setDescription("Please review <#1224892117818540104> before continuing to open a ticket.");
            embedBuilder.addField("> General Support", "`For all general assistance such as questions or concerns.`", false);
            embedBuilder.addField("> Technical Support", "`For technical assistance regarding in-game functionality or issues with discord in server functionality such as channel issues or bot issues.`", false);
            embedBuilder.addField("> Ban Appeals", "`For those who would like to speak with management about their ban appeal.`", false);
            embedBuilder.setFooter(bot.getUser().getName());
            embedBuilder.setTimestamp(event.getTimeCreated());
            event.getChannel().sendMessageEmbeds(embedBuilder.build()).setActionRow(SelectMenuUtil.ticketSelect()).queue();
            event.reply("Embed was sent...").setEphemeral(true).queue();
            return;
        }
        event.reply("You don't have permission to perform this.").setEphemeral(true).queue();
    }
}
