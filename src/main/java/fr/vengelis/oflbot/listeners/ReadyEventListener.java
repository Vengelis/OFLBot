package fr.vengelis.oflbot.listeners;

import fr.vengelis.oflbot.configurations.Configuration;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyEventListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        JDA jda = event.getJDA();
        Guild guild = jda.getGuildById(Configuration.GUILD.getValue());
        TextChannel textChannel = guild.getTextChannelById(Configuration.LOG_CHANNEL.getValue());
        assert textChannel != null;
        textChannel.sendMessage("OFLBot démarré").queue();
    }
}
