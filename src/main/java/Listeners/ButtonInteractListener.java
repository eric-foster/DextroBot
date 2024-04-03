package Listeners;

import TicketSystem.Button.CloseTicketButton;
import TicketSystem.Button.ConfirmCloseTicketButton;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ButtonInteractListener extends ListenerAdapter {
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        switch (event.getButton().getId().toLowerCase()) {
            case "closeticket":
                CloseTicketButton.execute(event);
                break;
            case "confirmcloseticket":
                ConfirmCloseTicketButton.execute(event);
                break;
        }
    }
}
