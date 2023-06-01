module weapon {

    requires common;

    provides dk.sdu.mmmi.cbse.common.services.IGamePluginService
            with dk.sdu.mmmi.cbse.weaponsystem.WeaponPlugin;

    provides dk.sdu.mmmi.cbse.common.services.WeaponSPI
            with dk.sdu.mmmi.cbse.weaponsystem.WeaponControlSystem;

    provides dk.sdu.mmmi.cbse.common.services.IEntityProcessingService
            with dk.sdu.mmmi.cbse.weaponsystem.WeaponControlSystem;



}