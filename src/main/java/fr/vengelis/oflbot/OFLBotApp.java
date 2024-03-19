package fr.vengelis.oflbot;

import fr.vengelis.oflbot.configurations.Configuration;
import fr.vengelis.oflbot.listeners.ReadyEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import java.util.Arrays;

public class OFLBotApp {

    private static OFLBotApp instance;
    public JDA jda;

    public OFLBotApp() {
        instance = this;

        this.jda = JDABuilder.createLight(Configuration.TOKEN.getValue())
                .addEventListeners(
                        new ReadyEventListener()
                )
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.playing("OFL Bot"))
                .setChunkingFilter(ChunkingFilter.ALL)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .enableIntents(Arrays.asList(GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MEMBERS))
                .enableCache(CacheFlag.ACTIVITY, CacheFlag.MEMBER_OVERRIDES)
                .build();
    }

    public static OFLBotApp get() {
        return instance;
    }
}
