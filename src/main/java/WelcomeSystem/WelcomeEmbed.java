package WelcomeSystem;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;

import java.awt.*;

public class WelcomeEmbed {

    public static void execute(GuildMemberJoinEvent event) {
        System.out.println("execute embed event = " + event);
        Member member = event.getMember();
        Role getRole = event.getGuild().getRoleById(1221830842561593396L);
        Member bot = event.getGuild().getMemberById( "1223111199709728838");

        event.getGuild().addRoleToMember(event.getGuild().getMember(member), getRole).queue();

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle("**Welcome to " + event.getGuild().getName() + "**");
        embedBuilder.setColor(new Color(0x1FD4B0));
        embedBuilder.setDescription("A QBCore FiveM Server based in Maricopa and Yavapai County! We are excited for you to begin your journey!");
        embedBuilder.addField("__**Server Info**__", "Here are some notable things about our server:\n- Custom Vehicles\n- Custom Map\n- Custom Scripts\n- Active Admin and Development Team\n- And Much More Fun To Be Had!!!", false);
        embedBuilder.addField("__**Notable Channels**__", "Make sure to visit the following channels:\n \n" + event.getGuild().getGuildChannelById(1221826998499016715L).getAsMention() + " - For a detailed view of our server rules in conjunction with Discord ToS and Policies.\n \n" + event.getGuild().getGuildChannelById(1226199865319751731L).getAsMention() + " - For info on CAD linking and setup.\n \n" + event.getGuild().getGuildChannelById(1221831760040558753L).getAsMention() + " - For general and off-topic chatting.\n \n" + event.getGuild().getGuildChannelById(1226895428688281670L).getAsMention() + " - For in-game photos you would like to showcase.\n \n" + event.getGuild().getGuildChannelById(1224351115966156951L).getAsMention() + " - For any assistance you may need.", false);
        embedBuilder.addField("__**Server Invite Link**__", "In case something happens, or you want ot invite some friends to join you, here is a link to our server: https://discord.gg/G4mN4r5bFM", false);
        embedBuilder.setFooter(bot.getUser().getName(), bot.getAvatarUrl());

        member.getUser().openPrivateChannel().queue(privateChannel -> {
            privateChannel.sendMessage(member.getAsMention()).addEmbeds(embedBuilder.build()).queue();
        });
    }
}
