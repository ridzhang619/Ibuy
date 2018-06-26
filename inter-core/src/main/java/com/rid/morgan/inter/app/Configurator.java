package com.rid.morgan.inter.app;

import java.util.WeakHashMap;

/**
 * Create by Morgan on 2018/6/26 0026
 */
public class Configurator {

    public static final WeakHashMap<String,Object> INTER_CONFIGS = new WeakHashMap<>();

    private Configurator(){
        INTER_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);//配置开始,还没有完成
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    final WeakHashMap<String,Object> getInterConfigs(){
        return INTER_CONFIGS;
    }

    public final void configure(){
        INTER_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    public final Configurator withApiHost(String host){
        INTER_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady = (boolean) INTER_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T) INTER_CONFIGS.get(key.name());
    }

}
