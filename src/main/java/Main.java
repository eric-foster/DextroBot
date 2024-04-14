import Listeners.ButtonInteractListener;
import Listeners.GuildJoinListener;
import Listeners.SelectMenuInteractListener;
import Listeners.SlashCommandInteractListener;
import Token.Token;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main {
    public static void main(String[] args) {
        Token TOKEN = new Token();
        JDA jda = JDABuilder.createDefault(TOKEN.getTOKEN())
                .disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOJI, CacheFlag.STICKER)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.customStatus("Assisting the Management Team."))
                .addEventListeners(new ButtonInteractListener())
                .addEventListeners(new GuildJoinListener())
                .addEventListeners(new SelectMenuInteractListener())
                .addEventListeners(new SlashCommandInteractListener())
                .build();

        CommandListUpdateAction commands = jda.updateCommands();
        commands.addCommands(
                Commands.slash("ticketembed", "Sends the ticket embed in the channel."),
                Commands.slash("ping", "You say ping, I say pong!!!"),
                Commands.slash("help", "A Help Panel for your convenience.")
        ).queue();
    }
}
