package com.rid.morgan.inter.icon;


import com.joanzapata.iconify.Icon;

/**
 * Create by Morgan on 2018/7/8 0008
 */
public enum  IbuyIcons implements Icon{

    icon_scan('\ue602'),
    icon_ali_pay('\ue606');

    private char character;

    IbuyIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }


    @Override
    public char character() {
        return character;
    }
}
