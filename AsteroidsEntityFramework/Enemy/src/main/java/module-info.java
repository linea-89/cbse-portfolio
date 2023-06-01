module enemy {
    requires common;

    provides dk.sdu.mmmi.cbse.common.services.IEntityProcessingService
            with dk.sdu.mmmi.cbse.enemysystem.EnemyControlSystem;

    provides dk.sdu.mmmi.cbse.common.services.IGamePluginService
            with dk.sdu.mmmi.cbse.enemysystem.EnemyPlugin;
}