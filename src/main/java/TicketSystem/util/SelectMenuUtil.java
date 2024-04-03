package TicketSystem.util;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

public class SelectMenuUtil {
    public static StringSelectMenu ticketSelect() {
        StringSelectMenu selectMenu = StringSelectMenu.create("ticketSelect")
                .addOption(
                        "General Support",
                        "General Support",
                        "Select this option if you need general assistance."
                )
                .addOption(
                        "Technical Support",
                        "Technical Support",
                        "Select this option if you need Technical assistance."
                )
                .addOption(
                        "Ban Appeal",
                        "Ban Appeal",
                        "Select this option if you need Owner assistance."
                )
                .build();

        return selectMenu;
    }
}
