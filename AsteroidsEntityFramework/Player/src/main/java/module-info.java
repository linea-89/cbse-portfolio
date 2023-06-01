module player {
    requires common;

    uses dk.sdu.mmmi.cbse.common.services.WeaponSPI;

    provides dk.sdu.mmmi.cbse.common.services.IGamePluginService
            with dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;

    provides dk.sdu.mmmi.cbse.common.services.IEntityProcessingService
            with dk.sdu.mmmi.cbse.playersystem.PlayerControlSystem;

}