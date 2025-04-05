package com.craftaro.epicfurnaces.compatibility;

import com.songoda.third_party.com.cryptomorin.xseries.XMaterial;
import com.songoda.skyblock.permission.BasicPermission;
import com.songoda.skyblock.permission.PermissionType;

public class EpicFurnacesPermission extends BasicPermission {
    public EpicFurnacesPermission() {
        super("EpicFurnaces", XMaterial.FIRE_CHARGE, PermissionType.GENERIC);
    }
}
