package Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class PingCommand {
    public static void execute(SlashCommandInteractionEvent event) {
        event.reply("pong!!!").queue();
    }
}
