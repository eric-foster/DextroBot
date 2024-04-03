package Listeners;

import WelcomeSystem.WelcomeEmbed;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class GuildJoinListener extends ListenerAdapter {
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        System.out.println("OnGuildJoin Method event = " + event);
        WelcomeEmbed.execute(event);
    }
}
