package com.rid.morgan.inter.app;

import android.os.Handler;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Interceptor;


/**
 * Create by Morgan on 2018/6/26 0026
 */
public class Configurator {


    public static final HashMap<Object,Object> INTER_CONFIGS = new HashMap<>();
    private static final List<Interceptor> INTERCEPTORS = new ArrayList<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();
    private static final Handler HANDLER = new Handler();


    private Configurator(){
        INTER_CONFIGS.put(ConfigType.CONFIG_READY,false);//配置开始,还没有完成
        INTER_CONFIGS.put(ConfigType.HANDLER,HANDLER);
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    final HashMap<Object,Object> getInterConfigs(){
        return INTER_CONFIGS;
    }

    public final void configure(){
        initIcons();
        INTER_CONFIGS.put(ConfigType.CONFIG_READY,true);
    }

    public final Configurator withApiHost(String host){
        INTER_CONFIGS.put(ConfigType.API_HOST,host);
        return this;
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    public final Configurator withInterceptor(Interceptor interceptor){
        INTERCEPTORS.add(interceptor);
        INTER_CONFIGS.put(ConfigType.INTERCEPTOR,INTERCEPTORS);
        return this;
    }

    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors){
        INTERCEPTORS.addAll(interceptors);
        INTER_CONFIGS.put(ConfigType.INTERCEPTOR,INTERCEPTORS);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady = (boolean) INTER_CONFIGS.get(ConfigType.CONFIG_READY);
        if (!isReady){
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key){
        checkConfiguration();
        return (T) INTER_CONFIGS.get(key);
    }

}
