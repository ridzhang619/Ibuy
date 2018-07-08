package com.rid.morgan.inter.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * Create by Morgan on 2018/7/8 0008
 */
public class FontIbuyModule implements IconFontDescriptor{
    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return IbuyIcons.values();
    }
}
