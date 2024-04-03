package Listeners;

import Commands.HelpCommand;
import Commands.PingCommand;
import Commands.TicketEmbedCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class SlashCommandInteractListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        switch (event.getName().toLowerCase()) {
            case "ticketembed":
                TicketEmbedCommand.execute(event);
                break;
            case "ping":
                PingCommand.execute(event);
                break;
            case "help":
                event.reply("Sending Help List...").setEphemeral(true).queue();
                HelpCommand.execute(event);
                break;
            default:
                event.reply("This command does not exist.").setEphemeral(true).queue();
        }
    }
}
