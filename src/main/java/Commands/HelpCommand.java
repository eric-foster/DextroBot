package Commands;

import TicketSystem.util.SelectMenuUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;

public class HelpCommand {
    public static void execute(SlashCommandInteractionEvent event) {
        Member member = event.getMember();
        Member bot = event.getGuild().getMemberById( "1223111199709728838");

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle("Help Commands");
        embedBuilder.setColor(Color.CYAN);
        embedBuilder.setDescription(member.getAsMention() + " --> At this time, there are no available commands for your use. Stay Tuned!!");
        embedBuilder.addField("> For Assistance:", "Please visit <#1224892117818540104> for common questions. If you cannot find your answer, please visit <#1224351115966156951> and open a ticket.", false);
        embedBuilder.setFooter(bot.getUser().getName());
        embedBuilder.setTimestamp(event.getTimeCreated());
        event.getChannel().sendMessageEmbeds(embedBuilder.build()).queue();
    }
}
