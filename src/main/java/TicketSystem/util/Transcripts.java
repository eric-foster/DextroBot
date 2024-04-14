package TicketSystem.util;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Transcripts {
    public static void createTranscript(ButtonInteractionEvent event, String ticketType, List<Message> messages) {
        TextChannel channel = event.getChannel().asTextChannel();

        try {
            switch (ticketType.toLowerCase()) {
                case "gs":
                    File gsTranscriptFile = new File("src/main/java/TicketSystem/transcripts/GS_transcript.txt");
                    writeToTranscript(gsTranscriptFile, messages);
                    MessageChannel gsChannel = event.getGuild().getTextChannelsByName("gs-transcripts", true).get(0);
                    gsChannel.sendMessage("New Transcript Uploaded...").addFiles(FileUpload.fromData(gsTranscriptFile)).queue();
                    channel.delete().queueAfter(3, TimeUnit.SECONDS);
                    break;
                case "ts":
                    File tsTranscriptFile = new File("src/main/java/TicketSystem/transcripts/TS_transcript.txt");
                    writeToTranscript(tsTranscriptFile, messages);
                    MessageChannel tsChannel = event.getGuild().getTextChannelsByName("ts-transcripts", true).get(0);
                    tsChannel.sendMessage("New Transcript Uploaded...").addFiles(FileUpload.fromData(tsTranscriptFile)).queue();
                    event.getChannel().asTextChannel().delete().queueAfter(3, TimeUnit.SECONDS);
                    break;
                default:
                    File baTranscriptFile = new File("src/main/java/TicketSystem/transcripts/ba_transcript.txt");
                    writeToTranscript(baTranscriptFile, messages);
                    MessageChannel baChannel = event.getGuild().getTextChannelsByName("ba-transcripts", true).get(0);
                    baChannel.sendMessage("New Transcript Uploaded...").addFiles(FileUpload.fromData(baTranscriptFile)).queue();
                    event.getChannel().asTextChannel().delete().queueAfter(3, TimeUnit.SECONDS);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeToTranscript(File transcriptFile, List<Message> messages) {
        try (FileWriter writer = new FileWriter(transcriptFile)) {
            for (Message message : messages) {
                String content = message.getContentRaw();
                String author = message.getAuthor().getName();
                String timeStamp = message.getTimeCreated().toString();

                writer.write("Author: " + author + "\n");
                writer.write("Timestamp: " + timeStamp + "\n");
                writer.write("Content: " + content + "\n");
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Problem creating transcript file: " + transcriptFile + " " + e);
        }
    }
}
